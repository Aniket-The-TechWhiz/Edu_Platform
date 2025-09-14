const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const Student = require('../models/student');
const Faculty = require('../models/faculty');
const JWT_SECRET = process.env.JWT_SECRET || 'your_jwt_secret_key';

// Student login
exports.studentLogin = async (req, res) => {
  const { studentId, password } = req.body;
  try {
    const student = await Student.findOne({ studentId });
    if (!student) {
      return res.status(404).json({ message: 'Student not found' });
    }

    const isMatch = await bcrypt.compare(password, student.password);
    if (!isMatch) {
      return res.status(400).json({ message: 'Invalid credentials' });
    }

    const token = jwt.sign({ id: student._id, role: 'student' }, JWT_SECRET, { expiresIn: '1h' });
    res.json({ token, message: 'Logged in as student' });
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
};

// Faculty login
exports.facultyLogin = async (req, res) => {
  const { facultyId, password } = req.body;
  try {
    const faculty = await Faculty.findOne({ facultyId });
    if (!faculty) {
      return res.status(404).json({ message: 'Faculty not found' });
    }

    const isMatch = await bcrypt.compare(password, faculty.password);
    if (!isMatch) {
      return res.status(400).json({ message: 'Invalid credentials' });
    }

    const token = jwt.sign({ id: faculty._id, role: 'faculty' }, JWT_SECRET, { expiresIn: '1h' });
    res.json({ token, message: 'Logged in as faculty' });
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
};

// Student registration
exports.studentRegister = async (req, res) => {
  const { studentId, password, studentName, yearOfStudy, studentEmail, branchId } = req.body;
  try {
    const hashedPassword = await bcrypt.hash(password, 10);
    const newStudent = new Student({
      studentId,
      password: hashedPassword,
      studentName,
      yearOfStudy,
      studentEmail,
      memberSince: new Date(),
      branchId
    });
    await newStudent.save();
    res.status(201).json({ message: 'Student registered successfully' });
  } catch (err) {
    res.status(400).json({ message: err.message });
  }
};

// Faculty registration
exports.facultyRegister = async (req, res) => {
  const { facultyId, password, facultyName, branchId } = req.body;
  try {
    const hashedPassword = await bcrypt.hash(password, 10);
    const newFaculty = new Faculty({
      facultyId,
      password: hashedPassword,
      facultyName,
      memberSince: new Date(),
      branchId
    });
    await newFaculty.save();
    res.status(201).json({ message: 'Faculty registered successfully' });
  } catch (err) {
    res.status(400).json({ message: err.message });
  }
};
