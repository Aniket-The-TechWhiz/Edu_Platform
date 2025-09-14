const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const studentSchema = new Schema({
  studentId: {
    type: String,
    required: true,
    unique: true,
  },
  password: {
    type: String,
    required: true,
  },
  studentName: {
    type: String,
    required: true,
  },
  yearOfStudy: {
    type: String,
    required: true,
  },
  studentEmail: {
    type: String,
    required: true,
    unique: true,
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

module.exports = mongoose.model('Student', studentSchema);
