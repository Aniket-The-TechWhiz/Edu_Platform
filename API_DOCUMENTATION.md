# Education Platform API Flow Documentation

## Key Concepts

### 🎓 Academic Year = Student's Year Level

**Academic Year does NOT mean calendar year (2024-2025)**

It means the **student's position in their course**:
- **First_Year** → 1st year students
- **Second_Year** → 2nd year students
- **Third_Year** → 3rd year students
- **Fourth_Year** → 4th year students

Each year level has its own:
- Programming languages curriculum
- Challenges and problems to solve
- Enrolled students for that year

**Example**: "Second_Year" academic year = All programming languages and challenges that 2nd year CSE students should learn

## Domain Model Architecture

The platform now follows a hierarchical structure for competitive programming challenges:

```
AcademicYear (e.g., "Second_Year")
    ├── ProgrammingLanguage (multiple)
    │   ├── Challenges (multiple)
    │   └── Associated to this year level
    └── Student (multiple - all students in that year)
        ├── StudentSubmission (submissions for challenges)
        └── StudentChallengeProgress (tracking solved/attempted challenges)
```

## Key Features

### 1. **Independent Creation Flow**
- Create Academic Year independently
- Create Programming Languages separately
- Create Challenges independently
- Assign them to years/languages when ready

### 2. **Student Management**
- Students enroll in an Academic Year
- Students view all languages and challenges in their year
- Students submit solutions to challenges

### 3. **Progress Tracking**
- StudentChallengeProgress: Tracks attempt count, solved status, solving time
- StudentSubmission: Stores actual code submissions with status

## API Endpoints

### Academic Year Management
```
POST   /api/academic-year                          Create new academic year
GET    /api/academic-year                          Get all academic years
GET    /api/academic-year/{id}                     Get academic year by ID
PUT    /api/academic-year/{id}                     Update academic year
DELETE /api/academic-year/{id}                     Delete academic year
GET    /api/academic-year/{id}/student-count       Get number of students in year
```

### Programming Language Management
```
POST   /api/languages                              Create language independently
POST   /api/languages/year/{yearId}               Create language for specific year
PUT    /api/languages/{languageId}/assign-year/{yearId}   Assign language to year
GET    /api/languages                              Get all languages
GET    /api/languages/{id}                         Get language by ID
GET    /api/languages/year/{yearId}               Get languages in specific year
GET    /api/languages/name/{name}                 Get language by name
PUT    /api/languages/{id}                         Update language
DELETE /api/languages/{id}                         Delete language
GET    /api/languages/{languageId}/challenge-count Get number of challenges in language
```

### Challenge Management
```
POST   /api/challenges                             Create challenge independently
POST   /api/challenges/language/{languageId}      Create challenge for language
PUT    /api/challenges/{challengeId}/assign-language/{languageId}  Assign challenge to language
GET    /api/challenges                             Get all challenges
GET    /api/challenges/{id}                        Get challenge by ID
GET    /api/challenges/language/{languageId}      Get challenges for language
GET    /api/challenges/difficulty/{difficulty}    Get challenges by difficulty
GET    /api/challenges/language/{languageId}/difficulty/{difficulty}  Get challenges by language and difficulty
GET    /api/challenges/active                      Get active challenges
PUT    /api/challenges/{id}                        Update challenge
DELETE /api/challenges/{id}                        Delete challenge
PUT    /api/challenges/{id}/activate               Activate challenge
PUT    /api/challenges/{id}/deactivate             Deactivate challenge
```

### Student Submission & Progress
```
POST   /api/submissions/student/{studentId}/challenge/{challengeId}  Submit solution
GET    /api/submissions/student/{studentId}       Get all submissions by student
GET    /api/submissions/challenge/{challengeId}   Get all submissions for challenge
GET    /api/submissions/student/{studentId}/challenge/{challengeId}  Get submissions for specific student-challenge
GET    /api/submissions/{id}                      Get submission by ID
GET    /api/submissions/status/{status}           Get submissions by status
GET    /api/submissions/progress/student/{studentId}/challenge/{challengeId}  Get progress for challenge
GET    /api/submissions/progress/student/{studentId}/solved  Get all solved challenges by student
GET    /api/submissions/progress/student/{studentId}/solved-count  Get total solved count
GET    /api/submissions/progress/student/{studentId}/accuracy  Get student accuracy rate
GET    /api/submissions/challenge/{challengeId}/accepted-count  Get accepted submission count
DELETE /api/submissions/{id}                      Delete submission
```

