# Education Platform - Quick Start Guide

## 🚀 Getting Started

This is a competitive programming education platform similar to LeetCode, built with Spring Boot.

## 🎓 Important: What is "Academic Year"?

**Academic Year** means the **student's year level in their course**:
- **First_Year** = 1st year students
- **Second_Year** = 2nd year students  
- **Third_Year** = 3rd year students
- **Fourth_Year** = 4th year students

**NOT** calendar years like 2024-2025!

Example: A curriculum for "First_Year" CSE students will have all the programming languages and challenges they need to study in their first year.

## Prerequisites

- Java 11+
- Maven 3.6+
- MySQL/PostgreSQL (or H2 for testing)
- IDE (VS Code, IntelliJ IDEA, etc.)

## Installation & Setup

### 1. Build the Project
```bash
mvn clean install
```

### 2. Configure Database
Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/education_platform
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

The API will be available at: `http://localhost:8080`

## 📚 Complete API Workflow

### Step 1: Create an Academic Year

**Academic Year = Student Level (First_Year, Second_Year, etc.)**

```bash
curl -X POST http://localhost:8080/api/academic-year \
  -H "Content-Type: application/json" \
  -d '{
    "year": "First_Year"
  }'
```

Response:
```json
{
  "id": 1,
  "year": "First_Year",
  "programmingLanguages": []
}
```

### Step 2: Create Programming Languages
```bash
# Create Python language
curl -X POST http://localhost:8080/api/languages \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Python"
  }'

# Assign it to the academic year
curl -X PUT http://localhost:8080/api/languages/1/assign-year/1 \
  -H "Content-Type: application/json"
```

### Step 3: Create Challenges for a Language
```bash
curl -X POST http://localhost:8080/api/challenges/language/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Two Sum",
    "description": "Find two numbers that add up to target",
    "problemStatement": "Given an array of integers nums and an integer target, return the indices of the two numbers that add up to target.",
    "difficultyLevel": "EASY",
    "timeLimit": 5,
    "memoryLimit": 256,
    "sampleInput": "[2,7,11,15], target = 9",
    "sampleOutput": "[0,1]",
    "testCases": "[{\"input\": \"[2,7,11,15], 9\", \"output\": \"[0,1]\"}]"
  }'
```

### Step 4: Create a Student
```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john@example.com",
    "rollNumber": "CS001",
    "academicYear": {
      "id": 1
    }
  }'
```

### Step 5: Student Views Available Challenges
```bash
# Get languages in the student's year
curl http://localhost:8080/api/languages/year/1

# Get challenges for a language
curl http://localhost:8080/api/challenges/language/1
```

### Step 6: Submit a Solution
```bash
curl -X POST http://localhost:8080/api/submissions/student/1/challenge/1 \
  -H "Content-Type: application/json" \
  -d '{
    "submittedCode": "def twoSum(nums, target):\n    seen = {}\n    for i, num in enumerate(nums):\n        if target - num in seen:\n            return [seen[target - num], i]\n        seen[num] = i\n    return []",
    "status": "ACCEPTED",
    "language": "Python",
    "testOutput": "[0,1]"
  }'
```

### Step 7: Check Student Progress
```bash
# Get solved challenges
curl http://localhost:8080/api/submissions/progress/student/1/solved

# Get total solved count
curl http://localhost:8080/api/submissions/progress/student/1/solved-count

# Get accuracy rate
curl http://localhost:8080/api/submissions/progress/student/1/accuracy
```

## 🔌 Complete Endpoint Reference

### Academic Year
| Method | Endpoint | Purpose |
|--------|----------|---------|
| POST | `/api/academic-year` | Create new year |
| GET | `/api/academic-year` | List all years |
| GET | `/api/academic-year/{id}` | Get year details |
| PUT | `/api/academic-year/{id}` | Update year |
| DELETE | `/api/academic-year/{id}` | Delete year |
| GET | `/api/academic-year/{id}/student-count` | Count students |

### Programming Language
| Method | Endpoint | Purpose |
|--------|----------|---------|
| POST | `/api/languages` | Create language |
| POST | `/api/languages/year/{yearId}` | Create & assign to year |
| PUT | `/api/languages/{id}/assign-year/{yearId}` | Assign to year |
| GET | `/api/languages` | List all languages |
| GET | `/api/languages/{id}` | Get language details |
| GET | `/api/languages/year/{yearId}` | Get languages in year |
| GET | `/api/languages/name/{name}` | Find by name |
| PUT | `/api/languages/{id}` | Update language |
| DELETE | `/api/languages/{id}` | Delete language |

