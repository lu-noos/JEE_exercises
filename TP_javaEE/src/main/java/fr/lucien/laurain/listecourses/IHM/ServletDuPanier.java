package fr.lucien.laurain.listecourses.IHM;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lucien.laurain.listecourses.BLL.BLLException;
import fr.lucien.laurain.listecourses.BLL.ListeCoursesManager;
import fr.lucien.laurain.listecourses.BO.ListeCourses;

/**
 * Servlet implementation class ServletDuPanier
 */
@WebServlet("/tps/tp_listecourses/ServletDuPanier")
public class ServletDuPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDuPanier() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ListeCourses> listesAAfficher = null;
		try {
			ListeCoursesManager manager = new ListeCoursesManager();
			listesAAfficher = manager.getAllListes();
			System.out.println("Les listes de course ont été extraites avec succès !");
		} catch (BLLException e) {
			e.printStackTrace();
		}
		int idCherche = Integer.parseInt(request.getParameter("idListe"));
		System.out.println("Recherche de la liste à l'id " + idCherche);
		ListeCourses listeAAfficher = null;
		for (ListeCourses ls : listesAAfficher) {
			if(ls.getIdListe() == idCherche) {
				listeAAfficher = ls;
				break;
			}
		}
		RequestDispatcher rd = null;
		request.setAttribute("listeAAfficher", listeAAfficher);
		rd = request.getRequestDispatcher("/WEB-INF/tp_listecourses/panier.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
