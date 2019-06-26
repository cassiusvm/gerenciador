package br.eti.cvm.gerenciador.servlet;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String acao = request.getParameter("acao");
		
		Instant inicio = Instant.now();

		chain.doFilter(request, response);
		
		Duration tempoDeExecucao = Duration.between(inicio, Instant.now());
		
		System.out.println("Tempo de execucao da ação '" + acao + "': " + tempoDeExecucao.toMillis() + " milisegundos");
	}

}
