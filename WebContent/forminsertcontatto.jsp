<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Contatto</title>
</head>
<body>


<h1> INSERISCI CONTATTO</h1>
	<form method="post" action="controller"> 
		Nome<input type="text" name="nome"><br>
		Cognome<input type="text" name="cognome"><br>
		Email<input type="email" name="email"><br><br>
		
		1°Numero telefonico<input type="text" name="numero1" required="required" maxlength="10"><br>
		2°Numero telefonico<input type="text" name="numero2" maxlength="10"><br>
		<input type="hidden" name="operazione" value="insert">
		<input type="submit" value="inserisci">
		
		<h5><a href="index.html">Torna alla Home</a></h5>
	
	</form>
</body>
</html>