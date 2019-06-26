package br.eti.cvm.gerenciador.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BancoDados {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	
	private static Integer chaveSequencial=1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Apache Software Foundation");
		empresa.setDataAbertura(LocalDate.parse("1999-06-01"));
		lista.add(empresa);
		
		empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Twitter");
		empresa.setDataAbertura(LocalDate.parse("2006-07-15"));
		lista.add(empresa);
		
		Usuario usuario = new Usuario();
		usuario.setLogin("cassius");
		usuario.setSenha("12345");
		listaUsuarios.add(usuario);
		
		
		usuario = new Usuario();
		usuario.setLogin("danielli");
		usuario.setSenha("12345");
		listaUsuarios.add(usuario);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return BancoDados.lista;
	}
	
	public void remove(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa empresa = it.next();
			if(empresa.getId().equals(id)) {
				it.remove();
				break;
			}
		}
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for(Empresa empresa : lista) {
			if(empresa.getId().equals(id))
				return empresa;
		}
		
		return null;
	}

	public boolean existeUsuario(Usuario usuario) {
		return listaUsuarios.contains(usuario);
	}
	
}
