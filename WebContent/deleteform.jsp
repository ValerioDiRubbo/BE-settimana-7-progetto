<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancella Contatto</title>
</head>
<body>
<h1> INSERISCI L'ID DEL CONTATTO DA CANCELLARE</h1>
	<form method="post" action="controller"> 
		ID <input type="number" name="id"><br><br>
		<input type="hidden" name="operazione" value="delete">
		<input type="submit" value="inserisci">
		
		<h5><a href="viewcontatti">Ricontrolla i contatti presenti in rubrica</a></h5>
	<h5><a href='index.html'>Torna alla Home</a></h5>
	</form>
</body>
</html>