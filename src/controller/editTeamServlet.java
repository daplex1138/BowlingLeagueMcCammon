package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;

/**
 * Servlet implementation class editTeamServlet
 */
@WebServlet("/editTeamServlet")
public class editTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editTeamServlet() {
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
	TeamHelper dao = new TeamHelper();
		
		String act = request.getParameter("doThisToItem");
		String radioSelection = request.getParameter("id");
		if(act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
		}else if(act.equals("Delete Selected Team")){
			if(radioSelection == null) {
			System.out.println("empty");
			getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
			}else{
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Team itemToDelete = dao.searchForTeamById(tempId);
					dao.deleteItem(itemToDelete);
			getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
			}
		}else if(act.equals("Edit Selected Team")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Team itemToEdit = dao.searchForTeamById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			getServletContext().getRequestDispatcher("/edit-artwork.jsp").forward(request, response);
		}else if(act.equals("Add New Team")) {
			getServletContext().getRequestDispatcher("/addTeam.html").forward(request, response);
		}
	}

}
