const express = require('express');
const router = express.Router();
const {
  handelGetAllFacultyLanguages,
  handelCreateNewFacultyLanguage,
} = require('../controllers/facultyLanguageController');

router.route('/').get(handelGetAllFacultyLanguages).post(handelCreateNewFacultyLanguage);

module.exports = router;