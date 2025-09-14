const express = require('express');
const router = express.Router();
const {handelGetAllStudent,handelCreateNewStudent} = require('../controllers/studentController');

router.route('/').get(handelGetAllStudent).post(handelCreateNewStudent);
module.exports = router;
