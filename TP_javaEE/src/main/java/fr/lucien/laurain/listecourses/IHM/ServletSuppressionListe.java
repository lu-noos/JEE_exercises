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
 * Servlet implementation class ServletSuppressionListe
 */
@WebServlet("/tps/tp_listecourses/ServletSuppressionListe")
public class ServletSuppressionListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSuppressionListe() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ListeCourses> listesAParcourir = null;
		ListeCoursesManager manager = null;
		try {
			manager = new ListeCoursesManager();
			listesAParcourir = manager.getAllListes();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		int idCherche = Integer.parseInt(request.getParameter("idListe"));
		System.out.println("Recherche de la liste à l'id " + idCherche);
		ListeCourses listeASupprimer = null;
		for (ListeCourses ls : listesAParcourir) {
			if(ls.getIdListe() == idCherche) {
				listeASupprimer = ls;
				break;
			}
		}
		try {
			manager.deleteListeCourses(listeASupprimer);
			System.out.println("La liste de courses " + listeASupprimer.getNomListe() + " a été supprimée avec succès !");
		} catch (BLLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/tps/tp_listecourses/ServletAffichageListes");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
