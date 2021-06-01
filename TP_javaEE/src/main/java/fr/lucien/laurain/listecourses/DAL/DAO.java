package fr.lucien.laurain.listecourses.DAL;

import java.util.List;

public interface DAO<T> {
	public void insert(T s)throws DALException; //ajouter une liste
	public List<T> selectAll()throws DALException; //afficher une liste
	public void delete(T s)throws DALException; //supprimer une liste
	public Boolean update(T s, String c, boolean b) throws DALException; //changer l'état d'un article de la liste
}
