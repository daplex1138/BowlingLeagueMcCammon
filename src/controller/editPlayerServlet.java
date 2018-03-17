package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;

/**
 * Servlet implementation class editTeamServlet
 */
@WebServlet("/editPlayerServlet")
public class editPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PlayerHelper dao = new PlayerHelper();
		
		String act = request.getParameter("doThisToItem");
		String radioSelection = request.getParameter("id");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllPlayerServlet").forward(request, response);
		}else if(act.equals("Delete Selected Player")) {
			if (radioSelection == null) {
				System.out.println("empty");
				getServletContext().getRequestDispatcher("/viewAllPlayerServlet").forward(request, response);
			}else{
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Player itemToDelete = dao.searchForPlayerById(tempId);
			dao.deletePlayer(itemToDelete);
			getServletContext().getRequestDispatcher("/viewAllPlayerServlet").forward(request, response);
			}
		} else if (act.equals("Edit Selected Player")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Player itemToEdit = dao.searchForPlayerById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			getServletContext().getRequestDispatcher("/editPlayerServlet").forward(request, response);
		} else if (act.equals("Add New Player")) {
			getServletContext().getRequestDispatcher("/preparePlayerInsertServlet").forward(request, response);
		}
		}

}
