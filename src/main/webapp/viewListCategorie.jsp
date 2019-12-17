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

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Liste des catégories</title>


    </head>
    <body>
        <div><h4>${message}</h4></div>        


        <c:choose>
            <c:when test="${sessionScope.MDP == 'admin'}">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Accueil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ListeCategorie">Liste des Categories</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" href="AddProduitAdmin">Ajouter des produits</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ModProduitAdmin">Modifier des produits</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="SupprProduitAdmin">Supprimer des produits</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CAcategorie">Chiffre d'affaires catégorie</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CAclient">Chiffre d'affaires client</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CApays">Chiffre d'affaires pays</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="deconnexion.jsp"><input class="btn btn-outline-secondary btn-sm" type="button" value="disconnect" name="disconnect" /></a>
                    </li>
                </ul>
            </div>            
        </nav>
            </c:when>
            <c:when test="${ !empty sessionScope.MDP }">
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
            </c:when>
            <c:otherwise>
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
                                <a class="nav-link" href="connexion">Espace Membre</a>
                            </li>
                        </ul>
                    </div>            
                </nav>
            </c:otherwise>
        </c:choose>        

        <br>
        <h1><center>Liste des catégories</center></h1>
        <br>

        <table class="table table-bordered">
            <thead class="thead-light">
                <tr>
                    <td>Libellé</td>
                    <td>Description</td>

                </tr>
            </thead>
            <tbody>                
                <c:forEach var="code" items="${code}">                    
                    <tr>                    
                        <td><a href="ProduitsByCategorie?categorie=${code.code}"/>${code.libelle}</a></td>
                        <td>${code.description}</td>                 
                    </tr>	  	
                </c:forEach>             
            </tbody>
        </table>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
