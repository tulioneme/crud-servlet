package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import model.Categoria;

@WebServlet("/InserirCategoria")
public class InserirCategoria extends HttpServlet {
  private static final long serialVersionUID = 1L;

  CategoriaDAO dao = new CategoriaDAO();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nome = request.getParameter("nome");
    Categoria categoria = new Categoria();
    categoria.setNome(nome);

    String retorno = dao.inserir(categoria);

    if (retorno.equals("Sucesso")) {
      doGet(request, response);
      // response.sendRedirect("InserirCategoria");
    } else {
      PrintWriter out = response.getWriter();
      out.print("<html>");
      out.print("<h2> Não foi possivel inserir a categoria!</h2>");
      out.print("<br>");
      out.print("<a href - 'index.jsp'> Voltar </a>");
      out.print("</html>");
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      listaCategoria(request, response);
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
  }

  protected void listaCategoria(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Categoria> listaCategoria = dao.Listar();
    request.setAttribute("listaCategoria", listaCategoria);
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response);
  }

}