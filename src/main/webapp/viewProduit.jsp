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
        <title>Liste des produits</title>
        
        
    </head>
    <body>
        <div><h4>${message}</h4></div>
        <h1>Liste des produits</h1>
        <table>
            <thead><td>Nom</td><td>Categorie</td><td>Prix</td><td>Lien</td></thead>
            <tbody>                
                <c:forEach var="code" items="${CODE}">                    
                    <tr>
                        <td>${code.NUMERO}</td>
                        <td>${code.CLIENT}</td>
                        <td>${code.SAISIE_LE}</td>                        
                        <%--<td><a title=${code.nom} href="vue"+${code.code}/></a>${code.libelle}</td>--%>                  
                    </tr>	  	
                </c:forEach>             
            </tbody>
        
    </body>
</html>
