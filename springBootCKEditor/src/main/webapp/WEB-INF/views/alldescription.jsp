<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
<title>All Descriptions</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Spring Boot</title>
</head>
    <body>
    <div>
    	<table>
            <caption><h3>Result :</h3></caption>
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Description</td>
                </tr>   
            </thead>
            <tbody>
                <c:forEach items="${inf}" var = "temp">
                    <tr>
                        <td>${temp.getId()}</td>
                        <td>${temp.getDescription1()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    	</div>
    </body>
</html>