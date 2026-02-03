# Postman Testing Guide - Complete API Collection

## 📌 Base URL
```
http://localhost:8080
```

## 📋 All Headers
```
Content-Type: application/json
```

---

# ✅ COMPLETE TESTING WORKFLOW

## Step 1: Create Academic Year (First_Year)

### Request
```
Method: POST
URL: http://localhost:8080/api/academic-year
Header: Content-Type: application/json
```

### JSON Request Body
```json
{
  "year": "First_Year"
}
```

### Expected Response (201 Created)
```json
{
  "id": 1,
  "year": "First_Year",
  "programmingLanguages": []
}
```

---

## Step 2: Create Second Academic Year (Second_Year)

### Request
```
Method: POST
URL: http://localhost:8080/api/academic-year
Header: Content-Type: application/json
```

### JSON Request Body
```json
{
  "year": "Second_Year"
}
```

### Expected Response (201 Created)
```json
{
  "id": 2,
  "year": "Second_Year",
  "programmingLanguages": []
}
```

---

## Step 3: Create Programming Languages

### 3.1 Create Python Language

#### Request
```
Method: POST
URL: http://localhost:8080/api/languages
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "name": "Python"
}
```

#### Expected Response (201 Created)
```json
{
  "id": 1,
  "name": "Python",
  "academicYear": null
}
```

### 3.2 Create Java Language

#### Request
```
Method: POST
URL: http://localhost:8080/api/languages
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "name": "Java"
}
```

#### Expected Response (201 Created)
```json
{
  "id": 2,
  "name": "Java",
  "academicYear": null
}
```

### 3.3 Create C++ Language

#### Request
```
Method: POST
URL: http://localhost:8080/api/languages
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "name": "C++"
}
```

#### Expected Response (201 Created)
```json
{
  "id": 3,
  "name": "C++",
  "academicYear": null
}
```

---

## Step 4: Assign Languages to Academic Years

### 4.1 Assign Python to First_Year

#### Request
```
Method: PUT
URL: http://localhost:8080/api/languages/1/assign-year/1
Header: Content-Type: application/json
```

#### No Body Required (or empty {})

#### Expected Response (200 OK)
```json
{
  "id": 1,
  "name": "Python",
  "academicYear": {
    "id": 1,
    "year": "First_Year"
  }
}
```

### 4.2 Assign Java to Second_Year

#### Request
```
Method: PUT
URL: http://localhost:8080/api/languages/2/assign-year/2
Header: Content-Type: application/json
```

#### Expected Response (200 OK)
```json
{
  "id": 2,
  "name": "Java",
  "academicYear": {
    "id": 2,
    "year": "Second_Year"
  }
}
```

### 4.3 Assign C++ to Second_Year

#### Request
```
Method: PUT
URL: http://localhost:8080/api/languages/3/assign-year/2
Header: Content-Type: application/json
```

#### Expected Response (200 OK)
```json
{
  "id": 3,
  "name": "C++",
  "academicYear": {
    "id": 2,
    "year": "Second_Year"
  }
}
```

---

## Step 5: Create Challenges

### 5.1 Create Python Challenge - Easy (Two Sum)

#### Request
```
Method: POST
URL: http://localhost:8080/api/challenges/language/1
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "title": "Two Sum",
  "description": "Find two numbers that add up to target",
  "problemStatement": "Given an array of integers nums and an integer target, return the indices of the two numbers that add up to target. You may assume that each input has exactly one solution, and you may not use the same element twice. You can return the answer in any order.",
  "difficultyLevel": "EASY",
  "timeLimit": 5,
  "memoryLimit": 256,
  "sampleInput": "nums = [2,7,11,15], target = 9",
  "sampleOutput": "[0,1]",
  "testCases": "[{\"input\": \"[2,7,11,15], 9\", \"output\": \"[0,1]\"}, {\"input\": \"[3,2,4], 6\", \"output\": \"[1,2]\"}, {\"input\": \"[3,3], 6\", \"output\": \"[0,1]\"}]"
}
```

