package br.eti.cvm.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.eti.cvm.gerenciador.modelo.BancoDados;
import br.eti.cvm.gerenciador.modelo.Usuario;

public class Login  implements AcaoExecutavel {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramLogin = request.getParameter("login");
		String paramSenha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(paramLogin);
		usuario.setSenha(paramSenha);
		
		BancoDados bancoDados = new BancoDados();
		boolean existe = bancoDados.existeUsuario(usuario);
		
		if(existe) {
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}
		
	}

}
