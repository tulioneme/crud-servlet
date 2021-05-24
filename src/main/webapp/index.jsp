<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="ISO-8859-1">
  <title>Inserir Categoria</title>
</head>

<body>
  <center>
    <h1>Categorias de Despesas</h1>
    <h2>
      <a href="inserirCategoria.jsp">Inserir Nova Categoria</a>
      &nbsp;&nbsp;&nbsp;
    </h2>
  </center>
  <div align="center">
    <table border="1" cellpadding="5">
      <caption>
        <h2>Lista de Categorias</h2>
      </caption>
      <tr>
        <th>Codigo</th>
        <th>Nome</th>
        <th>Acoes</th>
      </tr>

      <c:forEach var="categoria" items="${listaCategoria}">
        <tr>
          <td>
            <c:out value="${categoria.codigo}" />
            <c:out value="${categoria.nome}" />
          </td>

          <td>
            <a href="edit?id=<c:out value='${categoria.codigo}' />">Alterar</a>
            &nbsp;&nbsp;&nbsp;
            <a href="delete?id=<c:out value='${categoria.codigo}' />">Deletar</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>

</html>