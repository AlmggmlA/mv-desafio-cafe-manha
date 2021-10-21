<%@page import="model.Item_cafeManha"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="frmCadastroCafe" action="cadastrarItemController" method="get">
		<h3> Bem-vindo(a)!</h3> <br/>
		
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
	
	
	
</body>
</html>