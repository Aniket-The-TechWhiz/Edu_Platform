const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const studentAchievementSchema = new Schema({
  studentId: {
    type: Schema.Types.ObjectId,
    ref: 'Student',
    required: true,
  },
  achievementId: {
    type: Schema.Types.ObjectId,
    ref: 'Achievement',
    required: true,
  },
  dateEarned: {
    type: Date,
    default: Date.now,
    required: true,
  },
});

// Add a unique compound index to ensure a student can't earn the same achievement twice.
studentAchievementSchema.index({ studentId: 1, achievementId: 1 }, { unique: true });

module.exports = mongoose.model('StudentAchievement', studentAchievementSchema);
