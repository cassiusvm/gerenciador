package br.eti.cvm.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter saidaHtml = resp.getWriter();
		
		saidaHtml.println("<html>");
		saidaHtml.println("<body>");
		saidaHtml.println("<h1>Oi Mundo, parab&eacute;ns voc&ecirc; escreveu o primeiro servlet.</h1>");
		saidaHtml.println("</body>");
		saidaHtml.println("</html>");
	}

}
