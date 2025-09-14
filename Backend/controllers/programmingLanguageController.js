const ProgrammingLanguage = require('../models/programmingLanguage');
const {all}=require('../routes/programmingLanguageRoutes');

async function handelgetAllProgrammingLanguage(req,res)
{
  const allProgrammingLanguage=await ProgrammingLanguage.find({});
  return res.status(200).json(allProgrammingLanguage); 
}

async function handelCreateNewProgrammingLanguage(req,res)
{
  const body=req.body;
  
  if(!body || !body.languageName)
  {
    return res.status(400).json({msg:'all feilds are required'});
  }
  const existing = await ProgrammingLanguage.findOne({ languageName: body.languageName });
    if (existing) {
        return res.status(409).json({ msg: 'Language already exists' });
    }
  const result= ProgrammingLanguage.create(
    {
      languageName:body.languageName,
    }
  );
  console.log('result :', result);
  return res.status(201).json({ msg: 'success',languageName:result.languageName});
}

module.exports={handelgetAllProgrammingLanguage,handelCreateNewProgrammingLanguage};