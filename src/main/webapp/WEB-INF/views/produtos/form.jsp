<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais -
	Casa do C�digo</title>
</head>
<body>
	<form action="/casadocodigo/produtos" method="POST">
		<div>
			<label>Titulo</label>
			 <input type="text" name="titulo">
		</div>
		<div>
			<label>Descri�ao</label>
			 <textarea name="descricao" rows="10" cols="10"></textarea>
		</div>
		<div>
			<label>P�ginas</label>
			 <input type="number" name="paginas">
		</div>
		
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
	        <div>
	            <label>${tipoPreco}</label>
	            <input type="text" name="precos[${status.index}].valor" />
	            <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}" />
	        </div>
	    </c:forEach>
    
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>