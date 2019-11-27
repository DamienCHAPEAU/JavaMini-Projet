<%-- 
    Document   : vueCategorie
    Created on : 27 nov. 2019, 13:30:25
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des catégories</title>
    </head>
    <body>
        <h1>Liste des catégories</h1>
        <table>
            <thead><td>Libelle</td></thead>
            <tbody>                
                <c:forEach var="code" items="${code}">                    
                    <tr>
                        <td>${code.code}</td>
                        <td>${code.description}</td>
                        <td>${code.libelle}</td>
                        <td><a title=${code.description} href="vue"+${code.code}/></a>${code.libelle}</td>                  
                    </tr>	  	
                </c:forEach>             
            </tbody>
        
    </body>
</html>
