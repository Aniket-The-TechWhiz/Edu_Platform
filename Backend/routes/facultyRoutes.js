const express = require('express');
const router = express.Router();
const {handelGetAllFaculty,handelCreateNewFaculty} = require('../controllers/facultyController');

router.route('/').get(handelGetAllFaculty).post(handelCreateNewFaculty);
module.exports = router;
