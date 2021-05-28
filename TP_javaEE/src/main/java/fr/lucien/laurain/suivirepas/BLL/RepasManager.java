package fr.lucien.laurain.suivirepas.BLL;


import java.util.List;

import fr.lucien.laurain.suivirepas.BO.Repas;
import fr.lucien.laurain.suivirepas.DAL.DALException;
import fr.lucien.laurain.suivirepas.DAL.DAO;
import fr.lucien.laurain.suivirepas.DAL.DAOFactory;

public class RepasManager {

	private DAO<Repas> daoRepas;
	
	public RepasManager() throws BLLException {
		try {
			daoRepas = DAOFactory.getRepasDAO();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	public void addRepas(Repas repas) throws BLLException {
		try {
			daoRepas.insert(repas);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	public List<Repas> getRepas() throws BLLException {
		List<Repas> sortie = null;
		try {
			sortie = daoRepas.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return sortie;
	}
}