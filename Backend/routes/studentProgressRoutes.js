const express = require('express');
const router = express.Router();
const { handelGetAllStudentProgress, handelCreateNewStudentProgress } = require('../controllers/studentProgressController');

router.route('/').get(handelGetAllStudentProgress).post(handelCreateNewStudentProgress);

module.exports = router;