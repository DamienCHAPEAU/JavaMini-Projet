<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Liste des produits par catégories</title>


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
                                <a class="nav-link" href="ProduitAdmin">Liste des produits</a>
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
        <h1><center>Liste des produits par catégories</center></h1>
        <br>
        <% if (session.getAttribute("client") != null) {%>
        <a href="Panier">Voir le panier</a>
        <%}%>
        <table class="table table-bordered">
            <thead><td>Nom</td><td>Categorie</td><td>Prix</td>  
            <% if (session.getAttribute("client") != null) {%>
            <td>ref</td> <td>${ MessageprodCat }</td>
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
                    <input class="btn btn-secondary" type="submit" value="ajouter au panier">
                </td>       

            </form>
            <%}%>

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
