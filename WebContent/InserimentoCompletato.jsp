<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title> Inserimento Completato </title>
	</head>
	<body>
		<form action="continuaInserimento" method="get">
			<h1> Inserimento Completato! </h1>
			<h2> Specifiche del Prodotto:</h2>
			<p> Nome: ${prodotto.nome}</p>
			<p> Descrizione: ${prodotto.descrizione}</p>
			<p> Prezzo: ${prodotto.prezzo}</p>
			<p><input type="submit" name="sumbit" value="continua inserimento" /></p>
		</form>
	</body>
</html>