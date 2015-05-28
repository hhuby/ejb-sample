<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EJB3 JBOSS</title>
</head>
<body>
	<form action="ManageStudentServlet" method="POST">  
  
            <table border="0" width="100%">  
                <tr>  
                    <td colspan="3">  ${message}</td>
		
		  
                </tr>
                <tr>  
                    <td>Id</td>  
                    <td>:</td>  
                    <td><input type="text" id="idStudent" name="idStudent" value="${studentId}" disabled /></td>  
                </tr>  
                <tr>  
                    <td>First Name</td>  
                    <td>:</td>  
                    <td><input type="text" id="fname" name="fname" value="${firstName}" /></td>  
                </tr>  
                <tr>  
                    <td>Last Name</td>  
                    <td>:</td>  
                    <td><input type="text" id="lname" name="lname" value="${lastName}" /></td>  
                </tr>  
                <tr>  
                    <td>Email</td>  
                    <td>:</td>  
                    <td><input type="text" id="email" name="email" value="${email}" /></td>  
                </tr>  
                <tr>  
                    <td></td>  
                    <td></td>
                    <td><input type="hidden" value="add" name="action" /></td>  
                    <td><input type="submit" value="Add" name="Add" /></td>  
                </tr>  
            </table>  
  
        </form>  
        <div>
        	<table style="border: 1px; border-color: #000">
	        	<thead>
	        		<tr>
	        			<td>Id</td>
	        			<td>E-mail</td>
	        			<td>FirsName</td>
	        			<td>LastName</td>
	        			
	        		</tr>
	        	</thead>
	        	<tbody>
	        		
	        		<c:forEach var="item" items="${studentList}">
	        			<tr>
	        				<td><c:out value="${item.id}"/></td>
	        				<td><c:out value="${item.email}"/></td>
	        				<td><c:out value="${item.firstName}"/></td>
	        				<td><c:out value="${item.lastName}"/></td>
	        				<td>
	        					<form method="post" action="ManageStudentServlet">
	        						<input type="hidden" value="delete" name="action" />
	        						<input type="hidden" value="${item.id}" name="id" />
	        						<input type="submit" value="Delete" name="Delete" />
	        					</form>	
	        				</td>
	        				<td>
	        					<form method="post" action="ManageStudentServlet">
	        						<input type="hidden" value="edit" name="action" />
	        						<input type="hidden" value="${item.id}" name="id" />
	        						<input type="submit" value="Edit" name="Edit" />
	        					</form>	
	        				</td>
	        			</tr>
        			</c:forEach>
	        	</tbody>
        	</table>
        </div>	
        <script type="text/javascript">
			
        </script>
</body>
</html>
