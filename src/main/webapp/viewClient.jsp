<%-- 
    Document   : viewClient
    Created on : 4 déc. 2019, 13:41:56
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info Client</title>
    </head>
    <body>
        <h1>client : ${client} | Informations personnelles : </h1>
        <table border = 1>
            <thead><td>Client</td><td>Société</td><td>Contact</td><td>Fonction</td><td>Adresse</td><td>Ville</td><td>Région</td><td>Code Postal</td><td>Pays</td><td>Téléphone</td><td>FAX</td></thead>
        <tbody>      
            <c:forEach var="code" items="${code}">                    
                <tr>
                    <td>${code.CODE}</td>
                    <td>${code.societe}</td>   
                    <td>${code.contact}</td>
                    <td>${code.fonction}</td>
                    <td>${code.adresse}</td>
                    <td>${code.ville}</td>
                    <td>${code.region}</td>
                    <td>${code.codePostal}</td>
                    <td>${code.pays}</td>
                    <td>${code.telephone}</td>
                    <td>${code.fax}</td>

                </tr>	    	
            </c:forEach>  
        </tbody>
        <br>
        <a href=""> <input type="button" value="Modifier mes informations"></a>

</body>
</html>
