package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottoDAO;
import model.ProductModelDS;

public class ProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ProdottoDAO model = new ProductModelDS();
	
    public ProdottoControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		try {
			if(action != null) {
				if (action.equalsIgnoreCase("read")) {
						String id = request.getParameter("id");
						request.setAttribute("product", model.doRetrieveByKey(id));
				}
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Prodotto.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
