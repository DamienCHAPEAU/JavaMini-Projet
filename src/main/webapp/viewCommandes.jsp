<%-- 
    Document   : viewCommandes
    Created on : 27 nov. 2019, 13:32:19
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

        <title>Commandes</title>
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
        
        <h1>Commande du client : ${client}</h1>
        <br>        

        <table class="table table-bordered">
            <thead><td>Numero de commande</td><td>Client</td><td>Saisie le :</td><td>Envoyée le :</td><td>Frais de port</td><td>Destinataire</td><td>Adresse de livraison</td><td>Ville de livraison</td><td>Region de livraison</td><td>Code postal</td><td>Pays</td><td>Remise</td></thead>
        <tbody>      
            <c:forEach var="code" items="${code}">                    
                <tr>
                    <td><a href="ligneCommandes?commande=${code.numero}"/>${code.numero}</a></td>
                    <td>${code.client}</td>   
                    <td>${code.saisie}</td>
                    <td>${code.envoie}</td>
                    <td>${code.port}</td>
                    <td>${code.destinataire}</td>
                    <td>${code.adresse_livraison}</td>
                    <td>${code.ville_livraison}</td>
                    <td>${code.region_livraison}</td>
                    <td>${code.code_postal_livraison}</td>
                    <td>${code.pays_livraison}</td>
                    <td>${code.remise}</td>



                </tr>	    	
            </c:forEach>    
        </tbody>
    </table>
</body>

</body>
</html>
