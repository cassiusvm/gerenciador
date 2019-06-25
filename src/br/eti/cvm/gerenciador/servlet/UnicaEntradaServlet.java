package br.eti.cvm.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.eti.cvm.gerenciador.acoes.AcaoExecutavel;
import br.eti.cvm.gerenciador.acoes.AlteraEmpresa;
import br.eti.cvm.gerenciador.acoes.ListaEmpresas;
import br.eti.cvm.gerenciador.acoes.MostraEmpresa;
import br.eti.cvm.gerenciador.acoes.NovaEmpresa;
import br.eti.cvm.gerenciador.acoes.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		AcaoExecutavel acao=null;
		
		if(paramAcao.equals("ListaEmpresas")) {
			
			acao = new ListaEmpresas();
			acao.executa(request, response);
			
		} else if(paramAcao.equals("NovaEmpresa")) {
			
			acao = new NovaEmpresa();
			acao.executa(request, response);
			
		} else if(paramAcao.equals("RemoveEmpresa")) {
			
			acao = new RemoveEmpresa();
			acao.executa(request, response);
			
		} else if(paramAcao.equals("MostraEmpresa")) {
			
			acao = new MostraEmpresa();
			
			acao.executa(request, response);
		} else if(paramAcao.equals("AlteraEmpresa")) {
			
			acao = new AlteraEmpresa();
			acao.executa(request, response);
		}
	}

}
