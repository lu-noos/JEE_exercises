package fr.lucien.laurain.listecourses.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.lucien.laurain.listecourses.BO.ListeCourses;


public class CoursesDAOJdbcImpl implements DAO<ListeCourses> {
	//queries
	private static final String INSERTLISTE = "INSERT INTO listes (nomListe, date) VALUES (?, ?)";
	private static final String INSERTCOURSE = "INSERT INTO courses (nomCourse, idListeCourses, inPanier) VALUES (?, ?, 0);";
	private static final String SELECTALL = "SELECT * FROM listes INNER JOIN courses ON idListeCourses = idListe ORDER BY idListe ASC";
	//retourne idListe, nomListe, date, idCourse, nomCourse, idListeCourses, inPanier
	private static final String DELETE = "DELETE FROM listes WHERE idListe =?";
	private static final String UPDATECOURSE = "UPDATE courses SET inPanier=? WHERE nomCourse LIKE('?') AND idListe=?";

	//methods
	@Override
	public void insert(ListeCourses s) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERTLISTE, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, s.getNomListe());
			pstmt.setDate(2, Date.valueOf(s.getDate()));
			pstmt.executeUpdate();
			ResultSet keys = pstmt.getGeneratedKeys();

			if (keys.next()) {
				int cle = keys.getInt(1);

				for (Map.Entry<String, Boolean> ligne : s.getCourses().entrySet()) {
					System.out.println("Tentative d'insertion d'un article associé à la liste...");
					PreparedStatement pstmt2 = cnx.prepareStatement(INSERTCOURSE);
					System.out.println("valeur : " + ligne.getKey());
					pstmt2.setString(1, ligne.getKey());
					System.out.println("clé : " + cle);
					pstmt2.setInt(2, cle);
					pstmt2.executeUpdate();
				}
				System.out.println("Fin du processus...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Liste insérée !");
	}

	@Override
	public List<ListeCourses> selectAll() throws DALException {
		List<ListeCourses> sortie = new ArrayList<>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECTALL);
			//retourne 1 idListe, 2 nomListe, 3 date, 4 idCourse, 5 nomCourse, 6 idListeCourses, 7 inPanier
			
			// pour chaque ID de liste différent, boucler & ajouter chaque aliment dans la
			// liste de l'instance
			int id = 0;
			Integer idListe = 0;
			String nomListe = null;
			LocalDate dateListe = null;
			Map<String, Boolean> coursesDeListe = null;
			ListeCourses listeCoursesTemp = null;
			
			while (rs.next()) {
				//nouvelle liste
				if (idListe==0) {
					idListe = rs.getInt(1);
					nomListe = rs.getString(2);
					dateListe = rs.getDate(3).toLocalDate();
					coursesDeListe = new HashMap<>();
				}
				if (idListe != rs.getInt(1)) {
					listeCoursesTemp = new ListeCourses(idListe, nomListe, dateListe, coursesDeListe);
					sortie.add(listeCoursesTemp);
					System.out.println("Ajout d'une nouvelle " + listeCoursesTemp.toString());
					idListe = rs.getInt(1);
					nomListe = rs.getString(2);
					dateListe = rs.getDate(3).toLocalDate();
					coursesDeListe = new HashMap<>();
				}
				//ajout des aliments dans le repas
				coursesDeListe.put(rs.getString(5), rs.getBoolean(7));
			}
			listeCoursesTemp = new ListeCourses(idListe, nomListe, dateListe, coursesDeListe);
			sortie.add(listeCoursesTemp);
			System.out.println("Ajout d'un nouveau " + listeCoursesTemp.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Ajout de tous les repas réussi !");
		return sortie;
	}

	@Override
	public void delete(ListeCourses s) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			pstmt.setInt(1, s.getIdListe());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Liste supprimée !");
	}

	@Override
	public Boolean update(ListeCourses s, String nomCourse, boolean b) throws DALException {
		Boolean etat = false;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATECOURSE);
			pstmt.setBoolean(1, b);
			pstmt.setString(2, nomCourse);
			pstmt.setInt(3, s.getIdListe());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Liste supprimée !");
		
		
		return etat;
	}
}
