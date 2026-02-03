# API Quick Copy-Paste Reference for Postman

## 🚀 Quick Start - Copy & Paste Ready

### Base URL
```
http://localhost:8080
```

All requests use header: `Content-Type: application/json`

---

## 1️⃣ ACADEMIC YEAR - All Operations

### CREATE Academic Year
```
POST http://localhost:8080/api/academic-year
```
```json
{
  "year": "First_Year"
}
```

### GET All Academic Years
```
GET http://localhost:8080/api/academic-year
```

### GET Academic Year by ID
```
GET http://localhost:8080/api/academic-year/1
```

### UPDATE Academic Year
```
PUT http://localhost:8080/api/academic-year/1
```
```json
{
  "year": "Second_Year"
}
```

### DELETE Academic Year
```
DELETE http://localhost:8080/api/academic-year/1
```

### GET Student Count
```
GET http://localhost:8080/api/academic-year/1/student-count
```

---

## 2️⃣ PROGRAMMING LANGUAGE - All Operations

### CREATE Language (Independent)
```
POST http://localhost:8080/api/languages
```
```json
{
  "name": "Python"
}
```

### CREATE Language for Year
```
POST http://localhost:8080/api/languages/year/1
```
```json
{
  "name": "Java"
}
```

### ASSIGN Language to Year
```
PUT http://localhost:8080/api/languages/1/assign-year/1
```

### GET All Languages
```
GET http://localhost:8080/api/languages
```

### GET Language by ID
```
GET http://localhost:8080/api/languages/1
```

### GET Languages by Year
```
GET http://localhost:8080/api/languages/year/1
```

### GET Language by Name
```
GET http://localhost:8080/api/languages/name/Python
```

### UPDATE Language
```
PUT http://localhost:8080/api/languages/1
```
```json
{
  "name": "Python 3.9"
}
```

### DELETE Language
```
DELETE http://localhost:8080/api/languages/1
```

### GET Challenge Count
```
GET http://localhost:8080/api/languages/1/challenge-count
```

---

## 3️⃣ CHALLENGE - All Operations

### CREATE Challenge (Independent)
```
POST http://localhost:8080/api/challenges
```
```json
{
  "title": "Two Sum",
  "description": "Find two numbers that add up to target",
  "problemStatement": "Given an array of integers and a target, find indices of two numbers that add up to target",
  "difficultyLevel": "EASY",
  "timeLimit": 5,
  "memoryLimit": 256,
  "sampleInput": "[2,7,11,15], target = 9",
  "sampleOutput": "[0,1]",
  "testCases": "[{\"input\": \"[2,7,11,15], 9\", \"output\": \"[0,1]\"}]"
}
```

### CREATE Challenge for Language
```
POST http://localhost:8080/api/challenges/language/1
```
```json
{
  "title": "Array Sum",
  "description": "Sum all elements in array",
  "problemStatement": "Given array, return sum",
  "difficultyLevel": "EASY",
  "timeLimit": 3,
  "memoryLimit": 256,
  "sampleInput": "[1,2,3]",
  "sampleOutput": "6",
  "testCases": "[{\"input\": \"[1,2,3]\", \"output\": \"6\"}]"
}
```

### ASSIGN Challenge to Language
```
PUT http://localhost:8080/api/challenges/1/assign-language/1
```

### GET All Challenges
```
GET http://localhost:8080/api/challenges
```

### GET Challenge by ID
```
GET http://localhost:8080/api/challenges/1
```

### GET Challenges by Language
```
GET http://localhost:8080/api/challenges/language/1
```

### GET Challenges by Difficulty
```
GET http://localhost:8080/api/challenges/difficulty/EASY
```
**Difficulty values**: `EASY`, `MEDIUM`, `HARD`

### GET Challenges by Language & Difficulty
```
GET http://localhost:8080/api/challenges/language/1/difficulty/EASY
```

### GET Active Challenges
```
GET http://localhost:8080/api/challenges/active
```

### UPDATE Challenge
```
PUT http://localhost:8080/api/challenges/1
```
```json
{
  "title": "Updated Two Sum",
  "description": "Find two numbers efficiently",
  "problemStatement": "Given array and target, return indices",
  "difficultyLevel": "MEDIUM",
  "timeLimit": 4,
  "memoryLimit": 512,
  "sampleInput": "[2,7,11,15], target = 9",
  "sampleOutput": "[0,1]",
  "testCases": "[{\"input\": \"[2,7,11,15], 9\", \"output\": \"[0,1]\"}]"
}
```

### DELETE Challenge
```
DELETE http://localhost:8080/api/challenges/1
```

### ACTIVATE Challenge
```
PUT http://localhost:8080/api/challenges/1/activate
```

