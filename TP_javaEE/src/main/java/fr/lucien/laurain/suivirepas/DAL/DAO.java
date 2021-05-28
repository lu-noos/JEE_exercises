package fr.lucien.laurain.suivirepas.DAL;

import java.util.List;

public interface DAO<T> {
	public void insert(T s)throws DALException;
	public List<T> selectAll()throws DALException;
}
