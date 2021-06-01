package fr.lucien.laurain.listecourses.DAL;

import fr.lucien.laurain.listecourses.BO.ListeCourses;

public class DAOFactory {

	public static DAO<ListeCourses> getListeCoursesDAO() throws DALException {
		return new CoursesDAOJdbcImpl();
	}
	
}
