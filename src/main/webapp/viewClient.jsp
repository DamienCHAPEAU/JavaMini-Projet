<%-- 
    Document   : viewClient
    Created on : 4 déc. 2019, 13:41:56
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

        <title>Info Client</title>
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

        <h1>Client : ${client} | Informations personnelles : </h1>
        <br>
        <table class="table table-bordered">
            <thead><td>Société</td><td>Contact</td><td>Fonction</td><td>Adresse</td><td>Ville</td><td>Région</td><td>Code Postal</td><td>Pays</td><td>Téléphone</td><td>FAX</td></thead>
        <tbody>      
            <c:forEach var="code" items="${code}">                    
                <tr>

                    <td>${code.societe}</td>   
                    <td>${code.contact}</td>
                    <td>${code.fonction}</td>
                    <td>${code.adresse}</td>
                    <td>${code.ville}</td>
                    <td>${code.region}</td>
                    <td>${code.codePostal}</td>
                    <td>${code.pays}</td>
                    <td>${code.telephone}</td>
                    <td>${code.fax}</td>

                </tr>	    	
            </c:forEach>  
        </tbody>
        <br>
    </table>
    <a href="updateInfo"> <input class="btn btn-primary" type="button" value="Modifier mes informations"></a>

</body>
</html>
