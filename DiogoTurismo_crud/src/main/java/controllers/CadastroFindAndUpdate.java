package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CadastroDao;
import model.Cadastro;


@WebServlet("/CadastroFindAndUpdate")
public class CadastroFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CadastroFindAndUpdate() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cadastroId_cliente = Integer.parseInt(request.getParameter("cadastroId"));
		Cadastro cadastro = CadastroDao.findByPk(cadastroId_cliente);
		
		request.setAttribute("cadastro", cadastro);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("update.jsp");
		resquesDispatcher.forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cadastro cadastro = new Cadastro();
		cadastro.setId_cliente(Integer.parseInt(request.getParameter("id")));
		
		cadastro.setNome(request.getParameter("nome"));
		cadastro.setCpf(request.getParameter("cpf"));
		cadastro.setEmail(request.getParameter("email"));
		cadastro.setTelefone(request.getParameter("telefone"));
		
		CadastroDao.update(cadastro);
		
         CadastroCreateAndFind cadastroCreateAndFind = new CadastroCreateAndFind();
		
		cadastroCreateAndFind.doGet(request, response);
		
	
	}

}
