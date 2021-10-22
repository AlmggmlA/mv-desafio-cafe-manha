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
		
		<%
			String usuario = (String) session.getAttribute("usuario");
			out.print("<h3> Bem-vindo, "+usuario+"</h3></br>");
		%>
		
		<a href="./deslogar.jsp">deslogar</a><br/>
		<a href="./alterarCadastro.jsp">alterar cadastro do usuário</a><br/>
		<br/><br/>
		
		Informe o que irá levar para o café da manhã!
			<table>		
				<tr>					
					<td><input type="text" name="nomeItem"></td>
					<td><input type="submit" value="Adicionar" class="Botao_cafe"></td>
				</tr>
			
			</table>	
																													
	</form>
		
	<%
		String mensagem = (String) request.getAttribute("mensagem");
		if(mensagem!=null){
		out.print(mensagem);}
	%>
	
	<form name="frmConsultarItem" action="consultarItemController" method="post">
		<table>	
		<tr><br/></tr><tr><br/></tr>	
				<tr>					
					<td><input type="hidden" name="nomeItemConuslta"></td>
				</tr>
				
				<td>
					<input type="submit" value="Itens cadastrados" class="Botao_cafe">
				</td>
			</table>
			
	</form>
	
	<table>
	<tr>
	<%
		if(request.getAttribute("itens")!=null){
			List<?> itens = (List<?>) request.getAttribute("itens");
			
			for(int contador = 0; contador<=(itens.size()-1);contador++){
				Item_cafeManha item = (Item_cafeManha) itens.get(contador);
								
				out.println(item.getNomeItem() + "\n");
				
			}
		}
	%>
	</tr>
	</table>
	
	
	
	
</body>
</html>