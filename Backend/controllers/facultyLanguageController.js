const FacultyLanguage = require('../models/facultyLanguages');

async function handelGetAllFacultyLanguages(req, res) {
  // Populate both facultyId and languageId to show full details
  const allFacultyLanguages = await FacultyLanguage.find({})
    .populate('facultyId', 'facultyName')
    .populate('languageId', 'languageName');

  return res.status(200).json(allFacultyLanguages);
}

async function handelCreateNewFacultyLanguage(req, res) {
  const body = req.body;

  if (!body || !body.facultyId || !body.languageId || !body.yearOfTeaching) {
    return res.status(400).json({ msg: 'All fields are required' });
  }

  // Check for an existing combination to avoid duplicates
  const existing = await FacultyLanguage.findOne({
    facultyId: body.facultyId,
    languageId: body.languageId,
    yearOfTeaching: body.yearOfTeaching,
  });

  if (existing) {
    return res.status(409).json({ msg: 'This faculty-language association already exists for the given year.' });
  }

  const result = await FacultyLanguage.create({
    facultyId: body.facultyId,
    languageId: body.languageId,
    yearOfTeaching: body.yearOfTeaching,
  });

  console.log('result:', result);
  return res.status(201).json({ msg: 'success', associationId: result._id });
}

module.exports = {
  handelGetAllFacultyLanguages,
  handelCreateNewFacultyLanguage,
};