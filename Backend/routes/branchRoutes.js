const express = require('express');
const router = express.Router();
const {handelGetAllBranch, handelCreateNewBranch} = require('../controllers/branchController');

router.route('/').get(handelGetAllBranch).post(handelCreateNewBranch);

module.exports = router;
