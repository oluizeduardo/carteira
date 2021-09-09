<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Todas as transações</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	</head>
<body class="container">
	
	<h1 class="text-center">Cadastro de Transações</h1>

	<form action="<c:url value="/transacoes"/>" method="POST" class="g3">
		
		<div class="form-group">
			<label for="ticker" class="form-label">Ticker</label>
			<input type="text" id="ticker" class="form-control" name="ticker" required>
		</div>
		
		<div class="form-group">
			<label for="data" class="form-label">Data</label>
			<input type="date" id="data" class="form-control" name="data" required>
		</div>
		
		<div class="form-group">
			<label for="preco" class="form-label">Preço</label>
			<input type="text" id="preco" class="form-control" name="preco" required>
		</div>
		
		<div class="form-group">
			<label for="quantidade" class="form-label">Quantidade</label>
			<input  type="text" id="quantidade" class="form-control" name="quantidade" required>
		</div>
		
		<div class="form-group">
		    <label for="tipo" class="form-label">Tipo</label>
		    <select class="form-select" id="tipo" name="tipo" required>
		      <option selected disabled value="">SELECIONE</option>
		      <option>COMPRA</option>
		      <option>VENDA</option>
		    </select>
		  </div>
		<p/>
		<div>
			<button class="btn btn-primary" type="submit">Gravar</button>
		</div>
	</form>

	<hr style="margin: 40px"/>

	<h1 class="text-center">Lista de Transações</h1>
	<p>
	<table class="table table-hover table-striped">
		<thead class="table-dark">
			<tr>
				<th scope="col" class="text-center">TICKER</th>
				<th scope="col" class="text-center">DATA</th>
				<th scope="col" class="text-center">PREÇO</th>
				<th scope="col" class="text-center">QUANTIDADE</th>
				<th scope="col" class="text-center">TIPO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${transacoes}" var="t">
				<tr>
					<td class="text-center">${t.ticker}</td>
					<td class="text-center">${t.data}</td>
					<td class="text-center">${t.preco}</td>
					<td class="text-center">${t.quantidade}</td>
					<td class="text-center">${t.tipo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>