### DEACTIVATE Challenge
```
PUT http://localhost:8080/api/challenges/1/deactivate
```

---

## 4️⃣ STUDENT - All Operations

### CREATE Student
```
POST http://localhost:8080/api/students
```
```json
{
  "name": "John Doe",
  "email": "john@college.com",
  "rollNumber": "CSE001",
  "academicYear": {
    "id": 1
  }
}
```

### GET All Students
```
GET http://localhost:8080/api/students
```

### GET Student by ID
```
GET http://localhost:8080/api/students/1
```

### GET Student Curriculum
```
GET http://localhost:8080/api/students/1/curriculum
```

### UPDATE Student
```
PUT http://localhost:8080/api/students/1
```
```json
{
  "name": "John Doe Updated",
  "email": "johndoe@college.com",
  "rollNumber": "CSE001"
}
```

### DELETE Student
```
DELETE http://localhost:8080/api/students/1
```

---

## 5️⃣ SUBMISSION & PROGRESS - All Operations

### SUBMIT Solution
```
POST http://localhost:8080/api/submissions/student/1/challenge/1
```
```json
{
  "submittedCode": "def twoSum(nums, target):\n    seen = {}\n    for i, num in enumerate(nums):\n        if target - num in seen:\n            return [seen[target-num], i]\n        seen[num] = i\n    return []",
  "status": "ACCEPTED",
  "testOutput": "[0,1]",
  "expectedOutput": "[0,1]",
  "language": "Python",
  "executionTimeMs": 125
}
```

**Status values**: `SUBMITTED`, `ACCEPTED`, `WRONG_ANSWER`, `RUNTIME_ERROR`, `TIME_LIMIT_EXCEEDED`, `COMPILATION_ERROR`

### GET Submissions by Student
```
GET http://localhost:8080/api/submissions/student/1
```

### GET Submissions by Challenge
```
GET http://localhost:8080/api/submissions/challenge/1
```

### GET Submissions by Student & Challenge
```
GET http://localhost:8080/api/submissions/student/1/challenge/1
```

### GET Submission by ID
```
GET http://localhost:8080/api/submissions/1
```

### GET Submissions by Status
```
GET http://localhost:8080/api/submissions/status/ACCEPTED
```

### GET Challenge Progress
```
GET http://localhost:8080/api/submissions/progress/student/1/challenge/1
```

### GET Solved Challenges
```
GET http://localhost:8080/api/submissions/progress/student/1/solved
```

### GET Solved Count
```
GET http://localhost:8080/api/submissions/progress/student/1/solved-count
```

### GET Accuracy Rate
```
GET http://localhost:8080/api/submissions/progress/student/1/accuracy
```

### GET Accepted Count for Challenge
```
GET http://localhost:8080/api/submissions/challenge/1/accepted-count
```

### DELETE Submission
```
DELETE http://localhost:8080/api/submissions/1
```

---

## 🔄 Perfect Testing Order (Step by Step)

1. **Create Academic Years**
   - POST → First_Year
   - POST → Second_Year
   - GET all to verify

2. **Create Languages**
   - POST → Python (independent)
   - POST for year/1 → Java
   - GET /year/1 to verify

3. **Create Challenges**
   - POST /language/1 → Two Sum
   - POST /language/2 → Another challenge
   - GET /language/1 to verify

4. **Create Students**
   - POST → Student 1 in First_Year
   - POST → Student 2 in First_Year
   - GET curriculum to see

5. **Submit Solutions**
   - POST submission for student 1
   - POST submission for student 2
   - GET /student/1 to see all

6. **Check Progress**
   - GET solved-count
   - GET accuracy
   - GET solved list

---

## 📊 Response Status Codes

| Code | Meaning |
|------|---------|
| 200 | OK - Successful GET/PUT |
| 201 | Created - Successful POST |
| 204 | No Content - Successful DELETE |
| 404 | Not Found - Invalid ID |
| 400 | Bad Request - Invalid data |
| 500 | Server Error |

---

## ⚠️ Common Mistakes to Avoid

1. **Missing Academic Year ID** - Always create year first
2. **Wrong Language ID** - Use correct ID from previous request
3. **Typo in difficulty** - Use `EASY`, `MEDIUM`, `HARD` exactly
4. **Forgetting year assignment** - Assign language to year after creation
5. **Wrong status values** - Use exact status names

---

## 💡 Pro Tips

- Save the `id` from response and use in next request
- Test GET before POST to see empty data
- Test DELETE on created resources
- All endpoints support proper HTTP status codes
- Check error messages in response body

---

**You now have ALL 47+ API endpoints ready to test! 🚀**
