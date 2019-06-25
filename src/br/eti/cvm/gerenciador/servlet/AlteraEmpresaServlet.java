package br.eti.cvm.gerenciador.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.eti.cvm.gerenciador.modelo.BancoDados;
import br.eti.cvm.gerenciador.modelo.Empresa;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramNnomeEmpresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("dataAbertura");
		String paramId = request.getParameter("id");
		
		BancoDados bancoDados = new BancoDados();
		Empresa empresa = bancoDados.buscaEmpresaPorId(Integer.valueOf(paramId));
		
		empresa.setNome(paramNnomeEmpresa);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		empresa.setDataAbertura(LocalDate.parse(paramDataAbertura, formatter));
		
		response.sendRedirect("listaEmpresas");
		
	}

}
