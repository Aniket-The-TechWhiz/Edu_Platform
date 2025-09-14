const StudentAchievement = require('../models/studentAchievements');

async function handelGetAllStudentAchievements(req, res) {
  const allStudentAchievements = await StudentAchievement.find({})
    .populate('studentId', 'studentName')
    .populate('achievementId', 'achievementName');
  return res.status(200).json(allStudentAchievements);
}

async function handelCreateNewStudentAchievement(req, res) {
  const body = req.body;
  if (!body || !body.studentId || !body.achievementId) {
    return res.status(400).json({ msg: 'All fields are required' });
  }

  const existing = await StudentAchievement.findOne({ studentId: body.studentId, achievementId: body.achievementId });
  if (existing) {
    return res.status(409).json({ msg: 'This student has already earned this achievement' });
  }

  const result = await StudentAchievement.create({
    studentId: body.studentId,
    achievementId: body.achievementId,
  });

  console.log('Result:', result);
  return res.status(201).json({ msg: 'Success', studentAchievementId: result._id });
}

module.exports = {
  handelGetAllStudentAchievements,
  handelCreateNewStudentAchievement,
};