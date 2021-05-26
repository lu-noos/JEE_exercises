package fr.lucien.laurain.tirage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class traitementTirage
 */
@WebServlet(

		urlPatterns = "/tps/tp_tirage/traitementTirage", initParams = { @WebInitParam(name = "borneInf", value = "0"),
				@WebInitParam(name = "borneSup", value = "10") })
public class traitementTirage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int nbEssai;
	int tirage;
	int essai;
	int borneInf;
	int borneSup;

	public void init() {
    	borneInf = Integer.parseInt(this.getInitParameter("borneInf"));
    	borneSup = Integer.parseInt(this.getInitParameter("borneSup"));
		tirage = (int) ((int) borneInf + ((Math.random() * (borneSup - borneInf))));
		nbEssai = 0;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("nbEssai") != null) {
			nbEssai++;
			essai = Integer.parseInt(request.getParameter("nbEssai"));
			if (essai == tirage) {
				response.sendRedirect("http://localhost:8080/TP_javaEE/tps/tp_tirage/victoire.html");
			} else {
				response.sendRedirect("http://localhost:8080/TP_javaEE/tps/tp_tirage/echec.html");
			}
		} else if (request.getParameter("borneInf") !=null) {
			borneInf = Integer.parseInt(request.getParameter("borneInf"));
			borneSup = Integer.parseInt(request.getParameter("borneSup"));
			tirage = (int) ((int) borneInf + ((Math.random() * (borneSup - borneInf))));
			nbEssai = 0;
			response.sendRedirect("http://localhost:8080/TP_javaEE/tps/tp_tirage/tp1.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
