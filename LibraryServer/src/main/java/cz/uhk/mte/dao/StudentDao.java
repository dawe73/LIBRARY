package cz.uhk.mte.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cz.uhk.mte.model.Author;
import cz.uhk.mte.model.Borrowing;
import cz.uhk.mte.model.Student;
import cz.uhk.mte.service.StudentService;

public class StudentDao  extends HibernateDaoSupport implements StudentService {

	@Override
	public void insertStudent(Student student) {
		getHibernateTemplate().saveOrUpdate(student);

	}
	@Override
	@SuppressWarnings("unchecked")
	public Student getStudentByMail(String mail) {
		
		List<Student> st = getHibernateTemplate().find("from Student s where s.mail=?",mail);
		if (st.size() > 0){
			return st.get(0);
		}else {
			return null;
		}
		
	}
	@Override
	public Student getStudentByID(int ID) {
		return (Student) getHibernateTemplate().get(Student.class, ID);
	}

}
