/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class StudentDao 
{
    private Connection conn;
    public StudentDao(Connection conn)
    {
        super();
        this.conn=conn;
    }
    public boolean addStudent(Student student)
    {
        boolean f=false;
        try{
        String sql="insert into student(fullname,dob,address,qualification,email) values(?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,student.getFullname());
        ps.setString(2,student.getDob());
        ps.setString(3,student.getAddress());
        ps.setString(4,student.getQualification());
        ps.setString(5,student.getEmail());

        
        
        int i=ps.executeUpdate();
        if(i==1)
        {
            f=true;
        }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;
        
        
    }
    public List<Student> getAllStudent()
    {
        List<Student> list=new ArrayList<>();
        Student s=null;
        try
        {
            String sql="select * from student";
            Statement ps=conn.createStatement();
            ResultSet rs=ps.executeQuery(sql);
            while(rs.next())
            {
                s=new Student();
                s.setId(rs.getInt(1));
                s.setFullname(rs.getString(2));
                s.setDob(rs.getString(3));
                s.setAddress(rs.getString(4));
                s.setQualification(rs.getString(5));
                s.setEmail(rs.getString(6));
                list.add(s);
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
        
    }
    public Student getStudentById(int id)
    {
        Student s=null;
        try
        {
            String sql="select * from student where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                s=new Student();
                s.setId(rs.getInt(1));
                s.setFullname(rs.getString(2));
                s.setDob(rs.getString(3));
                s.setAddress(rs.getString(4));
                s.setQualification(rs.getString(5));
                s.setEmail(rs.getString(6));
               
                
            }
            rs.close();
            ps.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return s;
    }
    public boolean updateStudent(Student student)
    {
        boolean f=false;
        try{
        String sql="update student set fullname=?,dob=?,address=?,qualification=?,email=? where id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,student.getFullname());
        ps.setString(2,student.getDob());
        ps.setString(3,student.getAddress());
        ps.setString(4,student.getQualification());
        ps.setString(5,student.getEmail());
        ps.setInt(6,student.getId());

        
        
        int i=ps.executeUpdate();
        if(i==1)
        {
            f=true;
        }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;
        
    }
    public boolean deleteStudent(int id)
    {
        boolean f=false;
        try
        {
            String sql="delete from student where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            
            int m=ps.executeUpdate();
            if(m==1)
            {
                f=true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;
    }
    
}
