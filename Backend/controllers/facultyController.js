const Faculty = require('../models/faculty');
const {all}=require('../routes/facultyRoutes');

async function handelGetAllFaculty(req,res)
{
    const allfaculty= await Faculty.find({}).populate('branchId');
    return res.status(200).json(allfaculty);
}

async function handelCreateNewFaculty(req,res)
{
    const body= req.body;
        if(!body ||!body.facultyId || !body.password || !body.facultyName || !body.branchId )
        {
           return res.status(400).json({msg:'all feilds are required'});
        }
        const result= await Faculty.create({
            facultyId:body.facultyId,
            password:body.password,
            facultyName:body.facultyName,
            branchId: body.branchId,
        });
        console.log('result :', result);
        return res.status(201).json({ msg: 'success',id:result.facultyId});
}

module.exports={handelCreateNewFaculty,
    handelGetAllFaculty,
};