<%-- 
    Document   : validCommande
    Created on : 16 déc. 2019, 16:08:04
    Author     : licence
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Commande Validé</h1>
        
        ${sessionScope.MDP}
        <BR>
        ${sessionScope.client}
        <br>
        numero de commandé généré :${ NUMCOMM }
        <br>
        ${ sessionScope.map }
        <br>
        <a href="index.jsp">revenir à l'accueil</a>
        
        
    </body>
</html>
