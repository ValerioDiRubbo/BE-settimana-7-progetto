<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca per cognome</title>
</head>
<body>
<h1> RICERCA PER COGNOME</h1>
<h3> Inserire il cognome (o parte di esso) per avviare la ricerca</h3>
	<form method="post" action="controller"> 
		<h2>Cognome:<input type="text" name="cognomedacercare"><br></h2>
		
		<input type="hidden" name="operazione" value="ricercapercognome">
		<input type="submit" value="Ricerca">
	
	</form>
	<h5><a href="index.html">Torna alla Home</a></h5>
</body>
</html>