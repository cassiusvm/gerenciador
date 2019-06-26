package br.eti.cvm.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.eti.cvm.gerenciador.modelo.BancoDados;

public class NovaEmpresaForm  implements AcaoExecutavel {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "forward:formNovaEmpresa.jsp";
	}
	
}
