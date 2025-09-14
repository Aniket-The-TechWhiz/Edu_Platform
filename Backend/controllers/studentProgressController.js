const StudentProgress = require('../models/studentProgress');

async function handelGetAllStudentProgress(req, res) {
  const allStudentProgress = await StudentProgress.find({})
    .populate('studentId', 'studentName');
  return res.status(200).json(allStudentProgress);
}

async function handelCreateNewStudentProgress(req, res) {
  const body = req.body;
  if (!body || !body.studentId) {
    return res.status(400).json({ msg: 'studentId is required' });
  }

  const existing = await StudentProgress.findOne({ studentId: body.studentId });
  if (existing) {
    return res.status(409).json({ msg: 'Student progress already exists for this student' });
  }

  const result = await StudentProgress.create({
    studentId: body.studentId,
  });

  console.log('Result:', result);
  return res.status(201).json({ msg: 'Success', studentProgressId: result._id });
}

module.exports = {
  handelGetAllStudentProgress,
  handelCreateNewStudentProgress,
};