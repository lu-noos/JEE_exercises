package fr.lucien.laurain.chifoumi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class determinationDuGagnant
 */
@WebServlet("/tps/tp_chifoumi/determinationDuGagnant")
public class determinationDuGagnant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int nbParties;
	int nbVictoires;
	int nbDefaites;
	int coupServeur;
	int coupClient;
	String cpServeur;
	String cpClient;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public determinationDuGagnant() {
		super();
	}

	@Override
	public void init() {
		nbParties = 0;
		nbVictoires = 0;
		nbDefaites = 0;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		nbParties++;
		coupServeur = (int) (Math.random()*3);
		coupClient = Integer.parseInt(request.getParameter("btnSubmit"));
		//pierre = 0 , feuille = 1 , ciseaux = 2
		String decision;
		switch(coupClient) {
		case 0:
			cpClient="Vous jouez Pierre";
			switch(coupServeur) {
			case 0:
				cpServeur="Le serveur joue Pierre";
				decision="Egalité !";
				break;
			case 1:
				cpServeur="Le serveur joue Feuille";
				decision="Perdu !";
				nbDefaites++;
				break;
			case 2:
				cpServeur="Le serveur joue Ciseaux";
				decision="Gagné !";
				nbVictoires++;
				break;
			default:
				decision="Erreur de logique";
			}
			break;
		case 1:
			cpClient="Vous jouez Feuille";
			switch(coupServeur) {
			case 0:
				cpServeur="Le serveur joue Pierre";
				decision="Gagné !";
				nbVictoires++;
				break;
			case 1:
				cpServeur="Le serveur joue Feuille";
				decision="Egalité !";
				break;
			case 2:
				cpServeur="Le serveur joue Ciseaux";
				decision="Perdu !";
				nbDefaites++;
				break;
			default:
				decision="Erreur de logique";
			}
			break;
		case 2:
			cpClient="Vous jouez Ciseaux";
			switch(coupServeur) {
			case 0:
				cpServeur="Le serveur joue Pierre";
				decision="Perdu !";
				nbDefaites++;
				break;
			case 1:
				cpServeur="Le serveur joue Feuille";
				decision="Gagné !";
				nbVictoires++;
				break;
			case 2:
				cpServeur="Le serveur joue Ciseaux";
				decision="Egalité !";
				break;
			default:
				decision="Erreur de logique";
			}
			break;
		default:
			decision="Erreur de logique";
		}
		
		request.setAttribute("nbParties", nbParties);
		request.setAttribute("nbVictoires", nbVictoires);
		request.setAttribute("nbDefaites", nbDefaites);
		
		request.setAttribute("decision", decision);
		request.setAttribute("cpServeur", cpServeur);
		request.setAttribute("cpClient", cpClient);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/tp_chifoumi/resultatChifoumi.jsp");
		rd.forward(request, response);
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
