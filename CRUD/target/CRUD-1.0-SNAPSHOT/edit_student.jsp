<%-- 
    Document   : add_student
    Created on : 04-Oct-2023, 19:24:36
    Author     : hp
--%>

<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.conn.DBConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="all_css.jsp"%>
    </head>
    <body class="bg-light">
        <%@ include file="navbar.jsp"%>

        <div class="container p-4">
           
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-body">
                            <p class="fs-3 text-center">Edit Student</p>
                            <% 
int id=Integer.parseInt(request.getParameter("id"));
StudentDao dao=new StudentDao(DBConnect.getConn());
Student s=dao.getStudentById(id);
                            %>
                             <form action="Update" method="POST">
  <div class="mb-3">
     <label  class="form-label">Full Name</label>
    <input type="text" name="name" value="<%=s.getFullname()%>" class="form-control">
  </div>
    
    <div class="mb-3">
    <label  class="form-label">Date of Birth</label>
    <input type="date" name="dob" value="<%=s.getDob()%>" class="form-control">
    </div>
    
    <div class="mb-3">
    <label  class="form-label">Address</label>
    <input type="text" name="address" value="<%=s.getAddress()%>" class="form-control">
    </div>
    
    <div class="mb-3">
    <label  class="form-label">qualification</label>
    <input type="text" value="<%=s.getQualification()%>" class="form-control">
    </div>
    
    <div class="mb-3">
    <label  class="form-label">Email address</label>
    <input type="email" name="email" value="<%=s.getEmail()%>" class="form-control">
    </div>
    
 
    <input type="hidden" name="id" value="<%=s.getId()%>">
  <button type="submit" class="btn btn-primary col-md-12">Update</button>
</form>
             </body>
</html>
