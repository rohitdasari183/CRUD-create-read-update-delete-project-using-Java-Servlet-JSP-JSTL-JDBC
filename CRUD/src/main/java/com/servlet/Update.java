/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.conn.DBConnect;
import com.dao.StudentDao;
import com.entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class Update extends HttpServlet {

 protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
   {
       String fullname=req.getParameter("name");
       String dob=req.getParameter("dob");
       String address=req.getParameter("address");
       String qualification=req.getParameter("qualification");
       String email=req.getParameter("email");
       int id=Integer.parseInt(req.getParameter("id"));
       
       HttpSession session=req.getSession();
       
       Student student=new Student(id,fullname,dob,address,qualification,email);
       
       StudentDao dao=new StudentDao(DBConnect.getConn());
       boolean f=dao.updateStudent(student);
       if(f)
       {
           session.setAttribute("successMsg", "Data Updated successfully");
           res.sendRedirect("index.jsp");
       }
       else
       {
          session.setAttribute("errorMsg", "Data not updated");
           res.sendRedirect("index.jsp");
       }
   }
   
}
