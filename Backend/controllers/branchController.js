const Branch = require('../models/branches');
const {all}=require('../routes/branchRoutes');

async function handelGetAllBranch(req,res)
{
    const allBranch=await Branch.find({});
    return res.status(200).json(allBranch);
}

async function handelCreateNewBranch(req,res)
{
    const body=req.body;
  
    if(!body || !body.branchName)
    {
        return res.status(400).json({msg:'all feilds are required'});
    }
    const existing = await Branch.findOne({ branchName: body.branchName });
        if (existing) {
            return res.status(409).json({ msg: 'Language already exists' });
        }
    const result= Branch.create(
        {
        branchName:body.branchName,
        }
    );
    console.log('result :', result);
    return res.status(201).json({ msg: 'success',Branch:result.Branch});
}

module.exports={
handelGetAllBranch, 
handelCreateNewBranch
};