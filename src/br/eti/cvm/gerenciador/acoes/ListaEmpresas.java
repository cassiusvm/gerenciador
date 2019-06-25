package br.eti.cvm.gerenciador.acoes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.eti.cvm.gerenciador.modelo.BancoDados;
import br.eti.cvm.gerenciador.modelo.Empresa;

public class ListaEmpresas  implements AcaoExecutavel {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BancoDados bancoDados = new BancoDados();
		
		List<Empresa> listaEmpresas = bancoDados.getEmpresas();
		
		request.setAttribute("listaEmpresas", listaEmpresas);
		
		return "forward:listaEmpresas.jsp";
	}
}