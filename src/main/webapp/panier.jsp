<%-- 
    Document   : panier
    Created on : 15 déc. 2019, 15:59:50
    Author     : Clément
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Votre Panier :</title>
    </head>
    <body>
        <h1>Votre Panier :</h1>
        
        ${sessionScope.map}
        
        <table border="1">
            <thead><td>Nom</td><td>Categorie</td><td>Prix</td><td>ref</td><td>quantité</td></thead>
            <tbody>                
                <c:forEach var="code" items="${code}">                    
                    <tr>
                        <form method="post">
                            <td><input value="${code.reference}"  name="refu" id="refu" size="1" readonly></td>
                            
                        <td>${code.nom}</td>
                        <td>${code.categorie}</td>
                        <td>${code.prix_unitaire}</td>
                        
                        
                        <td>   
                            
                                   
                            <input type="text" value="${code.quantity}" size="5" name="qteu" id="qteu"> 
                            </td>
                            <td>
                            <input type="submit" value="mettre à jour">
                            </form>

                        </td>
                        
                                                   
                    </tr>	  	
                </c:forEach>             
            </tbody>
        
        
    </body>
</html>
