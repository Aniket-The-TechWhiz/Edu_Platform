const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const dotenv = require('dotenv');
dotenv.config();

// Import routes
const studentRoutes = require('./routes/studentRoutes');
const facultyRoutes =require('./routes/facultyRoutes');
const programmingLanguageRoutes=require('./routes/programmingLanguageRoutes');
const branchRoutes=require('./routes/branchRoutes');
const challengeRoutes=require('./routes/challengeRoutes');
const facultyLanguageRoutes=require('./routes/facultyLanguageRoutes');
const achievementRoutes=require('./routes/achievementRoutes');
const submissionRoutes=require('./routes/submissionRoutes');
const studentAchievementRoutes = require('./routes/studentAchievementRoutes');
const studentProgressRoutes=require('./routes/studentProgressRoutes');

const app = express();

'Middleware to parse JSON and URL-encoded data'
app.use(express.urlencoded({extended:false}));
// Middleware
app.use(cors());
app.use(express.json());

// Database connection
const mongoUri = process.env.MONGO_URI;

mongoose.connect(mongoUri)
  .then(() => console.log('MongoDB connected successfully'))
  .catch(err => console.error('MongoDB connection error:', err));

// Use routes
app.use('/api/students', studentRoutes);
app.use('/api/faculty', facultyRoutes);
app.use('/api/languages', programmingLanguageRoutes);
app.use('/api/branches', branchRoutes);
app.use('/api/challenges', challengeRoutes);
app.use('/api/faculty-languages', facultyLanguageRoutes); 
app.use('/api/achievements', achievementRoutes);
app.use('/api/submissions', submissionRoutes); 
app.use('/api/student-achievements', studentAchievementRoutes); 
app.use('/api/student-progress', studentProgressRoutes); 
/*
app.use('/api/auth', authRoutes);
*/
const PORT = 5000;

app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
