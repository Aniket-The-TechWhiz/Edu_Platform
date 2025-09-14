const Challenge = require('../models/challenge');
const {all}=require('../routes/challengeRoutes');

async function handelGetAllChallenges(req,res)
{
  const allChallenges=await Challenge.find({}).populate('languageId').populate('facultyId', 'facultyName');
  return res.status(200).json(allChallenges);
}

async function handelCreateNewChallenge(req,res)
{
    const body=req.body;
  
    if(!body || !body.challengeTitle || !body.challengeDescription || !body.challengeInput || !body.challengeOutput || !body.difficultyLevel || !body.languageId || !body.facultyId)
    {
        return res.status(400).json({msg:'all feilds are required'});
    }
    const existing = await Challenge.findOne({challengeTitle: body.challengeTitle });
        if (existing) {
            return res.status(409).json({ msg: 'Language already exists' });
        }
    const result= Challenge.create(
        {
        challengeTitle:body.challengeTitle,
        challengeDescription:body.challengeDescription,
        challengeInput:body.challengeInput,
        challengeOutput:body.challengeOutput,
        difficultyLevel:body.difficultyLevel,
        languageId: body.languageId,
        facultyId: body.facultyId,
        }
    );
    console.log('result :', result);
    return res.status(201).json({ msg: 'success',challengeTitle:result.challengeTitle});
}

module.exports={
  handelGetAllChallenges,handelCreateNewChallenge
}