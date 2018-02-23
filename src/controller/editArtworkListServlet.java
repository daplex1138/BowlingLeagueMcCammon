package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GalleryArtPiece;

/**
 * Servlet implementation class editArtworkListServlet
 */
@WebServlet("/editArtworkListServlet")
public class editArtworkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editArtworkListServlet() {
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
		
		GalleryArtHelper gah = new GalleryArtHelper();
		String act = request.getParameter("doThisToItem");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllArtPiecesServlet").forward(request, response);
			}
		else if (act.equals("Delete Selected Item")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			GalleryArtPiece artToDelete = gah.searchForItemById(tempId);
			gah.deleteItem(artToDelete);
			
			getServletContext().getRequestDispatcher("/viewAllArtPiecesServlet").forward(request, response);
			}
		else if (act.equals("Edit Selected Item")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			GalleryArtPiece galleryArtPieceToEdit = gah.searchForItemById(tempId);
			request.setAttribute("galleryArtPieceToEdit", galleryArtPieceToEdit);
			getServletContext().getRequestDispatcher("/edit-artpiece.jsp").forward(request, response);
		}
		else if (act.equals("Add New Item")) {
			getServletContext().getRequestDispatcher("/addArtPiece.html").forward(request, response);
		}
	}

}
