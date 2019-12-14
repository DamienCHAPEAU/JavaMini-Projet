<%-- 
    Document   : viewClientupdate
    Created on : 14 déc. 2019, 19:23:11
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
        
        
        
     <c:if test="${ !empty sessionScope.LOG && !empty sessionScope.MDP }">
        <p>Vous êtes ${ sessionScope.client }  !</p>
    </c:if>
        
        ${adresse}
        
    <form method="post">
        <p>
            <label for="societe">societe : </label>
            <input type="text" name="societe" id="societe" size="30" value='${ societe }'/>
        </p>
        <p>
            <label for="contact">contact : </label>
            <input type="text" name="contact" id="contact" value='${client}' />
        </p>
                <p>
            <label for="fonction">fonction : </label>
            <input type="text" name="fonction" id="fonction" value="${fonction}"/>
        </p>
                <p>
            <label for="adresse">adresse : </label>
            <input type="text" name="adresse" id="adresse" size="30" value="${adresse}" />
        </p>
                <p>
            <label for="ville">ville : </label>
            <input type="text" name="ville" id="ville"  value='${ville}' />
        </p>
                <p>
            <label for="region">region : </label>
            <input type="text" name="region" id="region"  value='${region}' />
        </p>
                <p>
            <label for="codepostal">code Postal : </label>
            <input type="text" name="codepostal" id="codepostal"  value='${codepostal}'/>
        </p>
                <p>
            <label for="pays">pays : </label>
            <input type="text" name="pays" id="pays" value='${pays}' />
        </p>
                <p>
            <label for="telephone">telephone : </label>
            <input type="text" name="telephone" id="telephone" value='${telephone}' />
        </p>
                <p>
            <label for="fax">fax : </label>
            <input type="text" name="fax" id="fax"  value='${fax}' />
        </p>
        
        <input type="submit" />
    </form>
        
      
    </body>
</html>
