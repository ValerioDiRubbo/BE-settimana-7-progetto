<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca per numero telefonico</title>
</head>
<body>
<h1> RICERCA PER NUMERO</h1>
<h3> Inserire il numero (o parte di esso) per avviare la ricerca</h3>
	<form method="post" action="controller"> 
		<h2>Numero:<input type="text" name="numerodacercare"><br></h2>
		
		<input type="hidden" name="operazione" value="ricercapernumero">
		<input type="submit" value="Ricerca">
	<h5><a href='index.html'>Torna alla Home</a></h5>
	</form>
</body>
</html>