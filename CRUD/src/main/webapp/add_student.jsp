<%-- 
    Document   : add_student
    Created on : 04-Oct-2023, 19:24:36
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="all_css.jsp"%>
    </head>
    <body>
         <%@ include file="navbar.jsp"%>
        <div class="container p-4">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-body">
                            <p class="fs-3 text-center">Add Student</p>
                            <c:if test="${not empty successMsg}">
                                <p class="text-center text-success">${successMsg}</p>
                                <c:remove var="successMsg"/>
                            </c:if>
                                  <c:if test="${not empty errorMsg}">
                                <p class="text-center text-success">${errorMsg}</p>
                                <c:remove var="errorMsg"/>
                            </c:if>
                             <form action="RegisterServlet" method="POST">
  <div class="mb-3">
     <label  class="form-label">Full Name</label>
    <input type="text" name="name" class="form-control">
  </div>
    
    <div class="mb-3">
    <label  class="form-label">Date of Birth</label>
    <input type="date" name="dob" class="form-control">
    </div>
    
    <div class="mb-3">
    <label  class="form-label">Address</label>
    <input type="text" name="address" class="form-control">
    </div>
    
    <div class="mb-3">
    <label  class="form-label">qualification</label>
    <input type="text" name="qualification" class="form-control">
    </div>
    
    <div class="mb-3">
    <label  class="form-label">Email address</label>
    <input type="email" name="email" class="form-control">
    </div>
    
 

  <button type="submit" class="btn btn-primary col-md-12">Submit</button>
</form>
        
    </body>
</html>