### Student Management
```
POST   /api/students                               Create student
GET    /api/students                               Get all students
GET    /api/students/{id}                          Get student by ID
PUT    /api/students/{id}                          Update student
DELETE /api/students/{id}                          Delete student
GET    /api/students/{id}/curriculum               Get curriculum (languages and challenges)
```

## Complete Workflow Example

### Step 1: Create Academic Year
```bash
POST /api/academic-year
{
  "year": "YEAR_2024_2025"
}
```

### Step 2: Create Programming Languages
```bash
POST /api/languages
{
  "name": "Python"
}

POST /api/languages/year/{academicYearId}
{
  "name": "Java"
}
```

### Step 3: Create Challenges
```bash
POST /api/challenges/language/{pythonLanguageId}
{
  "title": "Two Sum",
  "description": "Find two numbers that add up to target",
  "problemStatement": "Given an array of integers nums and an integer target, return the indices of the two numbers...",
  "difficultyLevel": "EASY",
  "timeLimit": 5,
  "memoryLimit": 256,
  "sampleInput": "[2,7,11,15], target = 9",
  "sampleOutput": "[0,1]",
  "testCases": "[{\"input\": \"[2,7,11,15], 9\", \"output\": \"[0,1]\"}]"
}
```

### Step 4: Create Student
```bash
POST /api/students
{
  "name": "John Doe",
  "email": "john@example.com",
  "rollNumber": "CSE001",
  "academicYear": {
    "id": {academicYearId}
  }
}
```

### Step 5: Student Views Challenges
```bash
GET /api/languages/year/{academicYearId}
GET /api/challenges/language/{pythonLanguageId}
```

### Step 6: Student Submits Solution
```bash
POST /api/submissions/student/{studentId}/challenge/{challengeId}
{
  "submittedCode": "def twoSum(nums, target):\n    ...",
  "status": "SUBMITTED",
  "language": "Python"
}
```

### Step 7: Check Student Progress
```bash
GET /api/submissions/progress/student/{studentId}/solved-count
GET /api/submissions/progress/student/{studentId}/accuracy
GET /api/submissions/progress/student/{studentId}/solved
```

## Data Models

### StudentSubmission
- `id`: Unique identifier
- `student`: Reference to student
- `challenge`: Reference to challenge
- `submittedCode`: The code submitted
- `status`: SUBMITTED, ACCEPTED, WRONG_ANSWER, RUNTIME_ERROR, TIME_LIMIT_EXCEEDED, COMPILATION_ERROR
- `submittedAt`: Timestamp
- `executionTimeMs`: Execution time
- `language`: Programming language used

### StudentChallengeProgress
- `id`: Unique identifier
- `student`: Reference to student
- `challenge`: Reference to challenge
- `attemptCount`: Number of attempts
- `isSolved`: Whether solved
- `firstAttemptAt`: When first attempt was made
- `solvedAt`: When solved (if solved)
- `solvingTimeMinutes`: Time taken to solve

### Challenges (Enhanced)
- All previous fields
- `problemStatement`: Full problem description
- `testCases`: JSON with test cases
- `sampleInput/Output`: Example input/output
- `timeLimit`: Time limit in seconds
- `memoryLimit`: Memory limit in MB
- `acceptedCount`: Number of accepted submissions
- `totalSubmissions`: Total submission count
- `isActive`: Whether challenge is active
- `createdAt/updatedAt`: Timestamps

## Key Advantages of New Architecture

1. **Independent Creation**: Create challenges, languages, and years independently
2. **Flexible Assignment**: Assign resources to years as needed
3. **Progress Tracking**: Complete tracking of student attempts and solutions
4. **Scalability**: Easy to add more languages or challenges
5. **Analytics**: Track student performance and challenge statistics
6. **Like LeetCode**: Students can attempt challenges, track progress, and view statistics
