package fr.lucien.laurain.listecourses.IHM;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lucien.laurain.listecourses.BLL.BLLException;
import fr.lucien.laurain.listecourses.BLL.ListeCoursesManager;
import fr.lucien.laurain.listecourses.BO.ListeCourses;

/**
 * Servlet implementation class AjoutListe
 */
@WebServlet("/tps/tp_listecourses/ServletAjoutListe")
public class ServletAjoutListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, Boolean> coursesTemp;
	String nomSave;
	String nomListe;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjoutListe() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Cookie[] cookies= request.getCookies();
		Cookie cookieNom = null;
		if (request.getParameter("nomListe") == null) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/tp_listecourses/listes.jsp");
				rd.forward(request, response);
		} else {
			cookieNom = new Cookie("nomListe", request.getParameter("nomListe"));
			cookieNom.setMaxAge(600);
			response.addCookie(cookieNom);
			nomListe = request.getParameter("nomListe");
			request.setAttribute("nomListe", nomListe);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/tp_listecourses/ajout.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Cookie[] cookies= request.getCookies();
		if (request.getParameter("nomListe") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/tp_listecourses/listes.jsp");
			rd.forward(request, response);
		} else {
			
			// si on valide
			if (request.getParameter("validation")!=null) {
				String nomSave = request.getParameter("nomListe");
				request.setAttribute("nomListe", nomSave);
				String nom = nomSave;
				LocalDate date = LocalDate.now();
				ListeCourses newListeCourses = new ListeCourses(0, nom, date, coursesTemp);
				try {
					ListeCoursesManager manager = new ListeCoursesManager();
					manager.addListeCourses(newListeCourses);
					System.out.println("Liste ajoutée dans la BDD !");
				} catch (BLLException e) {
					e.printStackTrace();
				}
				//suppression des cookies
				
				if (cookies != null)
			        for (Cookie cookie : cookies) {
			            cookie.setValue("");
			            cookie.setPath("/");
			            cookie.setMaxAge(0);
			            response.addCookie(cookie);
			        }
				nomSave = null;
				coursesTemp=new HashMap<>();
				RequestDispatcher rd = request.getRequestDispatcher("/tps/tp_listecourses/ServletAffichageListes");
				rd.forward(request, response);
				
			// si on ajoute
			} else {
				if (coursesTemp == null) {
					coursesTemp=new HashMap<>();
				}
				coursesTemp.put(request.getParameter("newCourse"), false);
				request.setAttribute("coursesTemp", coursesTemp);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/tp_listecourses/ajout.jsp");
				rd.forward(request, response);
			}
		}
	}
}
