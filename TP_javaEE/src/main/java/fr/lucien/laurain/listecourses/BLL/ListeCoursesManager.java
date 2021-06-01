package fr.lucien.laurain.listecourses.BLL;

import java.util.List;

import fr.lucien.laurain.listecourses.BO.ListeCourses;
import fr.lucien.laurain.listecourses.DAL.DALException;
import fr.lucien.laurain.listecourses.DAL.DAO;
import fr.lucien.laurain.listecourses.DAL.DAOFactory;

public class ListeCoursesManager {

private DAO<ListeCourses> daoListeCourses;
	
	public ListeCoursesManager() throws BLLException {
		try {
			daoListeCourses = DAOFactory.getListeCoursesDAO();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	public void addListeCourses(ListeCourses listeCourses) throws BLLException {
		try {
			daoListeCourses.insert(listeCourses);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	public List<ListeCourses> getAllListes() throws BLLException {
		List<ListeCourses> sortie = null;
		try {
			sortie = daoListeCourses.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return sortie;
	}
	
	public void deleteListeCourses(ListeCourses listeCourses) throws BLLException {
		try {
			daoListeCourses.delete(listeCourses);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	public Boolean updateCourseInListe(ListeCourses listeCourses, String nomCourse, boolean b) throws BLLException {
		Boolean sortie = null;
		try {
			sortie = daoListeCourses.update(listeCourses, nomCourse, b);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return sortie;
	}
}
