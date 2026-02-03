# cURL Commands - Complete Testing Guide

## Base URL
```
http://localhost:8080
```

---

# 1️⃣ ACADEMIC YEAR ENDPOINTS

## Create First_Year
```bash
curl -X POST http://localhost:8080/api/academic-year \
  -H "Content-Type: application/json" \
  -d '{
    "year": "First_Year"
  }'
```

## Create Second_Year
```bash
curl -X POST http://localhost:8080/api/academic-year \
  -H "Content-Type: application/json" \
  -d '{
    "year": "Second_Year"
  }'
```

## Create Third_Year
```bash
curl -X POST http://localhost:8080/api/academic-year \
  -H "Content-Type: application/json" \
  -d '{
    "year": "Third_Year"
  }'
```

## Get All Academic Years
```bash
curl -X GET http://localhost:8080/api/academic-year
```

## Get Academic Year by ID (ID: 1)
```bash
curl -X GET http://localhost:8080/api/academic-year/1
```

## Update Academic Year
```bash
curl -X PUT http://localhost:8080/api/academic-year/1 \
  -H "Content-Type: application/json" \
  -d '{
    "year": "First_Year"
  }'
```

## Delete Academic Year
```bash
curl -X DELETE http://localhost:8080/api/academic-year/1
```

## Get Student Count for Year
```bash
curl -X GET http://localhost:8080/api/academic-year/1/student-count
```

---

# 2️⃣ PROGRAMMING LANGUAGE ENDPOINTS

## Create Python Language
```bash
curl -X POST http://localhost:8080/api/languages \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Python"
  }'
```

## Create Java Language
```bash
curl -X POST http://localhost:8080/api/languages \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Java"
  }'
```

## Create C++ Language
```bash
curl -X POST http://localhost:8080/api/languages \
  -H "Content-Type: application/json" \
  -d '{
    "name": "C++"
  }'
```

## Create Language for Specific Year
```bash
curl -X POST http://localhost:8080/api/languages/year/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "JavaScript"
  }'
```

## Assign Language to Year (Language ID: 1, Year ID: 1)
```bash
curl -X PUT http://localhost:8080/api/languages/1/assign-year/1 \
  -H "Content-Type: application/json"
```

## Get All Languages
```bash
curl -X GET http://localhost:8080/api/languages
```

## Get Language by ID
```bash
curl -X GET http://localhost:8080/api/languages/1
```

## Get Languages by Year
```bash
curl -X GET http://localhost:8080/api/languages/year/1
```

## Get Language by Name
```bash
curl -X GET http://localhost:8080/api/languages/name/Python
```

## Update Language
```bash
curl -X PUT http://localhost:8080/api/languages/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Python3"
  }'
```

## Delete Language
```bash
curl -X DELETE http://localhost:8080/api/languages/1
```

## Get Challenge Count for Language
```bash
curl -X GET http://localhost:8080/api/languages/1/challenge-count
```

---

# 3️⃣ CHALLENGE ENDPOINTS

## Create Challenge Independently
```bash
curl -X POST http://localhost:8080/api/challenges \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Independent Challenge",
    "description": "A challenge created independently",
    "problemStatement": "Solve this problem...",
    "difficultyLevel": "EASY",
    "timeLimit": 5,
    "memoryLimit": 256,
    "sampleInput": "input",
    "sampleOutput": "output",
    "testCases": "[{\"input\": \"test\", \"output\": \"output\"}]"
  }'
```

## Create Challenge for Language (Language ID: 1)
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
    "sampleInput": "nums = [2,7,11,15], target = 9",
    "sampleOutput": "[0,1]",
    "testCases": "[{\"input\": \"[2,7,11,15], 9\", \"output\": \"[0,1]\"}]"
  }'
```

## Create Reverse String Challenge
```bash
curl -X POST http://localhost:8080/api/challenges/language/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Reverse String",
    "description": "Reverse a string",
    "problemStatement": "Write a function that reverses a string.",
    "difficultyLevel": "EASY",
    "timeLimit": 3,
    "memoryLimit": 128,
    "sampleInput": "s = [\"h\",\"e\",\"l\",\"l\",\"o\"]",
    "sampleOutput": "[\"o\",\"l\",\"l\",\"e\",\"h\"]",
    "testCases": "[{\"input\": \"hello\", \"output\": \"olleh\"}]"
  }'
```

## Create Linked List Cycle Challenge
```bash
curl -X POST http://localhost:8080/api/challenges/language/2 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Linked List Cycle",
    "description": "Detect if there is a cycle in a linked list",
    "problemStatement": "Given head, determine if the linked list has a cycle in it.",
    "difficultyLevel": "MEDIUM",
    "timeLimit": 5,
    "memoryLimit": 256,
    "sampleInput": "head = [3,2,0,-4], pos = 1",
    "sampleOutput": "true",
    "testCases": "[{\"input\": \"[3,2,0,-4], pos = 1\", \"output\": \"true\"}]"
  }'