#### Expected Response (201 Created)
```json
{
  "id": 1,
  "title": "Two Sum",
  "description": "Find two numbers that add up to target",
  "problemStatement": "Given an array of integers nums...",
  "difficultyLevel": "EASY",
  "timeLimit": 5,
  "memoryLimit": 256,
  "sampleInput": "nums = [2,7,11,15], target = 9",
  "sampleOutput": "[0,1]",
  "testCases": "[{\"input\": \"[2,7,11,15], 9\", \"output\": \"[0,1]\"}...]",
  "acceptedCount": 0,
  "totalSubmissions": 0,
  "isActive": true,
  "createdAt": "2026-02-03T10:30:00",
  "programmingLanguage": {
    "id": 1,
    "name": "Python"
  }
}
```

### 5.2 Create Python Challenge - Easy (Reverse String)

#### Request
```
Method: POST
URL: http://localhost:8080/api/challenges/language/1
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "title": "Reverse String",
  "description": "Reverse a string",
  "problemStatement": "Write a function that reverses a string. The input string is given as an array of characters s.",
  "difficultyLevel": "EASY",
  "timeLimit": 3,
  "memoryLimit": 128,
  "sampleInput": "s = [\"h\",\"e\",\"l\",\"l\",\"o\"]",
  "sampleOutput": "[\"o\",\"l\",\"l\",\"e\",\"h\"]",
  "testCases": "[{\"input\": \"[\\\"h\\\",\\\"e\\\",\\\"l\\\",\\\"l\\\",\\\"o\\\"]\", \"output\": \"[\\\"o\\\",\\\"l\\\",\\\"l\\\",\\\"e\\\",\\\"h\\\"]\"}, {\"input\": \"[\\\"H\\\",\\\"a\\\",\\\"n\\\",\\\"n\\\",\\\"a\\\",\\\"h\\\"]\", \"output\": \"[\\\"h\\\",\\\"a\\\",\\\"n\\\",\\\"n\\\",\\\"a\\\",\\\"H\\\"]\"}]"
}
```

#### Expected Response (201 Created)
```json
{
  "id": 2,
  "title": "Reverse String",
  "description": "Reverse a string",
  "problemStatement": "Write a function that reverses a string...",
  "difficultyLevel": "EASY",
  "timeLimit": 3,
  "memoryLimit": 128,
  "sampleInput": "s = [\"h\",\"e\",\"l\",\"l\",\"o\"]",
  "sampleOutput": "[\"o\",\"l\",\"l\",\"e\",\"h\"]",
  "acceptedCount": 0,
  "totalSubmissions": 0,
  "isActive": true,
  "createdAt": "2026-02-03T10:35:00",
  "programmingLanguage": {
    "id": 1,
    "name": "Python"
  }
}
```

### 5.3 Create Java Challenge - Medium (Linked List Cycle)

#### Request
```
Method: POST
URL: http://localhost:8080/api/challenges/language/2
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "title": "Linked List Cycle",
  "description": "Detect if there is a cycle in a linked list",
  "problemStatement": "Given head, the head of a linked list, determine if the linked list has a cycle in it. There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.",
  "difficultyLevel": "MEDIUM",
  "timeLimit": 5,
  "memoryLimit": 256,
  "sampleInput": "head = [3,2,0,-4], pos = 1",
  "sampleOutput": "true",
  "testCases": "[{\"input\": \"[3,2,0,-4], pos = 1\", \"output\": \"true\"}, {\"input\": \"[1,2], pos = 0\", \"output\": \"true\"}, {\"input\": \"[1], pos = -1\", \"output\": \"false\"}]"
}
```

#### Expected Response (201 Created)
```json
{
  "id": 3,
  "title": "Linked List Cycle",
  "description": "Detect if there is a cycle in a linked list",
  "problemStatement": "Given head, the head of a linked list...",
  "difficultyLevel": "MEDIUM",
  "timeLimit": 5,
  "memoryLimit": 256,
  "sampleInput": "head = [3,2,0,-4], pos = 1",
  "sampleOutput": "true",
  "acceptedCount": 0,
  "totalSubmissions": 0,
  "isActive": true,
  "createdAt": "2026-02-03T10:40:00",
  "programmingLanguage": {
    "id": 2,
    "name": "Java"
  }
}
```

