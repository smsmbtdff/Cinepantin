package fr.cinepantin.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cinepantin.DAO.LivreDAO;
import fr.cinepantin.modele.Article;


/**
 * Servlet implementation class DvdControl
 */
@WebServlet ("/LivreControl")
public class LivreControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private LivreDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LivreControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sse = request.getSession();
		//ServletContext svt = sse.getServletContext();
		Article prop = (Article) sse.getAttribute("proprietaire");
				
		if ((request.getParameter("action") == null)) {
			List<Article> liste =  dao.findByNom(prop);
			request.setAttribute("articles", liste);
			RequestDispatcher rd = request
					.getRequestDispatcher("/accueil.jsp");
			rd.forward(request, response);
			return;
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
