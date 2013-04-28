package cz.uhk.mte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cz.uhk.mte.model.Student;
import cz.uhk.mte.service.StudentService;

public class StudenServiceImpl implements StudentService {

	@Autowired
	StudentService studentDao;
	
	@Override
	public void insertStudent(Student student) {
		studentDao.insertStudent(student);
	}

	@Override
	public Student getStudentByMail(String mail) {
		return studentDao.getStudentByMail(mail);
	}

	public StudentService getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentService studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public Student getStudentByID(int ID) {
		return studentDao.getStudentByID(ID);
	}

	
}
