const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const achievementSchema = new Schema({
  achievementName: {
    type: String,
    required: true,
  },
  description: {
    type: String,
    required: true,
  },
});

module.exports = mongoose.model('Achievement', achievementSchema);
