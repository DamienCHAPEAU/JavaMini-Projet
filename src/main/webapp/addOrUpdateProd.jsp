<%-- 
    Document   : addOrUpdateProd
    Created on : 16 déc. 2019, 23:43:57
    Author     : Clément
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
        <div><h4></h4></div>
        
        
        
        <table class="table table-bordered">
            <thead><td>reference</td><td>Nom</td><td>Categorie</td><td>Prix</td>
            
            <tbody>                
                                    
                <form method="post">   
                    
                    <tr>
                    
                    <td><input type="text" name="nomU" id="refernceU" value = "${produitU.reference}" size="5" readonly/></td>
                    <td><input type="text" name="nomU" id="nomU" value = "${produitU.nom}" size="5" readonly/></td>
                    <td><input type="text" name="catU" id="catU" value = "${produitU.categorie}" size="5" readonly/></td>    
                    <td><input type="text" name="prixU" id="prixU" value = "${produitU.prix_unitaire}" size="5" readonly/></td>

                    <td>
                        
                        <input class="btn btn-secondary" type="submit" value="modifier">
                    </td>       

                </form>

            </tr>	  	
                    
    </tbody>
</table>
        
        
        
        
    </body>
</html>
