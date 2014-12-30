<%@page import="curso.k19.tabela1.Editora"%>
<%@page import="curso.k19.tabela1.Autor"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Dados</title>
</head>
<body>
	<table width="100%" border="1">
		<tr bgcolor="#c0c0c0">
			<td>Id</td>
			<td>Nome</td>
		</tr>
	<%
		EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("sistema");
	
		EntityManager em = factory.createEntityManager();
		
		Query query = em.createQuery("select object(e) from Autor as e");
		List<Autor> autores = query.getResultList();
		
		for(Autor a : autores){
	%>
		<tr>
			<td><%=a.getId() %></td>
			<td><%=a.getNome() %></td>
		</tr>
	<%
		}
	%>
	</table>
	<br />
	<br />
	<table width="100%" border="1">
		<tr bgcolor="#c0c0c0">
			<td>Id</td>
			<td>Editora</td>
			<td>E-mail</td>
		</tr>
	<%
		//EntityManagerFactory factory = 
			//Persistence.createEntityManagerFactory("sistema");
	
		//EntityManager em = factory.createEntityManager();
		
		Query queryEd = em.createQuery("select object(e) from Editora as e");
		List<Editora> editoras = queryEd.getResultList();
		
		for(Editora ed : editoras){
	%>
		<tr>
			<td><%=ed.getId() %></td>
			<td><%=ed.getNome() %></td>
			<td><%=ed.getEmail() %></td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>