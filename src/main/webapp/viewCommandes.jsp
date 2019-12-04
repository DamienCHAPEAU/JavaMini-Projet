<%-- 
    Document   : viewCommandes
    Created on : 27 nov. 2019, 13:32:19
    Author     : pedago
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
    
     <table>
            <thead><td>Code</td><td>Libelle</td><td>Description</td></thead>
            <tbody>      
        <c:forEach var="code" items="${code}">                    
                    <tr>
                        <td>${code.code}</td>
                        <td><a href="viewCategorie=${code.code}"/>${code.libelle}</a></td>
                        <td>${code.description}</td>                 
                    </tr>	    	
                </c:forEach>    
                    </tbody>
</html>
