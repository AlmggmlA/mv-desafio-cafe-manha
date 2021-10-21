<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Voltar para <a href="inicial.html">HOME</a>


<form name="frmCadastroUsuario" action="cadastrarUsuarioController" method="get">
	<h3> CADASTRO DE USUÁRIO</h3> <br/>
	
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
			<input type="submit" value="Cadastrar" class="Botao_cafe">
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