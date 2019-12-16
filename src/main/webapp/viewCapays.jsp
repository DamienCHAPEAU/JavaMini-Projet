<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Chiffre d'affaire pays</title>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript">
            // Load the Visualization API and the piechart package.
            google.load('visualization', '1.0', {
                'packages': ['corechart']
            });
            // Set a callback to run when the Google Visualization API is loaded.
            google.setOnLoadCallback(drawChart);
            // Callback that creates and populates a data table,
            // instantiates the pie chart, passes in the data and
            // draws it.
            function drawChart() {
                // Create the data table.                
                var data = google.visualization.arrayToDataTable([
                    ['Client', 'CA'],
            <c:forEach items="${code}" var="code">
                    [ '${code.client}', ${code.CA} ],
            </c:forEach>
                ]);
                // Set chart options
                var options = {
                    'title': 'Chiffre d\'affaire par pays (en euro)', //title
                    is3D: true, //render Google Pie Chart as 3D
                    pieSliceText: 'label', //Affiche le label du pays quand on passe la souris
                    tooltip: {showColorCode: true}, // Affiche la couleur sur le label
                    'width': 900, //width of the Google Pie Chart
                    'height': 500 //height of the Google Pie Chart
                };
                // Instantiate and draw our chart, passing in some options.
                var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
                chart.draw(data, options);
            }
        </script>
    </head>
    <body>
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
                    <a class="nav-link" href="CAcategorie">Chiffre d'affaires catégorie</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="CAclient">Chiffre d'affaires client</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="CApays">Chiffre d'affaires pays</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="deconnexion.jsp"><input class="btn btn-outline-secondary btn-sm" type="button" value="disconnect" name="disconnect" /></a>
                </li>
            </ul>
        </div>            
    </nav>
    <br>
    <h1>Chiffre d'affaire pays</h1>
    <br>
    <form method='GET'>
        <div class="form-group">
            <label>Saisie le : </label>
            <input name="Saisie_le" type="date" max="1999-12-31" min="1994-01-01"><br/>
        </div>
        <div class="form-group">
            <label> Envoyee le : </label>
            <input name="Envoyee_le" type="date" max="1999-12-31" min="1994-01-01"><br/>           
        </div>
        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="Chercher">
        </div>
    </form>
    <div><h4>${message}</h4></div>     
    <div style="width: 600px;">
        <div id="chart_div"></div>
    </div>
</body>
</html>