### 5.4 Create Java Challenge - Medium (Binary Search)

#### Request
```
Method: POST
URL: http://localhost:8080/api/challenges/language/2
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "title": "Binary Search",
  "description": "Find target in sorted array",
  "problemStatement": "Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.",
  "difficultyLevel": "MEDIUM",
  "timeLimit": 4,
  "memoryLimit": 256,
  "sampleInput": "nums = [-1,0,3,5,9,12], target = 9",
  "sampleOutput": "4",
  "testCases": "[{\"input\": \"[-1,0,3,5,9,12], 9\", \"output\": \"4\"}, {\"input\": \"[-1,0,3,5,9,12], 13\", \"output\": \"-1\"}]"
}
```

#### Expected Response (201 Created)
```json
{
  "id": 4,
  "title": "Binary Search",
  "description": "Find target in sorted array",
  "problemStatement": "Given an array of integers nums...",
  "difficultyLevel": "MEDIUM",
  "timeLimit": 4,
  "memoryLimit": 256,
  "sampleInput": "nums = [-1,0,3,5,9,12], target = 9",
  "sampleOutput": "4",
  "acceptedCount": 0,
  "totalSubmissions": 0,
  "isActive": true,
  "createdAt": "2026-02-03T10:45:00",
  "programmingLanguage": {
    "id": 2,
    "name": "Java"
  }
}
```

---

## Step 6: Create Students

### 6.1 Create Student - Enroll in First_Year

#### Request
```
Method: POST
URL: http://localhost:8080/api/students
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "name": "John Doe",
  "email": "john.doe@college.com",
  "rollNumber": "CSE001",
  "academicYear": {
    "id": 1
  }
}
```

