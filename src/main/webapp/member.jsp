<%-- 
    Document   : member
    Created on : 14 déc. 2019, 17:37:57
    Author     : Clément
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bonjour ${client}</h1>

         <a href="ListeCategorie">Liste des Categories</a>
         <br>
         <a href="Produit">Liste des produits</a>
         <br>
        <a href="Commandes">Listes Commandes</a>
        <br>
        <a href="Client">Info Client</a>
        <br>

        <a href="deconnexion.jsp"><input type="button" value="disconnect" name="disconnect" /></a>

    </body>
</html>
