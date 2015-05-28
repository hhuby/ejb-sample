package com.tam.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;




import com.tam.domain.Student;

/**
 * Session Bean implementation class ManageStudentSessionBean
 */
@Stateless
public class ManageStudentSessionBean implements ManageStudentSessionBeanLocal {
    
    @PersistenceContext EntityManager entityManager;
    
    public boolean addStudent (Student student){
    	entityManager.persist(student);
    	return true;
    }
    
    public List<Student> studentList(){
    	List<Student> studentList = entityManager.createQuery("from Student s").getResultList();
    	return studentList;
    }
    
    public boolean deleteStudent(String studentId){
    	boolean result = false;
    	Student student = entityManager.find(Student.class, Integer.parseInt(studentId));
        if (student != null) {
            entityManager.remove(student);
            result = true;
        }
        return result;
    }
    
    public Student editStudent(String studentId){
    	Student student = entityManager.find(Student.class, Integer.parseInt(studentId));
        return student;
    }
    
}
