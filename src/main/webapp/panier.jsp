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
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Votre Panier :</title>
    </head>
    <body>
        <div><h4></h4></div>  
        
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/JavaMini-Projet">Accueil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ListeCategorie">Liste des Categories</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Produit">Liste des produits</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Commandes">Listes Commandes</a> 
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Client">Info Client</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="deconnexion.jsp"><input class="btn btn-outline-secondary btn-sm" type="button" value="disconnect" name="disconnect" /></a>
                    </li>
                </ul>
            </div>            
        </nav>
        <br>
        <h1>Votre Panier :</h1>
        <br>
        <!--${sessionScope.map}-->
        

        <table class="table table-bordered">
            <thead><td>Nom</td><td>Categorie</td><td>Prix</td><td>ref</td><td>quantité</td><td>${ sessionScope.map }</td></thead>
        <tbody>                
            <c:forEach var="code" items="${code}">                    
                <tr>
            <form method="post">
                <td>${code.reference}</td>

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
