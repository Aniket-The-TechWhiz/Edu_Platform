const express = require('express');
const router = express.Router();
const { handelGetAllStudentAchievements, handelCreateNewStudentAchievement } = require('../controllers/studentAchievementController');

router.route('/').get(handelGetAllStudentAchievements).post(handelCreateNewStudentAchievement);

module.exports = router;