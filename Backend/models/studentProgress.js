const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const studentProgressSchema = new Schema({
  studentId: {
    type: Schema.Types.ObjectId,
    ref: 'Student',
    unique: true,
    required: true,
  },
  challengesSolved: {
    type: Number,
    default: 0,
  },
  totalTimeTaken: {
    type: Number,
    default: 0,
  },
  totalLinesWritten: {
    type: Number,
    default: 0,
  },
  level: {
    type: String,
    default: 'Beginner',
  },
});

module.exports = mongoose.model('StudentProgress', studentProgressSchema);
