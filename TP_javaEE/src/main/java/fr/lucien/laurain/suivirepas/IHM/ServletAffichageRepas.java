package fr.lucien.laurain.suivirepas.IHM;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lucien.laurain.suivirepas.BLL.BLLException;
import fr.lucien.laurain.suivirepas.BLL.RepasManager;
import fr.lucien.laurain.suivirepas.BO.Repas;

/**
 * Servlet implementation class ServletAffichageRepas
 */
@WebServlet("/tps/tp_suivirepas/ServletAffichageRepas")
public class ServletAffichageRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// @see HttpServlet#HttpServlet()
	public ServletAffichageRepas() {
		super();
	}

	// @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	// response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Repas> repasAAfficher = null;
		try {
			RepasManager manager = new RepasManager();
			repasAAfficher = manager.getRepas();
			System.out.println("Les repas ont été extraits avec succès !");
		} catch (BLLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = null;
		if (repasAAfficher == null) {
			rd = request.getRequestDispatcher("/WEB-INF/tp_suivirepas/accueilRepas.jsp");
		} else {
			request.setAttribute("repasAAfficher", repasAAfficher);
			rd = request.getRequestDispatcher("/WEB-INF/tp_suivirepas/listeRepas.jsp");
		}
		rd.forward(request, response);
	}

	// @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	// response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
