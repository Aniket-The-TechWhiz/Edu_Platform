# Testing Checklist - Step by Step

## 🎯 Before You Start
- [ ] Application is running on `http://localhost:8080`
- [ ] Postman is open
- [ ] Database is configured in `application.properties`
- [ ] All tables are created (run app once)

---

## ✅ PART 1: Academic Year Testing

### Create First Year
- [ ] **POST** `http://localhost:8080/api/academic-year`
- [ ] **Body**: `{"year": "First_Year"}`
- [ ] **Expected**: Status 201, Returns `id: 1`
- [ ] **Save ID**: Write down `id = 1`

### Create Second Year
- [ ] **POST** `http://localhost:8080/api/academic-year`
- [ ] **Body**: `{"year": "Second_Year"}`
- [ ] **Expected**: Status 201, Returns `id: 2`
- [ ] **Save ID**: Write down `id = 2`

### Get All Years
- [ ] **GET** `http://localhost:8080/api/academic-year`
- [ ] **Expected**: Status 200, Array with 2 items

### Get Year by ID
- [ ] **GET** `http://localhost:8080/api/academic-year/1`
- [ ] **Expected**: Status 200, Returns First_Year details

### Update Year
- [ ] **PUT** `http://localhost:8080/api/academic-year/2`
- [ ] **Body**: `{"year": "Third_Year"}`
- [ ] **Expected**: Status 200, Year updated

### Get Student Count
- [ ] **GET** `http://localhost:8080/api/academic-year/1/student-count`
- [ ] **Expected**: Status 200, Returns `{"studentCount": 0}`

---

## ✅ PART 2: Programming Language Testing

### Create Python (Independent)
- [ ] **POST** `http://localhost:8080/api/languages`
- [ ] **Body**: `{"name": "Python"}`
- [ ] **Expected**: Status 201, Returns `id: 1`
- [ ] **Save ID**: Write down `python_id = 1`

### Create Java for First Year
- [ ] **POST** `http://localhost:8080/api/languages/year/1`
- [ ] **Body**: `{"name": "Java"}`
- [ ] **Expected**: Status 201, Returns `id: 2`
- [ ] **Save ID**: Write down `java_id = 2`

### Assign Python to First Year
- [ ] **PUT** `http://localhost:8080/api/languages/1/assign-year/1`
- [ ] **Expected**: Status 200, Python assigned to First_Year

### Get All Languages
- [ ] **GET** `http://localhost:8080/api/languages`
- [ ] **Expected**: Status 200, Array with 2+ languages

### Get Languages in Year 1
- [ ] **GET** `http://localhost:8080/api/languages/year/1`
- [ ] **Expected**: Status 200, Array with Python and Java

### Get Language by Name
- [ ] **GET** `http://localhost:8080/api/languages/name/Python`
- [ ] **Expected**: Status 200, Returns Python details

### Update Language
- [ ] **PUT** `http://localhost:8080/api/languages/1`
- [ ] **Body**: `{"name": "Python 3.9"}`
- [ ] **Expected**: Status 200, Name updated

### Get Challenge Count
- [ ] **GET** `http://localhost:8080/api/languages/1/challenge-count`
- [ ] **Expected**: Status 200, `{"challengeCount": 0}`

---

## ✅ PART 3: Challenge Testing

### Create Challenge for Python
- [ ] **POST** `http://localhost:8080/api/challenges/language/1`
- [ ] **Body**:
```json
{
  "title": "Two Sum",
  "description": "Find two numbers that add up to target",
  "problemStatement": "Given array and target, find indices",
  "difficultyLevel": "EASY",
  "timeLimit": 5,
  "memoryLimit": 256,
  "sampleInput": "[2,7,11,15], 9",
  "sampleOutput": "[0,1]",
  "testCases": "[{\"input\": \"[2,7,11,15], 9\", \"output\": \"[0,1]\"}]"
}
```
- [ ] **Expected**: Status 201, Returns `id: 1`
- [ ] **Save ID**: Write down `challenge1_id = 1`

