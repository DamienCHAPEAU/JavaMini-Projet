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
            <thead><td>nom produit</td><td>reference</td><td>categorie</td><td>prix unitaire</td><td>quantité</td></thead>


        <tbody>      

                
            <c:forEach var="prod" items="${prod}" >                    
                <tr>

                    
                    <td>${prod.nom}</td>
                    <td>${prod.reference}</td>
                    <td>${prod.categorie}</td>
                    <td>${prod.prix_unitaire}</td>
                    <td>${prod.quantity}</td>
                    
                </tr>	    	
            </c:forEach>        
        </tbody>
</body>
</html>
