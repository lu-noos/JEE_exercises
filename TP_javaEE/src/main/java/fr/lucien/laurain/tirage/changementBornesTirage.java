package fr.lucien.laurain.tirage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changementBornesTirage
 */
@WebServlet("/tps/tp_tirage/changementBornesTirage")
public class changementBornesTirage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static int newBorneInf;
    static int newBorneSup;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changementBornesTirage() {
        super();
        newBorneInf=0;
        newBorneSup=10;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		newBorneInf = Integer.parseInt(request.getParameter("borneInf"));
		newBorneSup = Integer.parseInt(request.getParameter("borneSup"));
	}
	
	public static int getNewBorneInf() {
		return newBorneInf;
	}
	
	public static int getNewBorneSup() {
		return newBorneSup;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
