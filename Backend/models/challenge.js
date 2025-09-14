const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const challengeSchema = new Schema({
  challengeTitle: {
    type: String,
    required: true,
  },
  challengeDescription: {
    type: String,
    required: true,
  },
  challengeInput: {
    type: String,
    required: true,
  },
  challengeOutput: {
    type: String,
    required: true,
  },
  difficultyLevel: {
    type: String,
    enum: ['Easy', 'Medium', 'Hard'],
    required: true,
  },
  languageId: {
    type: Schema.Types.ObjectId,
    ref: 'ProgrammingLanguage',
    required: true,
  },
  facultyId: {
    type: Schema.Types.ObjectId,
    ref: 'Faculty',
    required: true,
  },
});

module.exports = mongoose.model('Challenge', challengeSchema);