```

## Assign Challenge to Language (Challenge ID: 1, Language ID: 1)
```bash
curl -X PUT http://localhost:8080/api/challenges/1/assign-language/1 \
  -H "Content-Type: application/json"
```

## Get All Challenges
```bash
curl -X GET http://localhost:8080/api/challenges
```

## Get Challenge by ID
```bash
curl -X GET http://localhost:8080/api/challenges/1
```

## Get Challenges by Language (Language ID: 1)
```bash
curl -X GET http://localhost:8080/api/challenges/language/1
```

## Get Challenges by Difficulty (EASY, MEDIUM, HARD, VERY_HARD)
```bash
curl -X GET http://localhost:8080/api/challenges/difficulty/EASY
```

## Get Challenges by Language and Difficulty
```bash
curl -X GET http://localhost:8080/api/challenges/language/1/difficulty/EASY
```

## Get Active Challenges Only
```bash
curl -X GET http://localhost:8080/api/challenges/active
```

## Update Challenge
```bash
curl -X PUT http://localhost:8080/api/challenges/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Two Sum - Updated",
    "description": "Updated description",
    "problemStatement": "Updated problem statement",
    "difficultyLevel": "EASY",
    "timeLimit": 5,
    "memoryLimit": 256,
    "sampleInput": "nums = [2,7,11,15], target = 9",
    "sampleOutput": "[0,1]",
    "testCases": "[{\"input\": \"[2,7,11,15], 9\", \"output\": \"[0,1]\"}]"
  }'
```

## Activate Challenge
```bash
curl -X PUT http://localhost:8080/api/challenges/1/activate
```

## Deactivate Challenge
```bash
curl -X PUT http://localhost:8080/api/challenges/1/deactivate
```

## Delete Challenge
```bash
curl -X DELETE http://localhost:8080/api/challenges/1
```

---

# 4️⃣ STUDENT ENDPOINTS

## Create Student (Enroll in First_Year)
```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john.doe@college.com",
    "rollNumber": "CSE001",
    "academicYear": {
      "id": 1
    }
  }'
```

## Create Another Student
```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Jane Smith",
    "email": "jane.smith@college.com",
    "rollNumber": "CSE002",
    "academicYear": {
      "id": 1
    }
  }'
```

## Create Second Year Student
```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Bob Wilson",
    "email": "bob.wilson@college.com",
    "rollNumber": "CSE051",
    "academicYear": {
      "id": 2
    }
  }'
```

## Get All Students
```bash
curl -X GET http://localhost:8080/api/students
```

## Get Student by ID
```bash
curl -X GET http://localhost:8080/api/students/1
```

## Get Student Curriculum (Languages & Challenges for their year)
```bash
curl -X GET http://localhost:8080/api/students/1/curriculum
```

## Update Student Information
```bash
curl -X PUT http://localhost:8080/api/students/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe Updated",
    "email": "john.updated@college.com",
    "rollNumber": "CSE001"
  }'
```

## Delete Student
```bash
curl -X DELETE http://localhost:8080/api/students/1
```

---

# 5️⃣ SUBMISSION ENDPOINTS

## Submit Solution (ACCEPTED)
```bash
curl -X POST http://localhost:8080/api/submissions/student/1/challenge/1 \
  -H "Content-Type: application/json" \
  -d '{
    "submittedCode": "def twoSum(nums, target):\n    seen = {}\n    for i, num in enumerate(nums):\n        if target - num in seen:\n            return [seen[target - num], i]\n        seen[num] = i\n    return []",
    "status": "ACCEPTED",
    "testOutput": "[0,1]",
    "expectedOutput": "[0,1]",
    "language": "Python",
    "executionTimeMs": 145
  }'
```

## Submit Solution (WRONG_ANSWER)
```bash
curl -X POST http://localhost:8080/api/submissions/student/2/challenge/1 \
  -H "Content-Type: application/json" \
  -d '{
    "submittedCode": "def twoSum(nums, target):\n    for i in range(len(nums)):\n        for j in range(i+1, len(nums)):\n            if nums[i] + nums[j] == target:\n                return [i, j]\n    return []",
    "status": "WRONG_ANSWER",
    "testOutput": "[0,2]",
    "expectedOutput": "[0,1]",
    "language": "Python",
    "executionTimeMs": 1250
  }'
```

## Submit Solution (RUNTIME_ERROR)
```bash
curl -X POST http://localhost:8080/api/submissions/student/2/challenge/2 \
  -H "Content-Type: application/json" \
  -d '{
    "submittedCode": "def reverseString(s):\n    s[0] = s[-1]  # This causes error",
    "status": "RUNTIME_ERROR",
    "testOutput": "Error: list index out of range",
    "expectedOutput": "[o,l,l,e,h]",
    "language": "Python",
    "executionTimeMs": 50
  }'
