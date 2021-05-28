package fr.lucien.laurain.suivirepas.IHM;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
 * Servlet implementation class ServletAjoutRepas
 */
@WebServlet("/tps/tp_suivirepas/ServletAjoutRepas")
public class ServletAjoutRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutRepas() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("date")==null) {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/tp_suivirepas/insertionRepas.jsp");
		rd.forward(request, response);
		} else {
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String alimentsNotParse = request.getParameter("aliments");
			String alimentsArray[] = alimentsNotParse.split(", ");
			List<String> aliments = new ArrayList<>();
			for (String aliment : alimentsArray) {
				aliments.add(aliment);
			}
			Repas newRepas = new Repas(date, time, aliments);
			try {
				RepasManager manager = new RepasManager();
				manager.addRepas(newRepas);
				System.out.println("Repas ajouté avec succès !");
			} catch (BLLException e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/tps/tp_suivirepas/ServletAffichageRepas");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
