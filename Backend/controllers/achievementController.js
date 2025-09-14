const Achievement = require('../models/achievements');

async function handelGetAllAchievements(req, res) {
  const allAchievements = await Achievement.find({});
  return res.status(200).json(allAchievements);
}

async function handelCreateNewAchievement(req, res) {
  const body = req.body;
  if (!body || !body.achievementName || !body.description) {
    return res.status(400).json({ msg: 'All fields are required' });
  }

  const existing = await Achievement.findOne({ achievementName: body.achievementName });
  if (existing) {
    return res.status(409).json({ msg: 'Achievement already exists' });
  }

  const result = await Achievement.create({
    achievementName: body.achievementName,
    description: body.description,
  });

  console.log('Result:', result);
  return res.status(201).json({ msg: 'Success', achievementId: result._id });
}

module.exports = {
  handelGetAllAchievements,
  handelCreateNewAchievement,
};