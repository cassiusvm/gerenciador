package br.eti.cvm.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.eti.cvm.gerenciador.modelo.BancoDados;

public class RemoveEmpresa  implements AcaoExecutavel {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		BancoDados bancoDados = new BancoDados();
		bancoDados.remove(id);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
	
}