### Create Another Challenge
- [ ] **POST** `http://localhost:8080/api/challenges/language/1`
- [ ] **Body**:
```json
{
  "title": "Array Sum",
  "description": "Sum all elements",
  "problemStatement": "Return sum of array",
  "difficultyLevel": "EASY",
  "timeLimit": 3,
  "memoryLimit": 256,
  "sampleInput": "[1,2,3]",
  "sampleOutput": "6",
  "testCases": "[{\"input\": \"[1,2,3]\", \"output\": \"6\"}]"
}
```
- [ ] **Expected**: Status 201, Returns `id: 2`
- [ ] **Save ID**: Write down `challenge2_id = 2`

### Create Medium Challenge
- [ ] **POST** `http://localhost:8080/api/challenges/language/2`
- [ ] **Body**: (Same as above but `difficultyLevel: "MEDIUM"`)
- [ ] **Expected**: Status 201, Returns `id: 3`

### Get All Challenges
- [ ] **GET** `http://localhost:8080/api/challenges`
- [ ] **Expected**: Status 200, Array with 3+ challenges

### Get Challenges by Language
- [ ] **GET** `http://localhost:8080/api/challenges/language/1`
- [ ] **Expected**: Status 200, Returns 2 challenges (Two Sum, Array Sum)

### Get Challenges by Difficulty
- [ ] **GET** `http://localhost:8080/api/challenges/difficulty/EASY`
- [ ] **Expected**: Status 200, Returns 2 EASY challenges

### Get by Language & Difficulty
- [ ] **GET** `http://localhost:8080/api/challenges/language/1/difficulty/EASY`
- [ ] **Expected**: Status 200, Returns 2 challenges

### Get Active Challenges
- [ ] **GET** `http://localhost:8080/api/challenges/active`
- [ ] **Expected**: Status 200, Returns all 3 challenges

### Update Challenge
- [ ] **PUT** `http://localhost:8080/api/challenges/1`
- [ ] **Body**:
```json
{
  "title": "Two Sum Updated",
  "description": "Find efficiently",
  "problemStatement": "Find two sum",
  "difficultyLevel": "MEDIUM",
  "timeLimit": 4,
  "memoryLimit": 512,
  "sampleInput": "[2,7,11,15], 9",
  "sampleOutput": "[0,1]",
  "testCases": "[{\"input\": \"[2,7,11,15], 9\", \"output\": \"[0,1]\"}]"
}
```
- [ ] **Expected**: Status 200, Challenge updated

### Deactivate Challenge
- [ ] **PUT** `http://localhost:8080/api/challenges/2/deactivate`
- [ ] **Expected**: Status 200

### Activate Challenge
- [ ] **PUT** `http://localhost:8080/api/challenges/2/activate`
- [ ] **Expected**: Status 200

---

## ✅ PART 4: Student Testing

### Create Student 1
- [ ] **POST** `http://localhost:8080/api/students`
- [ ] **Body**:
```json
{
  "name": "John Doe",
  "email": "john@college.com",
  "rollNumber": "CSE001",
  "academicYear": {"id": 1}
}
```
- [ ] **Expected**: Status 201, Returns `id: 1`
- [ ] **Save ID**: Write down `student1_id = 1`

### Create Student 2
- [ ] **POST** `http://localhost:8080/api/students`
- [ ] **Body**:
```json
{
  "name": "Jane Smith",
  "email": "jane@college.com",
  "rollNumber": "CSE002",
  "academicYear": {"id": 1}
}
```
- [ ] **Expected**: Status 201, Returns `id: 2`
- [ ] **Save ID**: Write down `student2_id = 2`

### Get All Students
- [ ] **GET** `http://localhost:8080/api/students`
- [ ] **Expected**: Status 200, Array with 2 students

### Get Student by ID
- [ ] **GET** `http://localhost:8080/api/students/1`
- [ ] **Expected**: Status 200, Returns John Doe

### Get Student Curriculum
- [ ] **GET** `http://localhost:8080/api/students/1/curriculum`
- [ ] **Expected**: Status 200, Shows First_Year with languages and challenges

### Update Student
- [ ] **PUT** `http://localhost:8080/api/students/1`
- [ ] **Body**:
```json
{
  "name": "John Doe Updated",
  "email": "johndoe@college.com",
  "rollNumber": "CSE001"
}
```
- [ ] **Expected**: Status 200, Name updated

### Get Student Count Again
- [ ] **GET** `http://localhost:8080/api/academic-year/1/student-count`
- [ ] **Expected**: Status 200, `{"studentCount": 2}`

---

## ✅ PART 5: Submission & Progress Testing

