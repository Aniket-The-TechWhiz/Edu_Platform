const express = require('express');
const router = express.Router();
const {handelGetAllChallenges,handelCreateNewChallenge} = require('../controllers/challengeController');

router.route('/').get(handelGetAllChallenges).post(handelCreateNewChallenge);

module.exports = router;
