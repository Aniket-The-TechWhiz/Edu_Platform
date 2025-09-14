const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const submissionSchema = new Schema({
  studentId: {
    type: Schema.Types.ObjectId,
    ref: 'Student',
    required: true,
  },
  challengeId: {
    type: Schema.Types.ObjectId,
    ref: 'Challenge',
    required: true,
  },
  submittedCode: {
    type: String,
    required: true,
  },
  submissionTime: {
    type: Date,
    default: Date.now,
  },
  linesWritten: {
    type: Number,
    required: true,
  },
  timeTaken: {
    type: Number,
    required: true,
  },
  isSolved: {
    type: Boolean,
    required: true,
  },
});

module.exports = mongoose.model('Submission', submissionSchema);