#### Expected Response (201 Created)
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@college.com",
  "rollNumber": "CSE001",
  "enrolledAt": "2026-02-03T10:50:00",
  "lastActiveAt": null,
  "totalChallengesSolved": 0,
  "averageScore": null,
  "academicYear": {
    "id": 1,
    "year": "First_Year"
  }
}
```

### 6.2 Create Second Student - First_Year

#### Request
```
Method: POST
URL: http://localhost:8080/api/students
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "name": "Jane Smith",
  "email": "jane.smith@college.com",
  "rollNumber": "CSE002",
  "academicYear": {
    "id": 1
  }
}
```

#### Expected Response (201 Created)
```json
{
  "id": 2,
  "name": "Jane Smith",
  "email": "jane.smith@college.com",
  "rollNumber": "CSE002",
  "enrolledAt": "2026-02-03T10:55:00",
  "lastActiveAt": null,
  "totalChallengesSolved": 0,
  "averageScore": null,
  "academicYear": {
    "id": 1,
    "year": "First_Year"
  }
}
```

### 6.3 Create Student - Enroll in Second_Year

#### Request
```
Method: POST
URL: http://localhost:8080/api/students
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "name": "Bob Wilson",
  "email": "bob.wilson@college.com",
  "rollNumber": "CSE051",
  "academicYear": {
    "id": 2
  }
}
```

#### Expected Response (201 Created)
```json
{
  "id": 3,
  "name": "Bob Wilson",
  "email": "bob.wilson@college.com",
  "rollNumber": "CSE051",
  "enrolledAt": "2026-02-03T11:00:00",
  "lastActiveAt": null,
  "totalChallengesSolved": 0,
  "averageScore": null,
  "academicYear": {
    "id": 2,
    "year": "Second_Year"
  }
}
```

---

## Step 7: Students View Their Curriculum

### Request
```
Method: GET
URL: http://localhost:8080/api/students/1/curriculum
```

### Expected Response (200 OK)
```json
{
  "id": 1,
  "year": "First_Year",
  "programmingLanguages": [
    {
      "id": 1,
      "name": "Python",
      "challenges": [
        {
          "id": 1,
          "title": "Two Sum",
          "description": "Find two numbers that add up to target",
          "difficultyLevel": "EASY",
          "timeLimit": 5,
          "memoryLimit": 256
        },
        {
          "id": 2,
          "title": "Reverse String",
          "description": "Reverse a string",
          "difficultyLevel": "EASY",
          "timeLimit": 3,
          "memoryLimit": 128
        }
      ]
    }
  ]
}
```

---

## Step 8: Submit Code Solutions

### 8.1 John Solves - Two Sum (ACCEPTED)

#### Request
```
Method: POST
URL: http://localhost:8080/api/submissions/student/1/challenge/1
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "submittedCode": "def twoSum(nums, target):\n    seen = {}\n    for i, num in enumerate(nums):\n        if target - num in seen:\n            return [seen[target - num], i]\n        seen[num] = i\n    return []",
  "status": "ACCEPTED",
  "testOutput": "[0,1]",
  "expectedOutput": "[0,1]",
  "language": "Python",
  "executionTimeMs": 145
}
```

#### Expected Response (201 Created)
```json
{
  "id": 1,
  "status": "ACCEPTED",
  "submittedAt": "2026-02-03T11:05:00",
  "submittedCode": "def twoSum(nums, target):\n    seen = {}\n    for i, num in enumerate(nums):\n        if target - num in seen:\n            return [seen[target - num], i]\n        seen[num] = i\n    return []",
  "language": "Python",
  "executionTimeMs": 145,
  "student": {
    "id": 1,
    "name": "John Doe"
  },
  "challenge": {
    "id": 1,
    "title": "Two Sum"
  }
}
```

### 8.2 John Solves - Reverse String (ACCEPTED)

#### Request
```
Method: POST
URL: http://localhost:8080/api/submissions/student/1/challenge/2
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "submittedCode": "def reverseString(s):\n    s.reverse()\n    return s",
  "status": "ACCEPTED",
  "testOutput": "[\"o\",\"l\",\"l\",\"e\",\"h\"]",
  "expectedOutput": "[\"o\",\"l\",\"l\",\"e\",\"h\"]",
  "language": "Python",
  "executionTimeMs": 98
}
```

#### Expected Response (201 Created)
```json
{
  "id": 2,
  "status": "ACCEPTED",
  "submittedAt": "2026-02-03T11:10:00",
  "submittedCode": "def reverseString(s):\n    s.reverse()\n    return s",
  "language": "Python",
  "executionTimeMs": 98,
  "student": {
    "id": 1,
    "name": "John Doe"
  },
  "challenge": {
    "id": 2,
    "title": "Reverse String"
  }
}
```

### 8.3 Jane Solves - Two Sum (WRONG_ANSWER)

#### Request
```
Method: POST
URL: http://localhost:8080/api/submissions/student/2/challenge/1
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "submittedCode": "def twoSum(nums, target):\n    for i in range(len(nums)):\n        for j in range(i+1, len(nums)):\n            if nums[i] + nums[j] == target:\n                return [i, j]\n    return []",
  "status": "WRONG_ANSWER",
  "testOutput": "[0,2]",
  "expectedOutput": "[0,1]",
  "language": "Python",
  "executionTimeMs": 1250
}
```

#### Expected Response (201 Created)
```json
{
  "id": 3,
  "status": "WRONG_ANSWER",
  "submittedAt": "2026-02-03T11:15:00",
  "submittedCode": "def twoSum(nums, target):\n    for i in range(len(nums)):\n        for j in range(i+1, len(nums)):\n            if nums[i] + nums[j] == target:\n                return [i, j]\n    return []",
  "language": "Python",
  "testOutput": "[0,2]",
  "expectedOutput": "[0,1]",
  "executionTimeMs": 1250,
  "student": {
    "id": 2,
    "name": "Jane Smith"
  },
  "challenge": {
    "id": 1,
    "title": "Two Sum"
  }
}
```

### 8.4 Jane's Second Attempt - Two Sum (ACCEPTED)

#### Request
```
Method: POST
URL: http://localhost:8080/api/submissions/student/2/challenge/1
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "submittedCode": "def twoSum(nums, target):\n    seen = {}\n    for i, num in enumerate(nums):\n        if target - num in seen:\n            return [seen[target - num], i]\n        seen[num] = i\n    return []",
  "status": "ACCEPTED",
  "testOutput": "[0,1]",
  "expectedOutput": "[0,1]",
  "language": "Python",
  "executionTimeMs": 142
}
```

#### Expected Response (201 Created)
```json
{
  "id": 4,
  "status": "ACCEPTED",
  "submittedAt": "2026-02-03T11:20:00",
  "submittedCode": "def twoSum(nums, target):\n    seen = {}\n    for i, num in enumerate(nums):\n        if target - num in seen:\n            return [seen[target - num], i]\n        seen[num] = i\n    return []",
  "language": "Python",
  "executionTimeMs": 142,
  "student": {
    "id": 2,
    "name": "Jane Smith"
  },
  "challenge": {
    "id": 1,
    "title": "Two Sum"
  }
}
```

### 8.5 Bob Solves - Linked List Cycle (ACCEPTED)

#### Request
```
Method: POST
URL: http://localhost:8080/api/submissions/student/3/challenge/3
Header: Content-Type: application/json
```

#### JSON Request Body
```json
{
  "submittedCode": "class Solution {\n    public boolean hasCycle(ListNode head) {\n        if (head == null || head.next == null) return false;\n        ListNode slow = head;\n        ListNode fast = head.next;\n        while (slow != fast) {\n            if (fast == null || fast.next == null) return false;\n            slow = slow.next;\n            fast = fast.next.next;\n        }\n        return true;\n    }\n}",
  "status": "ACCEPTED",
  "testOutput": "true",
  "expectedOutput": "true",
  "language": "Java",
  "executionTimeMs": 256
}
```

#### Expected Response (201 Created)
```json
{
  "id": 5,
  "status": "ACCEPTED",
  "submittedAt": "2026-02-03T11:25:00",
  "submittedCode": "class Solution {\n    public boolean hasCycle(ListNode head) {\n        ...\n    }\n}",
  "language": "Java",
  "executionTimeMs": 256,
  "student": {
    "id": 3,
    "name": "Bob Wilson"
  },
  "challenge": {
    "id": 3,
    "title": "Linked List Cycle"
  }
}
```

---

## Step 9: View Student Progress

### 9.1 Get Total Solved Problems for John

#### Request
```
Method: GET
URL: http://localhost:8080/api/submissions/progress/student/1/solved-count
```

#### Expected Response (200 OK)
```json
{
  "totalSolved": 2
}
```

### 9.2 Get Solved Problems for John

#### Request
```
Method: GET
URL: http://localhost:8080/api/submissions/progress/student/1/solved
```

#### Expected Response (200 OK)
```json
[
  {
    "id": 1,
    "attemptCount": 1,
    "isSolved": true,
    "firstAttemptAt": "2026-02-03T11:05:00",
    "solvedAt": "2026-02-03T11:05:00",
    "solvingTimeMinutes": 0,
    "challenge": {
      "id": 1,
      "title": "Two Sum"
    }
  },
  {
    "id": 2,
    "attemptCount": 1,
    "isSolved": true,
    "firstAttemptAt": "2026-02-03T11:10:00",
    "solvedAt": "2026-02-03T11:10:00",
    "solvingTimeMinutes": 0,
    "challenge": {
      "id": 2,
      "title": "Reverse String"
    }
  }
]
```

### 9.3 Get Accuracy Rate for Jane

#### Request
```
Method: GET
URL: http://localhost:8080/api/submissions/progress/student/2/accuracy
```

#### Expected Response (200 OK)
```json
{
  "accuracy": 50.0
}
```

### 9.4 Get Submissions by Student (John)

#### Request
```
Method: GET
URL: http://localhost:8080/api/submissions/student/1
```

#### Expected Response (200 OK)
```json
[
  {
    "id": 1,
    "status": "ACCEPTED",
    "submittedAt": "2026-02-03T11:05:00",
    "language": "Python",
    "executionTimeMs": 145,
    "challenge": {
      "id": 1,
      "title": "Two Sum"
    }
  },
  {
    "id": 2,
    "status": "ACCEPTED",
    "submittedAt": "2026-02-03T11:10:00",
    "language": "Python",
    "executionTimeMs": 98,
    "challenge": {
      "id": 2,
      "title": "Reverse String"
    }
  }
]
```

### 9.5 Get Challenge Progress for a Specific Challenge

#### Request
```
Method: GET
URL: http://localhost:8080/api/submissions/progress/student/2/challenge/1
```

#### Expected Response (200 OK)
```json
{
  "id": 2,
  "attemptCount": 2,
  "isSolved": true,
  "firstAttemptAt": "2026-02-03T11:15:00",
  "solvedAt": "2026-02-03T11:20:00",
  "solvingTimeMinutes": 5,
  "challenge": {
    "id": 1,
    "title": "Two Sum"
  }
}
```

---

## Additional GET Endpoints to Test

### Get All Academic Years
```
Method: GET
URL: http://localhost:8080/api/academic-year
```

### Get All Languages
```
Method: GET
URL: http://localhost:8080/api/languages
```

### Get All Challenges
```
Method: GET
URL: http://localhost:8080/api/challenges
```

### Get Challenges by Language (Python)
```
Method: GET
URL: http://localhost:8080/api/challenges/language/1
```

### Get Challenges by Difficulty (EASY)
```
Method: GET
URL: http://localhost:8080/api/challenges/difficulty/EASY
```

### Get Active Challenges Only
```
Method: GET
URL: http://localhost:8080/api/challenges/active
```

### Get All Students
```
Method: GET
URL: http://localhost:8080/api/students
```

### Get Student Details
```
Method: GET
URL: http://localhost:8080/api/students/1
```

### Get Submissions for a Challenge
```
Method: GET
URL: http://localhost:8080/api/submissions/challenge/1
```

### Get Submissions by Status
```
Method: GET
URL: http://localhost:8080/api/submissions/status/ACCEPTED
```

---

## Update/Delete Endpoints to Test

### Activate a Challenge
```
Method: PUT
URL: http://localhost:8080/api/challenges/1/activate
```

### Deactivate a Challenge
```
Method: PUT
URL: http://localhost:8080/api/challenges/2/deactivate
```

### Update Student Information
```
Method: PUT
URL: http://localhost:8080/api/students/1
Header: Content-Type: application/json

