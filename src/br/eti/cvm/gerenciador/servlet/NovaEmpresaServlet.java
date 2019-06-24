package br.eti.cvm.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		
		PrintWriter saidaHtml = response.getWriter();
		
		saidaHtml.println("<html>");
		saidaHtml.println("<body>");
		saidaHtml.println("<h1>Empresa " + nomeEmpresa + " cadastrada com sucesso !</h1>");
		saidaHtml.println("</body>");
		saidaHtml.println("</html>");
	}

}
