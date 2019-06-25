package br.eti.cvm.gerenciador.acoes;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.eti.cvm.gerenciador.modelo.BancoDados;
import br.eti.cvm.gerenciador.modelo.Empresa;

public class NovaEmpresa  implements AcaoExecutavel {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		empresa.setDataAbertura(LocalDate.parse(dataAbertura, formatter));
		
		BancoDados bancoDados = new BancoDados();
		bancoDados.adiciona(empresa);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}

}