JSON Body:
{
  "name": "John Updated",
  "email": "john.updated@college.com",
  "rollNumber": "CSE001"
}
```

### Delete Student
```
Method: DELETE
URL: http://localhost:8080/api/students/1
```

### Delete Academic Year
```
Method: DELETE
URL: http://localhost:8080/api/academic-year/1
```

---

## DifficultyLevel Valid Values
```
EASY
MEDIUM
HARD
VERY_HARD
```

## SubmissionStatus Valid Values
```
SUBMITTED
ACCEPTED
WRONG_ANSWER
RUNTIME_ERROR
TIME_LIMIT_EXCEEDED
COMPILATION_ERROR
```

## Year Valid Values
```
First_Year
Second_Year
Third_Year
Fourth_Year
```

---

## 🎯 Quick Testing Sequence Order

1. Create Academic Year - First_Year (Get ID: 1)
2. Create Academic Year - Second_Year (Get ID: 2)
3. Create Languages (Python, Java, C++) (Get IDs: 1, 2, 3)
4. Assign Languages to Years
5. Create Challenges
6. Create Students
7. View Curriculum
8. Submit Solutions
9. View Progress & Statistics
10. Test GET endpoints for validation

---

## 💡 Tips for Postman

1. **Use Variables** - Save IDs in environment variables
   - Set `academicYear1` = 1
   - Set `student1` = 1
   - Set `challenge1` = 1

2. **Create Folders** - Organize by resource
   - Academic Year
   - Languages
   - Challenges
   - Students
   - Submissions

3. **Save Requests** - Reuse them

4. **Use Pre-request Script** - To auto-generate timestamps

5. **Check Responses** - Verify JSON structure

---

**You're ready to test the complete platform! 🚀**
