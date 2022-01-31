<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Contatto</title>
</head>
<body>
<h1> INSERIRE UN CONTATTO DA MODIFICARE</h1>
	<form method="post" action="controller"> 
		ID&ensp; <input type="text" name="id" required="required"><br><br>
		Nome&ensp; <input type="text" name="nome" required="required"><br><br>
		Cognome&ensp; <input type="text" name="cognome" required="required"><br><br>
		Email&ensp; <input type="email" name="email" required="required"><br><br>
		
		<h2> NUMERI DI TELEFONO (Inserire almeno un numero)</h2><br>
		1°Numero telefonico&ensp;<input type="text" name="numero1" required="required" maxlength="10"><br><br>
		2°Numero telefonico&ensp;<input type="text" name="numero2" maxlength="10"><br><br>
		<input type="hidden" name="operazione" value="merge">
		<input type="submit" value="invia"><br><br><br>
		<h4><a href="index.html">Torna alla Home</a></h4>
	</form>
</body>
</html>