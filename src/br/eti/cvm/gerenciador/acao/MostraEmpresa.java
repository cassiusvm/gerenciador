package br.eti.cvm.gerenciador.acao;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.eti.cvm.gerenciador.modelo.BancoDados;
import br.eti.cvm.gerenciador.modelo.Empresa;

public class MostraEmpresa  implements AcaoExecutavel {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		BancoDados bancoDados = new BancoDados();
		
		Empresa empresa = bancoDados.buscaEmpresaPorId(id);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataAbertura = empresa.getDataAbertura().format(formatter);
		
		request.setAttribute("nome", empresa.getNome());
		request.setAttribute("id", paramId);
		request.setAttribute("dataAbertura", dataAbertura);
		
		return "forward:formAlteraEmpresa.jsp";
	}

}
