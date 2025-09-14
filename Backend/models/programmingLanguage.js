const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const programmingLanguageSchema = new Schema({
  languageName: {
    type: String,
    required: true,
    unique: true,
  },
});

const ProgrammingLanguage = mongoose.model('ProgrammingLanguage', programmingLanguageSchema);

module.exports = ProgrammingLanguage;
