<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
                    'title': 'Chiffre d\'affaire par pays', //title
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
        
        <h1>Chiffre d'affaire pays</h1>

        <form method='GET'>            
            Saisie le : <input name="Saisie_le" type="date" max="1999-12-31" min="1994-01-01"><br/>
            Envoyee le : <input name="Envoyee_le" type="date" max="1999-12-31" min="1994-01-01"><br/>           
            <input type="submit" value="Chercher">
        </form>
        <div><h4>${message}</h4></div>     
        <div style="width: 600px;">
            <div id="chart_div"></div>
        </div>
    </body>
</html>