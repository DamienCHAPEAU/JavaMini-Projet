<%-- 
    Document   : ligneCommandes
    Created on : 8 déc. 2019, 15:20:31
    Author     : Clément
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
        <h1>Details de la commandes: ${commande}</h1>
        <table border = 1>
            <thead><td>Produit</td><td>quantité</td></thead>


        <tbody>      
            <c:forEach var="code" items="${code}">                    
                <tr>

                    <td><a href="Produit?ref=${code.numProduit}"/>${code.numProduit}</a></td>   
                    <td>${code.quantity}</td>
                </tr>	    	
            </c:forEach>    
        </tbody>
</body>
</html>
