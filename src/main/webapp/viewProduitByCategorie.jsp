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
            <thead><td>Nom</td><td>Categorie</td><td>Prix</td>  
            <% if (session.getAttribute("client") != null) {%>
            <td>ref</td> 
            <%}%>
        </thead>
        <tbody>                
            <c:forEach var="code" items="${code}">                    
                <tr>

                    <td>${code.nom}</td>
                    <td>${code.categorie}</td>
                    <td>${code.prix_unitaire}</td>

                    <% if (session.getAttribute("client") != null) {%>
            <form method="post">

                <td><input type="text" name="ref" id="ref" value = "${code.reference}" size="5" readonly/></td>

                <td>
                    <label for="qte">quantité à ajouter : </label>
                    <input type="text" value="1" name="qte" id="qte"> 
                    <input type="submit" value="ajouter au panier">
                </td>       

            </form>
            <%}%>

        </tr>	  	
    </c:forEach>             
</tbody>

<% if (session.getAttribute("client") != null) {%>
<a href="Panier">Voir le panier</a>
<%}%>
</body>
</html>
