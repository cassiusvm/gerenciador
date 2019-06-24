package br.eti.cvm.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BancoDados bancoDados = new BancoDados();
		
		List<Empresa> listaEmpresas = bancoDados.getEmpresas();
		
		request.setAttribute("listaEmpresas", listaEmpresas);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaEmpresas.jsp");
		requestDispatcher.forward(request, response);
	}

}
