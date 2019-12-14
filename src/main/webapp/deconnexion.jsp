<%-- 
    Document   : deconnexion
    Created on : 14 déc. 2019, 18:26:42
    Author     : Clément
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    
    
     <%@ page session="false" %>

 <body>
     <%
     // for checking the session is available or not, if not available it will throw exception, "Session already invalidated."
      if (request.getSession()!=null) {
          
        request.getSession().invalidate();
        response.sendRedirect("index.html");
      }
     %>
 </body>
    
    
</html>
