<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chiffres d'affaire categorie</title>
        
        
    </head>
    <body>
        
        <h1>Chiffres d'affaire categorie</h1>
        
        <form method='GET'>            
            Saisie le : <input name="Saisie_le" type="date" max="1999-12-31" min="1994-01-01"><br/>
            Envoyee le : <input name="Envoyee_le" type="date" max="1999-12-31" min="1994-01-01"><br/>           
            <input type="submit" value="Chercher">
        </form>
        <div><h4>${message}</h4></div>
        <table border="1">
            <thead><td>Categorie</td><td>CA</td></thead>
            <tbody>                
                <c:forEach var="code" items="${code}">                    
                    <tr>
                        <td>${code.client}</td>  
                        <td>${code.CA}</td>                                              
                    </tr>	  	
                </c:forEach>             
            </tbody>
            </table>
    </body>
    
</html>
