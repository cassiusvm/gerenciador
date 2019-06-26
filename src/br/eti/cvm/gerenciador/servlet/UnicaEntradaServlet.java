package br.eti.cvm.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.eti.cvm.gerenciador.acao.AcaoExecutavel;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");

		AcaoExecutavel acao = null;

		try {
			String nomeDaClasse = "br.eti.cvm.gerenciador.acao." + paramAcao;
			Class<?> classe = Class.forName(nomeDaClasse);
			Constructor<?> construtor = classe.getConstructor();
			acao = (AcaoExecutavel) construtor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			throw new ServletException(e);
		}

		String retornoAcao = acao.executa(request, response);

		String[] split = retornoAcao.split(":");
		String forwardRedirect = split[0];
		String destino = split[1];

		if (forwardRedirect.equals("forward")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + destino);
			requestDispatcher.forward(request, response);
		} else if (forwardRedirect.equals("redirect")) {
			response.sendRedirect(destino);
		}
	}

}
