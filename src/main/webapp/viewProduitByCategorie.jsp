<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des produits par catégories</title>
        
        
    </head>
    <body>
        <div><h4>${message}</h4></div>
        <h1>Liste des produits par catégories</h1>
        <table border="1">
            <thead><td>Nom</td><td>Categorie</td><td>Prix</td></thead>
            <tbody>                
                <c:forEach var="code" items="${code}">                    
                    <tr>
                        <td>${code.nom}</td>
                        <td>${code.categorie}</td>
                        <td>${code.prix_unitaire}</td>
                    </tr>	  	
                </c:forEach>             
            </tbody>
        
    </body>
</html>
