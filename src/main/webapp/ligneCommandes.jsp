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
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Commandes</title>
    </head>
    <body>
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
        <h1>Details de la commandes: ${commande}</h1>
        <br>
        <table class="table table-bordered">
            <thead><td>Nom produit</td><td>Reference</td><td>Categorie</td><td>Prix unitaire</td><td>Quantité</td></thead>
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
