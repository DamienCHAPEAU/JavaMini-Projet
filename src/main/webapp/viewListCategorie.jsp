<%-- 
    Document   : vueCategorie
    Created on : 27 nov. 2019, 13:30:25
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des catégories</title>
        
        
    </head>
    <body>
        <div><h4>${message}</h4></div>
        <h1>Liste des catégories</h1>
        <table border="1">
            <thead><td>Code</td><td>Libelle</td><td>Description</td></thead>
            <tbody>                
                <c:forEach var="code" items="${code}">                    
                    <tr>
                        <td>${code.code}</td>
                        <td><a href="ProduitsByCategorie?categorie=${code.code}"/>${code.libelle}</a></td>
                        <td>${code.description}</td>                 
                    </tr>	  	
                </c:forEach>             
            </tbody>
        
    </body>
</html>
