const express = require('express');
const router = express.Router();
const {
  handelGetAllAchievements,
  handelCreateNewAchievement,
} = require('../controllers/achievementController');

router.route('/').get(handelGetAllAchievements).post(handelCreateNewAchievement);

module.exports = router;