### Submit Solution (Accepted)
- [ ] **POST** `http://localhost:8080/api/submissions/student/1/challenge/1`
- [ ] **Body**:
```json
{
  "submittedCode": "def twoSum(nums, target):\n    seen = {}\n    for i, num in enumerate(nums):\n        if target - num in seen:\n            return [seen[target-num], i]\n        seen[num] = i",
  "status": "ACCEPTED",
  "testOutput": "[0,1]",
  "expectedOutput": "[0,1]",
  "language": "Python",
  "executionTimeMs": 125
}
```
- [ ] **Expected**: Status 201, Returns `id: 1`
- [ ] **Save ID**: Write down `submission1_id = 1`

### Submit Wrong Answer
- [ ] **POST** `http://localhost:8080/api/submissions/student/1/challenge/1`
- [ ] **Body**: (Same but `status: "WRONG_ANSWER"`)
- [ ] **Expected**: Status 201, Returns `id: 2`

### Submit Second Challenge (Accepted)
- [ ] **POST** `http://localhost:8080/api/submissions/student/1/challenge/2`
- [ ] **Body**: (Similar but different challenge)
- [ ] **Expected**: Status 201, Returns `id: 3`

### Get Submissions by Student
- [ ] **GET** `http://localhost:8080/api/submissions/student/1`
- [ ] **Expected**: Status 200, Array with 3 submissions

### Get Submissions by Challenge
- [ ] **GET** `http://localhost:8080/api/submissions/challenge/1`
- [ ] **Expected**: Status 200, Array with 2 submissions

### Get Submissions by Status
- [ ] **GET** `http://localhost:8080/api/submissions/status/ACCEPTED`
- [ ] **Expected**: Status 200, Array with accepted submissions

### Get Challenge Progress
- [ ] **GET** `http://localhost:8080/api/submissions/progress/student/1/challenge/1`
- [ ] **Expected**: Status 200, Shows `attemptCount: 2`, `isSolved: true`

### Get Solved Challenges
- [ ] **GET** `http://localhost:8080/api/submissions/progress/student/1/solved`
- [ ] **Expected**: Status 200, Array with 2 solved challenges

### Get Solved Count
- [ ] **GET** `http://localhost:8080/api/submissions/progress/student/1/solved-count`
- [ ] **Expected**: Status 200, `{"totalSolved": 2}`

### Get Accuracy Rate
- [ ] **GET** `http://localhost:8080/api/submissions/progress/student/1/accuracy`
- [ ] **Expected**: Status 200, `{"accuracy": 66.67}`

### Get Challenge Accepted Count
- [ ] **GET** `http://localhost:8080/api/submissions/challenge/1/accepted-count`
- [ ] **Expected**: Status 200, `{"acceptedCount": 1}`

---

## ✅ PART 6: Delete Operations

### Delete Submission
- [ ] **DELETE** `http://localhost:8080/api/submissions/3`
- [ ] **Expected**: Status 204

### Delete Student
- [ ] **DELETE** `http://localhost:8080/api/students/2`
- [ ] **Expected**: Status 200, Message shown

### Delete Challenge
- [ ] **DELETE** `http://localhost:8080/api/challenges/3`
- [ ] **Expected**: Status 204

### Delete Language
- [ ] **DELETE** `http://localhost:8080/api/languages/2`
- [ ] **Expected**: Status 204

### Delete Academic Year
- [ ] **DELETE** `http://localhost:8080/api/academic-year/2`
- [ ] **Expected**: Status 200, Message shown

---

## 🎉 Summary

- [ ] All 47+ endpoints tested
- [ ] All CRUD operations working
- [ ] All assignments working
- [ ] Progress tracking working
- [ ] Statistics calculation working
- [ ] Database properly storing data
- [ ] Responses have correct status codes
- [ ] Error handling working

---

## 📝 Notes

**Write down your IDs here for reference:**
```
Year 1 ID: _____
Year 2 ID: _____
Python ID: _____
Java ID: _____
Challenge 1 ID: _____
Challenge 2 ID: _____
Student 1 ID: _____
Student 2 ID: _____
Submission 1 ID: _____
```

---

## 🚀 You're Done!

When all checkboxes are checked, your platform is fully tested and ready for:
- ✅ Frontend integration
- ✅ Code execution engine
- ✅ Authentication layer
- ✅ Production deployment

---

**Great job testing your Education Platform! 🎓**