```

## Submit Solution (Java - ACCEPTED)
```bash
curl -X POST http://localhost:8080/api/submissions/student/3/challenge/3 \
  -H "Content-Type: application/json" \
  -d '{
    "submittedCode": "class Solution {\n    public boolean hasCycle(ListNode head) {\n        if (head == null || head.next == null) return false;\n        ListNode slow = head;\n        ListNode fast = head.next;\n        while (slow != fast) {\n            if (fast == null || fast.next == null) return false;\n            slow = slow.next;\n            fast = fast.next.next;\n        }\n        return true;\n    }\n}",
    "status": "ACCEPTED",
    "testOutput": "true",
    "expectedOutput": "true",
    "language": "Java",
    "executionTimeMs": 256
  }'
```

## Get All Submissions
```bash
curl -X GET http://localhost:8080/api/submissions/student/1
```

## Get Submissions for a Challenge
```bash
curl -X GET http://localhost:8080/api/submissions/challenge/1
```

## Get Submissions by Student and Challenge
```bash
curl -X GET http://localhost:8080/api/submissions/student/1/challenge/1
```

## Get Submission by ID
```bash
curl -X GET http://localhost:8080/api/submissions/1
```

## Get Submissions by Status (ACCEPTED, WRONG_ANSWER, RUNTIME_ERROR, etc.)
```bash
curl -X GET http://localhost:8080/api/submissions/status/ACCEPTED
```

## Delete Submission
```bash
curl -X DELETE http://localhost:8080/api/submissions/1
```

---

# 6️⃣ PROGRESS & STATISTICS ENDPOINTS

## Get Challenge Progress for Student
```bash
curl -X GET http://localhost:8080/api/submissions/progress/student/1/challenge/1
```

## Get All Solved Challenges by Student
```bash
curl -X GET http://localhost:8080/api/submissions/progress/student/1/solved
```

## Get Total Solved Count for Student
```bash
curl -X GET http://localhost:8080/api/submissions/progress/student/1/solved-count
```

## Get Student Accuracy Rate (Percentage)
```bash
curl -X GET http://localhost:8080/api/submissions/progress/student/1/accuracy
```

## Get Accepted Submissions Count for Challenge
```bash
curl -X GET http://localhost:8080/api/submissions/challenge/1/accepted-count
```

---

# 🚀 COMPLETE TESTING SEQUENCE

Run these commands in order to test the complete workflow:

```bash
# 1. Create Academic Years
curl -X POST http://localhost:8080/api/academic-year \
  -H "Content-Type: application/json" \
  -d '{"year": "First_Year"}'

curl -X POST http://localhost:8080/api/academic-year \
  -H "Content-Type: application/json" \
  -d '{"year": "Second_Year"}'

# 2. Create Languages
curl -X POST http://localhost:8080/api/languages \
  -H "Content-Type: application/json" \
  -d '{"name": "Python"}'

curl -X POST http://localhost:8080/api/languages \
  -H "Content-Type: application/json" \
  -d '{"name": "Java"}'

# 3. Assign Languages to Years
curl -X PUT http://localhost:8080/api/languages/1/assign-year/1 \
  -H "Content-Type: application/json"

curl -X PUT http://localhost:8080/api/languages/2/assign-year/2 \
  -H "Content-Type: application/json"

# 4. Create Challenges
curl -X POST http://localhost:8080/api/challenges/language/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Two Sum",
    "description": "Find two numbers that add up to target",
    "problemStatement": "Given an array...",
    "difficultyLevel": "EASY",
    "timeLimit": 5,
    "memoryLimit": 256,
    "sampleInput": "nums = [2,7,11,15], target = 9",
    "sampleOutput": "[0,1]",
    "testCases": "[{\"input\": \"[2,7,11,15], 9\", \"output\": \"[0,1]\"}]"
  }'

# 5. Create Students
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john@college.com",
    "rollNumber": "CSE001",
    "academicYear": {"id": 1}
  }'

# 6. Submit Solution
curl -X POST http://localhost:8080/api/submissions/student/1/challenge/1 \
  -H "Content-Type: application/json" \
  -d '{
    "submittedCode": "def twoSum(nums, target):\n    seen = {}\n    for i, num in enumerate(nums):\n        if target - num in seen:\n            return [seen[target - num], i]\n        seen[num] = i\n    return []",
    "status": "ACCEPTED",
    "language": "Python",
    "executionTimeMs": 145
  }'

# 7. Check Progress
curl -X GET http://localhost:8080/api/submissions/progress/student/1/solved-count
```

---

## Valid Values

### Year Enum
```
First_Year
Second_Year
Third_Year
Fourth_Year
```

### Difficulty Level Enum
```
EASY
MEDIUM
HARD
VERY_HARD
```

### Submission Status Enum
```
SUBMITTED
ACCEPTED
WRONG_ANSWER
RUNTIME_ERROR
TIME_LIMIT_EXCEEDED
COMPILATION_ERROR
```

---

**Ready to test! Happy coding! 🎉**
