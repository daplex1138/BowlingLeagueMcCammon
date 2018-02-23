package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GalleryArtPiece;

/**
 * Servlet implementation class editArtPiece
 */
@WebServlet("/editArtPieceServlet")
public class editArtPieceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editArtPieceServlet() {
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
		//doGet(request, response);
		
		GalleryArtHelper gah = new GalleryArtHelper();
		String title = request.getParameter("title");
		String artistName = request.getParameter("artist_name");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		double value = Double.parseDouble(request.getParameter("value"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		GalleryArtPiece galleryArtPiecetoUpdate = gah.searchForItemById(tempId);
		galleryArtPiecetoUpdate.setTitle(title);
		galleryArtPiecetoUpdate.setArtistName(artistName);
		galleryArtPiecetoUpdate.setMedia(media);
		galleryArtPiecetoUpdate.setYear(year);
		galleryArtPiecetoUpdate.setValue(value);
		gah.updateItem(galleryArtPiecetoUpdate);
		getServletContext().getRequestDispatcher("/viewAllArtPiecesServlet").forward(request, response);
		
	}

}
