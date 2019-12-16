<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Connexion</title>
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
                        <a class="nav-link" href="connexion">Espace Membre</a>
                    </li>
                </ul>
            </div>            
        </nav>

        <c:if test="${ !empty sessionScope.LOG && !empty sessionScope.MDP }">
            <p>Vous êtes ${ sessionScope.LOG } ${ sessionScope.MDP } !</p>
        </c:if>
       <br>
        <h1><center>Se connecter</center></h1>
        <br> 
        <br>  <br>  
        
    <center>
        <form method="post">
            <div class="form-group">
                <label for="LOG">Identifiant : </label>
                <input type="text" name="LOG" id="LOG" />
            </div>
            <div class="form-group">
                <label for="MDP">Mot de passe : </label>
                <input type="password" name="MDP" id="MDP" />
            </div>
            <button type="submit" class="btn btn-primary">Se connecter</button>
        </form>
    </center>
</body>
</html>