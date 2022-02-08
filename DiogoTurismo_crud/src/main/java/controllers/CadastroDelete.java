package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CadastroDao;



@WebServlet("/CadastroDelete")
public class CadastroDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CadastroDelete() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cadastroId_cliente = Integer.parseInt(request.getParameter("cadastroId"));
		CadastroDao.delete(cadastroId_cliente);
		
		CadastroCreateAndFind cadastroCreateAndFind = new CadastroCreateAndFind();
		
		cadastroCreateAndFind.doGet(request, response);



}
}