package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;
import model.Team;

/**
 * Servlet implementation class insertPlayerServlet
 */
@WebServlet("/insertPlayerServlet")
public class insertPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertPlayerServlet() {
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String screenName = request.getParameter("screenName");
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		
		Team team = new Team();
		TeamHelper teamDao = new TeamHelper();
		team = teamDao.searchForTeamById(teamId);
		
		Player player = new Player(firstName, lastName, phoneNumber, screenName, team);
		PlayerHelper playerDao = new PlayerHelper();
		playerDao.insertItem(player);
		
		getServletContext().getRequestDispatcher("/insertPlayer.jsp").forward(request, response);
	}

}
