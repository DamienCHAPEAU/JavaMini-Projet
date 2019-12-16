<%-- 
    Document   : admin
    Created on : 16 déc. 2019, 22:32:44
    Author     : damsc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


        <title>Page Client</title>
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
        <br>
    <center><h1>Bonjour ${admin}</h1></center>
    <br>


</body>
</html>