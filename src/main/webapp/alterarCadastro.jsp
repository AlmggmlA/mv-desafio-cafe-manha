<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Cadastro</title>
</head>
<body>
<form name="frmAlterarCadastroUsuario" action="alterarUsuarioController" method="get">
	<h3> DADOS DO USUÁRIO</h3> <br/>
	<input type="hidden" name="id" value="">
	<table>
		<tr>		
			<td>CPF:</td>
			<td><input type="text" name="cpf"></td>			
		</tr>
		
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="nome"></td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td><input type="password" name="senha"></td>
		</tr>
				
		<td>
			<input type="submit" value="Alterar" class="Botao_cafe" name="alterar">
		</td>
	</table>	

</form>
	
	<%
		String mensagem = (String) request.getAttribute("mensagem");
		if(mensagem!=null){
		out.print(mensagem);}
	%>
</body>
</html>