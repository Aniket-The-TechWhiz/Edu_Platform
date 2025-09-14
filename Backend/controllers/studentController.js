const student=require('../models/student');
const {all}=require('../routes/studentRoutes');

async function handelGetAllStudent(req,res)
{
    const allStudent=await student.find({}).populate('branchId');;
    return res.status(200).json(allStudent);
}


async function handelCreateNewStudent(req,res)
{
    const body= req.body;
    if(!body ||!body.studentId || !body.password || !body.studentName || !body.yearOfStudy || !body.studentEmail || !body.branchId)
    {
       return res.status(400).json({msg:'all feilds are required'});
    }
    const result= await student.create({
        studentId:body.studentId,
        password:body.password,
        studentName:body.studentName,
        yearOfStudy:body.yearOfStudy,
        studentEmail:body.studentEmail,
        branchId: body.branchId,
    });
    console.log('result :', result);
    return res.status(201).json({ msg: 'success',id:result.studentId});
}
module.exports={
    handelGetAllStudent,
    handelCreateNewStudent,
};
