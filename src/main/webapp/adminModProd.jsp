<%-- 
    Document   : adminProd
    Created on : 17 déc. 2019, 00:29:34
    Author     : licence
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

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
        <br>
        <h1>Modification Produit</h1>
        <br>



        <table class="table table-bordered">
            <thead><td>Nom</td><td>Categorie</td><td>Prix</td><td>ref</td> <td>${ messageUpdate }</td>


            <tbody>                
                <c:forEach var="code" items="${code}">                    
                    <tr>

                <form method="post">                       

                    <td><input type="text" name="nomU" id="nomU" value = "${code.nom}"  size="30"/></td>
                    <td><input type="text" name="catU" id="catU" value = "${code.categorie}" size="5" /></td>    
                    <td><input type="text" name="prixU" id="prixU" value = "${code.prix_unitaire}" size="5" /></td>
                    <td><input type="text" name="refUPDATE" id="refUPDATE" value = "${code.reference}" size="5" readonly/></td>

                    <td>                        
                        <input class="btn btn-secondary" type="submit" value="modifier">
                    </td>       

                </form>


            </tr>	  	
        </c:forEach>             
    </tbody>


</body>
</html>
