package br.eti.cvm.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.eti.cvm.gerenciador.modelo.BancoDados;
import br.eti.cvm.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accept = request.getHeader("Accept");
		
		List<Empresa> empresas = new BancoDados().getEmpresas();
		
		String saida = null;
		String contentType = null;
		
		if(accept.endsWith("json")) {
			Gson gson = new Gson();
			saida = gson.toJson(empresas);
			contentType="application/json";
			
		} else if(accept.endsWith("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			saida = xstream.toXML(empresas);
			contentType="application/xml";
		}

		if(accept.endsWith("json") || accept.endsWith("xml")) {
			response.setContentType(contentType);
			response.getWriter().print(saida);
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");
		}
	}

}
