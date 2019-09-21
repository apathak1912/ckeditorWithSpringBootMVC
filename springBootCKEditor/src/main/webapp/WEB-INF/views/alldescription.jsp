<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
<title>All Descriptions</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Description</title>
        <title>cell padding</title> 
        <style> 
            table, th, td { 
                border: 2px solid green; 
                text-align:center; 
            } 
            th, td { 
                padding: 20px; 
                background-color:none; 
            } 
              
            h1 { 
            color:green; 
            } 
        </style> 
</head>
    <body>
    <div>
    	<table style ="border: solid red">
            <caption><h3>Result :</h3></caption>
            <thead  style ="border: solid red">
                <tr >
                    <td >Id</td>
                    <td >Description</td>
                    <td >Edit</td>
                </tr>   
            </thead>
            <tbody>
                <c:forEach items="${inf}" var = "temp">
                    <tr>
                        <td>${temp.getId()}</td>
                        <td><a href="/descriptionview/${temp.getDescription1()}" class="dis-block txt3 hov1 p-r-30 p-t-10 p-b-10 p-l-30">${temp.getDescription1()}</a></td>
                        <td ><a href="/edit/${temp.getDescription1()}" class="dis-block txt3 hov1 p-r-30 p-t-10 p-b-10 p-l-30">Edit</a></td>
						<td ><a href="/edit/${temp.getId()}" class="dis-block txt3 hov1 p-r-30 p-t-10 p-b-10 p-l-30">Editid</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    	</div>
    </body>
</html>

