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
        <h1>Commande du client : ${client}</h1>
    </body>

    <table border = 1>
        <thead><td>numero de commande</td><td>client</td><td>saisie le :</td><td>envoyée le :</td><td>frais de port</td><td>destinataire</td><td>adresse de livraison</td><td>ville de livraison</td><td>region de livraison</td><td>code postal</td><td>pays</td><td>remise</td></thead>
    <tbody>      
        <c:forEach var="code" items="${code}">                    
            <tr>
                <td>${code.numero}</td>
                <td>${code.client}</td>   
                <td>${code.saisie}</td>
                <td>${code.envoie}</td>
                <td>${code.port}</td>
                <td>${code.destinataire}</td>
                <td>${code.adresse_livraison}</td>
                <td>${code.ville_livraison}</td>
                <td>${code.region_livraison}</td>
                <td>${code.code_postal_livraison}</td>
                <td>${code.pays_livraison}</td>
                <td>${code.remise}</td>



            </tr>	    	
        </c:forEach>    
    </tbody>
</html>
