<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
    <c:if test="${ !empty sessionScope.LOG && !empty sessionScope.MDP }">
        <p>Vous êtes ${ sessionScope.LOG } ${ sessionScope.MDP } !</p>
    </c:if>
        
        
    <form method="post">
        <p>
            <label for="LOG">Login : </label>
            <input type="text" name="LOG" id="LOG" />
        </p>
        <p>
            <label for="MDP">Mot de passe : </label>
            <input type="password" name="MDP" id="MDP" />
        </p>
        
        <input type="submit" />
    </form>
    
</body>
</html>