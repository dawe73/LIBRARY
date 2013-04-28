package cz.uhk.mte.service;

import cz.uhk.mte.model.Student;

public interface StudentService {

	public void insertStudent(Student student);
	
	public Student getStudentByMail(String mail);
	
	public Student getStudentByID(int ID);
	
}