### Challenge
| Method | Endpoint | Purpose |
|--------|----------|---------|
| POST | `/api/challenges` | Create independently |
| POST | `/api/challenges/language/{langId}` | Create for language |
| PUT | `/api/challenges/{id}/assign-language/{langId}` | Assign to language |
| GET | `/api/challenges` | List all |
| GET | `/api/challenges/{id}` | Get details |
| GET | `/api/challenges/language/{langId}` | Get by language |
| GET | `/api/challenges/difficulty/{level}` | Get by difficulty |
| GET | `/api/challenges/active` | Get active only |
| PUT | `/api/challenges/{id}` | Update |
| DELETE | `/api/challenges/{id}` | Delete |
| PUT | `/api/challenges/{id}/activate` | Activate |
| PUT | `/api/challenges/{id}/deactivate` | Deactivate |

### Student
| Method | Endpoint | Purpose |
|--------|----------|---------|
| POST | `/api/students` | Create/enroll student |
| GET | `/api/students` | List all students |
| GET | `/api/students/{id}` | Get student details |
| GET | `/api/students/{id}/curriculum` | Get curriculum |
| PUT | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete student |

### Submission & Progress
| Method | Endpoint | Purpose |
|--------|----------|---------|
| POST | `/api/submissions/student/{sid}/challenge/{cid}` | Submit solution |
| GET | `/api/submissions/student/{studentId}` | Get submissions |
| GET | `/api/submissions/challenge/{challengeId}` | Get submissions for challenge |
| GET | `/api/submissions/{id}` | Get submission details |
| GET | `/api/submissions/status/{status}` | Filter by status |
| GET | `/api/submissions/progress/student/{sid}/solved` | Get solved challenges |
| GET | `/api/submissions/progress/student/{sid}/solved-count` | Count solved |
| GET | `/api/submissions/progress/student/{sid}/accuracy` | Get accuracy % |
| DELETE | `/api/submissions/{id}` | Delete submission |

## 📝 Sample Request/Response

### Create Challenge
**Request:**
```json
{
  "title": "Reverse String",
  "description": "Reverse a string in-place",
  "problemStatement": "Write a function that reverses a string.",
  "difficultyLevel": "EASY",
  "timeLimit": 3,
  "memoryLimit": 128,
  "sampleInput": "\"hello\"",
  "sampleOutput": "\"olleh\"",
  "testCases": "[{\"input\": \"hello\", \"output\": \"olleh\"}]"
}
```

**Response (201 Created):**
```json
{
  "id": 2,
  "title": "Reverse String",
  "description": "Reverse a string in-place",
  "difficultyLevel": "EASY",
  "timeLimit": 3,
  "memoryLimit": 128,
  "createdAt": "2024-02-03T10:30:00",
  "isActive": true,
  "acceptedCount": 0,
  "totalSubmissions": 0
}
```

### Submit Solution
**Request:**
```json
{
  "submittedCode": "def reverseString(s):\n    return s[::-1]",
  "status": "ACCEPTED",
  "language": "Python",
  "testOutput": "olleh",
  "executionTimeMs": 145
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "status": "ACCEPTED",
  "submittedAt": "2024-02-03T10:35:00",
  "submittedCode": "def reverseString(s):\n    return s[::-1]",
  "language": "Python",
  "executionTimeMs": 145
}
```

## 🧪 Testing with Postman

1. Import the API endpoints into Postman
2. Create collection for each resource type
3. Test the flow:
   - Create Academic Year
   - Create Language
   - Create Challenge
   - Create Student
   - Submit Solution
   - Check Progress

## 🔐 Next Steps

1. **Code Compilation**: Implement actual code execution
2. **Authentication**: Add JWT/Spring Security
3. **Frontend**: Build React/Vue dashboard
4. **CI/CD**: Setup GitHub Actions
5. **Docker**: Containerize the application

## 📖 Documentation Files

- [API_DOCUMENTATION.md](./API_DOCUMENTATION.md) - Complete API docs
- [ARCHITECTURE.md](./ARCHITECTURE.md) - System architecture

## ❓ Troubleshooting

### Error: AcademicYear not found
Make sure you created the academic year first and use the correct ID.

### Error: Circular reference
This is fixed in the refactored code with proper @JsonIgnoreProperties annotations.

### Error: Lazy initialization exception
Services use @Transactional to keep sessions open. Ensure you're calling services, not repositories directly from controller.

## 📞 Support

For issues or questions, refer to the documentation files or check the service implementations.
