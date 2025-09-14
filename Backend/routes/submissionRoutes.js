const express = require('express');
const router = express.Router();
const { handelGetAllSubmissions, handelCreateNewSubmission } = require('../controllers/submissionController');

router.route('/').get(handelGetAllSubmissions).post(handelCreateNewSubmission);

module.exports = router;