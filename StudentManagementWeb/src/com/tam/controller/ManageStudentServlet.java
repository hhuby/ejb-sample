package com.tam.controller;

import java.io.IOException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tam.domain.Student;
import com.tam.session.ManageStudentSessionBeanLocal;

/**
 * Servlet implementation class ManageStudentServlet
 */
public class ManageStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ManageStudentSessionBeanLocal manageStudentSessionBeanLocal;
    
    public void init(ServletConfig config) throws ServletException {  
    	  
    	  super.init(config);  
    	  try {  
    	  
    	  Context context = new InitialContext();  
    	   manageStudentSessionBeanLocal = (ManageStudentSessionBeanLocal) context  
    	     .lookup("ManageStudentSessionBean/local");  
    	  
    	  } catch (NamingException e) {  
    	   e.printStackTrace();  
    	  }
    }
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Student> list = manageStudentSessionBeanLocal.studentList();
		request.setAttribute("studentList", list);
		request.setAttribute("message", "Nuevo Registro");  
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  
		rd.forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		String studentId = "";
		String firstName = "";
		String lastName = "";
		String email = "";
		String action = "";
		
		action = request.getParameter("action");
		if(action.equals("add")){
			firstName = request.getParameter("fname");
			lastName = request.getParameter("lname");
			email = request.getParameter("email");
			
			Student student = new Student();  
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setEmail(email);
			if (manageStudentSessionBeanLocal.addStudent(student)) {  
				message = "Student Successfuly Added";
				studentId = "";
				firstName = "";
				lastName = "";
				email = "";
			} else {  
				message = "Student Adding Failed";  
			}
		}else if(action.equals("delete")){
			String idStudent = request.getParameter("id");
			if(manageStudentSessionBeanLocal.deleteStudent(idStudent)){
				message = "Student Successfuly deleted";
			}else{
				message = "Student deleteing failed";
			}
		}else if(action.equals("edit")){
			String idStudent = request.getParameter("id");
			Student student = manageStudentSessionBeanLocal.editStudent(idStudent);
			studentId = "" + student.getId();
			firstName = student.getFirstName();
			lastName = student.getLastName();
			email = student.getEmail();
		}
		List<Student> list = manageStudentSessionBeanLocal.studentList();   
		
		request.setAttribute("studentList", list);
		request.setAttribute("studentId", studentId);
		request.setAttribute("message", message);
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName); 
		request.setAttribute("email", email);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  
		rd.forward(request, response);  
		
	}

}
