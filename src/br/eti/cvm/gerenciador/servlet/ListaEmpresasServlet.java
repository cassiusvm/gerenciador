package br.eti.cvm.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BancoDados bancoDados = new BancoDados();
		
		List<Empresa> lista = bancoDados.getEmpresas();
		
		PrintWriter saidaHtml = response.getWriter();
		
		saidaHtml.println("<html>");
		saidaHtml.println("<body>");
		saidaHtml.println("Empresas</br></br>");
		saidaHtml.println("<ul>");
		lista.forEach(empresa -> saidaHtml.println("<li>" + empresa.getNome() + "</li>"));
		saidaHtml.println("</ul>");
		saidaHtml.println("</body>");
		saidaHtml.println("</html>");
	}

}
