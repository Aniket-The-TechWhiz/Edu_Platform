const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const facultyLanguageSchema = new Schema({
  facultyId: {
    type: Schema.Types.ObjectId,
    ref: 'Faculty',
    required: true,
  },
  languageId: {
    type: Schema.Types.ObjectId,
    ref: 'ProgrammingLanguage',
    required: true,
  },
  yearOfTeaching: {
    type: String,
    required: true,
  },
});

// Create a unique compound index to enforce the composite key
facultyLanguageSchema.index({ facultyId: 1, languageId: 1, yearOfTeaching: 1 }, { unique: true });

module.exports = mongoose.model('FacultyLanguage', facultyLanguageSchema);
