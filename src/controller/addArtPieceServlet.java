package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GalleryArtPiece;

/**
 * Servlet implementation class addArtPieceServlet
 */
@WebServlet("/addArtPieceServlet")
public class addArtPieceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addArtPieceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("Title");
		String artistName = request.getParameter("Artist Name");//use what is in the .html format "Artist Name"
		String media = request.getParameter("Media");
		String year = request.getParameter("Year");
		double value = Double.parseDouble(request.getParameter("Value"));
		
		GalleryArtPiece piece = new GalleryArtPiece(title, artistName, media, year, value);
		GalleryArtHelper gah = new GalleryArtHelper();
		gah.insertItem(piece);
		
		getServletContext().getRequestDispatcher("/addArtPiece.html").forward(request, response);
		
	}

}
