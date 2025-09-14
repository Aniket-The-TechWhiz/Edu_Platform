const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const facultySchema = new Schema({
  facultyId: {
    type: String,
    required: true,
    unique: true,
  },
  password: {
    type: String,
    required: true,
  },
  facultyName: {
    type: String,
    required: true,
  },
  memberSince: {
    type: Date,
    default: Date.now,
  },
  branchId: {
    type: Schema.Types.ObjectId,
    ref: 'Branch',
  },
});

module.exports = mongoose.model('Faculty', facultySchema);
