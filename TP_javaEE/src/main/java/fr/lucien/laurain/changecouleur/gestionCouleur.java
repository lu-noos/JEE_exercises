package fr.lucien.laurain.changecouleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GestionCouleur
 */
@WebServlet("/tps/tp_changecouleur/gestionCouleur")
public class gestionCouleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int compteurAcces = 0;
	private String couleurTexte = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestionCouleur() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cookie[] cookies= request.getCookies();
		
		//session
		if (session.getAttribute("compteurAcces") !=null) {
			compteurAcces = (int) session.getAttribute("compteurAcces");
		}
		compteurAcces ++;
		session.setAttribute("compteurAcces", compteurAcces);
		
			
		if (request.getParameter("couleurTexte") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/tp_changecouleur/affichageCouleur.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/tp_changecouleur/accueilCouleur.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//cookies
		Cookie cookieCouleur = null;
		if (request.getParameter("couleurTexte") != null) {
			cookieCouleur = new Cookie("couleurTexte", request.getParameter("couleurTexte"));
			cookieCouleur.setMaxAge(300);
			response.addCookie(cookieCouleur);
		}
		doGet(request, response);
	}
}
