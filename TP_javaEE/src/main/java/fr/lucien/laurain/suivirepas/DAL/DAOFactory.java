package fr.lucien.laurain.suivirepas.DAL;

import fr.lucien.laurain.suivirepas.BO.Repas;

public class DAOFactory {

	public static DAO<Repas> getRepasDAO() throws DALException {
		return new RepasDAOJdbcImpl();
	}
	
}
