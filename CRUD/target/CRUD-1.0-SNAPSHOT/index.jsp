<%-- 
    Document   : index
    Created on : 04-Oct-2023, 19:14:30
    Author     : hp
--%>

<%@page import="java.util.List"%>
<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.conn.DBConnect"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="all_css.jsp"%>
    </head>
    <body>
       
       
        <%@include file="navbar.jsp"%> 
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>      
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        
        <div class="container p-5">
             <div class="card">
                <div class="card-body">
            <p class="text-center">All Student Details</p>
             <c:if test="${not empty successMsg}">
                                <p class="text-center text-success">${successMsg}</p>
                                <c:remove var="successMsg"/>
                            </c:if>
                                  <c:if test="${not empty errorMsg}">
                                <p class="text-center text-success">${errorMsg}</p>
                                <c:remove var="errorMsg"/>
                            </c:if>
           <table class="table">
  <thead>
    
      
      <th scope="col">Full Name</th>
      <th scope="col">DOB</th>
      <th scope="col">Address</th>
      <th scope="col">Qualification</th>
      <th scope="col">Email</th>
      <th scope="col">Action</th>
      
      
      <th></th>
      
    
  </thead>
  <tbody>
     <%
         
StudentDao dao = new StudentDao(DBConnect.getConn());
List<Student> list = dao.getAllStudent();
for (Student s : list) {
%>
   <tr>
      <td><%= s.getFullname() %></td>
      <td><%= s.getDob() %></td>
      <td><%= s.getAddress() %></td>
      <td><%= s.getQualification() %></td>
      <td><%= s.getEmail() %></td>
      <td>
         <a href="edit_student.jsp?id=<%= s.getId() %>" class="btn btn-sm btn-primary">Edit</a>
         <a href="Delete?id=<%= s.getId() %>" class="btn btn-sm btn-danger ms-1">Delete</a>
      </td>
   </tr>
<%
}
%>







  </tbody>
</table>
                </div>
             </div>
        </div>
       
                        
    </body>
</html>
