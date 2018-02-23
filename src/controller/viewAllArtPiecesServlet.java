package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GalleryArtPiece;

/**
 * Servlet implementation class viewAllArtPieces
 */
@WebServlet("/viewAllArtPiecesServlet")
public class viewAllArtPiecesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllArtPiecesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GalleryArtHelper gah = new GalleryArtHelper();
		request.setAttribute("allArt", gah.showAllItems());
		if(gah.showAllItems().isEmpty()) {
			request.setAttribute("allArt", " ");
		}
		//test
		for(GalleryArtPiece l: gah.showAllItems()) {
			System.out.println(l.toString());
		}
			getServletContext().getRequestDispatcher("/artwork-list.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
