/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.conn.DBConnect;
import com.dao.StudentDao;
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
public class Delete extends HttpServlet 
{

      protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
      {
          int id=Integer.parseInt(req.getParameter("id"));
          
          StudentDao dao=new StudentDao(DBConnect.getConn());
          boolean f=dao.deleteStudent(id);
          
                 HttpSession session=req.getSession();
 if(f)
       {
           session.setAttribute("successMsg", "Data deleted successfully");
           res.sendRedirect("index.jsp");
       }
       else
       {
          session.setAttribute("errorMsg", "Data not deleted ");
           res.sendRedirect("index.jsp");
       }
       
      }


   

}
