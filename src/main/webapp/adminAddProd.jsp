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
        <h1>Ajouter des Produit</h1>
        <br>
        
        <form method="post">
            <div class="form-group">
                <label>Reference : </label>
                <input type="text" name="ref" id="ref" />
            </div>
            <div class="form-group">
                <label>Nom : </label>
                <input type="text" name="name" id="name" />
            </div>
            <div class="form-group">
                <label>Catégorie : </label>
                <input type="text" name="cat" id="cat" />
            </div>
            <div class="form-group">
                <label>Prix : </label>
                <input type="text" name="prix" id="prix" />
            </div>
            <!--<div class="form-group">
                <label>Fournisseur : </label>
                <input type="text" name="fourn" id="fourn" />
            </div>
            
            <div class="form-group">
                <label>Quantité unité : </label>
                <input type="text" name="qt" id="qt" />
            </div>
            
            <div class="form-group">
                <label>Unité en stock : </label>
                <input type="text" name="stock" id="stock" />
            </div>
            <div class="form-group">
                <label>Unité commandée : </label>
                <input type="text" name="commande" id="commande" />
            </div>
            <div class="form-group">
                <label>Niveau d'approvisionnement : </label>
                <input type="text" name="appro" id="appro" />
            </div>
            <div class="form-group">
                <label>Indisponible(0 ou 1) : </label>
                <input type="indis" name="prix" id="indis" />
            </div>-->
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </form>
        ${ messageUpdate }
        <table class="table table-bordered">
            <thead><td>Nom</td><td>Categorie</td><td>Prix</td> 

            <tbody>                
                <c:forEach var="code" items="${code}">                    
                    <tr>
                        <td>${code.nom}</td>
                        <td>${code.categorie}</td>
                        <td>${code.prix_unitaire}</td>
                    </tr>	  	
                    </c:forEach>  
                </tbody>
            </table>


        </body>
    </html>
