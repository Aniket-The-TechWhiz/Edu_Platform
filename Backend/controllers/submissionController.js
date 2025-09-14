const Submission = require('../models/submission');

async function handelGetAllSubmissions(req, res) {
  const allSubmissions = await Submission.find({})
    .populate('studentId', 'studentName studentEmail')
    .populate('challengeId', 'challengeTitle');
  return res.status(200).json(allSubmissions);
}

async function handelCreateNewSubmission(req, res) {
  const body = req.body;
  if (!body || !body.studentId || !body.challengeId || !body.submittedCode || !body.linesWritten || !body.timeTaken || !body.isSolved) {
    return res.status(400).json({ msg: 'All fields are required' });
  }

  const result = await Submission.create({
    studentId: body.studentId,
    challengeId: body.challengeId,
    submittedCode: body.submittedCode,
    linesWritten: body.linesWritten,
    timeTaken: body.timeTaken,
    isSolved: body.isSolved,
  });

  console.log('Result:', result);
  return res.status(201).json({ msg: 'Success', submissionId: result._id });
}

module.exports = {
  handelGetAllSubmissions,
  handelCreateNewSubmission,
};