<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="project.studentWeb" %>
<%@ page import="helper.FactoryProvider" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Student</title>
    <style>
        h1{
            text-align: center;
        }
        tr,td{
            border: 2px solid;
        }
        table{
            text-align: center;
            margin-left: 30%;
            width: 50%;
            border: 2px solid;
        }
        a{
            margin-left: 50%;
        }
    </style>
</head>
<body>
    <h1><u>STUDENT'S LIST</u></h1>
    <table>
        <tr>
            <td><b>Student's roll</b></td>
            <td><b>Student's Name</b></td>
            <td><b>Student's E-mail</b></td>
        </tr>
        
        <% 
   
            Session session2 = FactoryProvider.getFactory().openSession();
            
            try {
                session2.beginTransaction();
                List<studentWeb> employees = session2.createQuery("from studentWeb").getResultList();
                
                for (studentWeb stdStudentWeb : employees) {
        %>
                <tr>
                    <td><%= stdStudentWeb.getRoll() %></td>
                    <td><%= stdStudentWeb.getName() %></td>
                    <td><%= stdStudentWeb.getEmail() %></td>
                </tr>
        <%
                }
                session2.getTransaction().commit();
            } finally {
            	session2.close();
            }
        %>
    </table>
    <a href="index.jsp">HOME</a>
</body>
</html>