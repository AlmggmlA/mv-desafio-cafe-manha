<%@page import jakarta.servlet.http.HttpSession%>
<%@page import="model.Item_cafeManha"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela do Usuário</title>
</head>
<body>
<form name="frmCadastroCafe" action="cadastrarItemController" method="get">
		<h3> Bem-vindo(a)!</h3> <br/>
		<a href="/src/main/webapp/login.jsp">deslogar</a><br/>
		
		Informe o que irá levar para o café da manhã!
			<table>		
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nomeItem"></td>
				</tr>
				
				<td>
					<input type="submit" value="Adicionar" class="Botao_cafe">
				</td>
			</table>	
																													
	</form>
		
	<%
		String mensagem = (String) request.getAttribute("mensagem");
		if(mensagem!=null){
		out.print(mensagem);}
	%>
	
	<form name="frmConsultarItem" action="consultarItemController" method="post">
		<table>		
				<tr>
					<td>Item:</td>
					<td><input type="hidden" name="nomeItemConuslta"></td>
				</tr>
				
				<td>
					<input type="submit" value="Itens cadastrados" class="Botao_cafe">
				</td>
			</table>
			
	</form>
	
	<%
		if(request.getAttribute("itens")!=null){
			List<?> itens = (List<?>) request.getAttribute("itens");
			
			for(int contador = 0; contador<=(itens.size()-1);contador++){
				Item_cafeManha item = (Item_cafeManha) itens.get(contador);
								
				out.println(item.getNomeItem() + "\n\n");
				
			}
		}
	%>
	
	<a href="/src/main/webapp/login.jsp">ALTERAR CADASTRO USUÁRIO</a><br/>
	
	<%
		HttpSession sessao = request.getSession(true);
		
		String cpf = (String)session.getValue("usuario");
		
		System.out.println(cpf);
	%>
	
</body>
</html>