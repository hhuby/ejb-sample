package com.tam.session;

import java.util.List;

import javax.ejb.Local;

import com.tam.domain.Student;

@Local
public interface ManageStudentSessionBeanLocal {
	public boolean addStudent(Student student);
	public List<Student> studentList();
	public boolean deleteStudent(String studentId);
	public Student editStudent(String studentId);
}
