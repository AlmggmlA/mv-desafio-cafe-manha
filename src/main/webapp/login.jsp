<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de Login</title>
</head>
<body>
	Voltar para <a href="./index.html">HOME</a>
		
	<form method="post" action="loginController"><br/>
		<label>CPF:</label><br/>
		<input type="text" name="cpf"/><br/>
		<label>Senha:</label><br/>
		<input type="password" name="senha"/> <br/>
		
		<input type="submit" value="Logar"/>
	
	Se não tem cadastro, então <a href="./cadastroUsuario.jsp">CADASTRE-SE</a>
	</form>
	
	<%
		String mensagem = (String) request.getAttribute("mensagem");
		if(mensagem!=null){
		out.print(mensagem);}
	%>
	
	<%
		String usuario = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		if(usuario!=null && senha!=null && !usuario.isEmpty() && !senha.isEmpty()){
			session.setAttribute("usuario", usuario);
			response.sendRedirect("./telaUsuario.jsp");
		}
	%>
	
</body>
</html>