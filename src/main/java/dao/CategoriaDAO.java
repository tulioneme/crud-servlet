package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;

public class CategoriaDAO {

  public String inserir(Categoria categoria) {
    String retorno = "Falha";
    Conexao conn = new Conexao();

    try {
      Statement stmt = (Statement) conn.getConn().createStatement();
      stmt.execute("INSERT INTO categoria (nome) VALUES ('" + categoria.getNome() + "')");
      retorno = "Sucesso";

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      conn.fecharConexao();
    }
    return retorno;
  }

  public List<Categoria> Listar() {
    List<Categoria> categorias = new ArrayList<Categoria>();
    Conexao conn = new Conexao();
    try {
      Statement stmt = (Statement) conn.getConn().createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * from categoria");
      while (rs.next()) {
        Categoria categoria = new Categoria();
        categoria.setCodigo(rs.getInt("codigo"));
        categoria.setNome(rs.getString("nome"));
        categorias.add(categoria);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      conn.fecharConexao();
    }

    return categorias;
  }
}