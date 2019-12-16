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
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Modification client</title>
    </head>
    <body>


        <br>
    <c:if test="${ !empty sessionScope.LOG && !empty sessionScope.MDP }">
        <p>Vous êtes ${ sessionScope.client }  !</p>
    </c:if>

    <!--${adresse}-->

    <form method="post">
        <div class="form-group">
            <label for="societe">societe : </label>
            <input type="text" name="societe" id="societe" size="30" value='${ societe }'/>
        </div>
        <div class="form-group">
            <label for="contact">contact : </label>
            <input type="text" name="contact" id="contact" value='${client}' />
        </div>
        <p>
            <label for="fonction">fonction : </label>
            <input type="text" name="fonction" id="fonction" value="${fonction}"/>
        </p>
        <div class="form-group">
            <label for="adresse">adresse : </label>
            <input type="text" name="adresse" id="adresse" size="30" value="${adresse}" />
        </div>
        <div class="form-group">
            <label for="ville">ville : </label>
            <input type="text" name="ville" id="ville"  value='${ville}' />
        </div>
        <div class="form-group">
            <label for="region">region : </label>
            <input type="text" name="region" id="region"  value='${region}' />
        </div>
        <div class="form-group">
            <label for="codepostal">code Postal : </label>
            <input type="text" name="codepostal" id="codepostal"  value='${codepostal}'/>
        </div>
        <div class="form-group">
            <label for="pays">pays : </label>
            <input type="text" name="pays" id="pays" value='${pays}' />
        </div>
        <p>
            <label for="telephone">telephone : </label>
            <input type="text" name="telephone" id="telephone" value='${telephone}' />
            </div>
        <div class="form-group">
            <label for="fax">fax : </label>
            <input type="text" name="fax" id="fax"  value='${fax}' />
        </div>

        <input class="btn btn-primary" type="submit" />
    </form>


</body>
</html>
