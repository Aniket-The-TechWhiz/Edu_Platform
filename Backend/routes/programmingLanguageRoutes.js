const express = require('express');
const router = express.Router();
const {handelgetAllProgrammingLanguage,handelCreateNewProgrammingLanguage} = require('../controllers/programmingLanguageController');

router.route('/').get(handelgetAllProgrammingLanguage).post(handelCreateNewProgrammingLanguage);

module.exports = router;
