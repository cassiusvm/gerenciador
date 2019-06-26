package br.eti.cvm.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.eti.cvm.gerenciador.modelo.BancoDados;
import br.eti.cvm.gerenciador.modelo.Empresa;

public class ListaEmpresas  implements AcaoExecutavel {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		if(sessao.getAttribute("usuarioLogado") == null)
			return "redirect:entrada?acao=LoginForm";
		
		BancoDados bancoDados = new BancoDados();
		
		List<Empresa> listaEmpresas = bancoDados.getEmpresas();
		
		request.setAttribute("listaEmpresas", listaEmpresas);
		
		return "forward:listaEmpresas.jsp";
	}
}
