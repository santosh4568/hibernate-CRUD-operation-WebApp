<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        input{
            margin: 5px;
            height: 25px;
            width: 300px;
        }
        #btn{
            background-color: green;
            width: fit-content;
        }
        form{
            text-align: center;
        }
    </style>
</head>
<body>
    <h1><u>DELETE STUDENT</u></h1>
    <form action="deleteStudentServlet" method="post">
        <input type="number" placeholder="Enter Roll Number" name="roll" required><br>
        <input type="submit" value="Submit" id="btn">
    </form>
</body>
</html>