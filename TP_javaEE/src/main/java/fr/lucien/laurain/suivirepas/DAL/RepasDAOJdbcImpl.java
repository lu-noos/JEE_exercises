package fr.lucien.laurain.suivirepas.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fr.lucien.laurain.suivirepas.BO.Repas;

public class RepasDAOJdbcImpl implements DAO<Repas> {

	private static final String INSERTREPAS = "INSERT INTO repas (dateRepas, heureRepas) VALUES(?, ?)";
	private static final String INSERTALIM = "INSERT INTO aliments (idRepas, nom) VALUES(?, ?)";
	private static final String SELECTALL = "SELECT * FROM repas INNER JOIN aliments ON repas.id = aliments.idRepas ORDER BY dateRepas ASC, heureRepas ASC;";

	@Override
	public void insert(Repas repas) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERTREPAS, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, repas.getDate());
			pstmt.setString(2, repas.getHeure());
			pstmt.executeUpdate();
			ResultSet keys = pstmt.getGeneratedKeys();

			if (keys.next()) {
				int cle = keys.getInt(1);
				for (String str : repas.getAliments()) {
					System.out.println("Tentative d'insertion d'un aliment associé...");
					PreparedStatement pstmt2 = cnx.prepareStatement(INSERTALIM);
					System.out.println("clé : " + cle);
					pstmt2.setInt(1, cle);
					System.out.println("valeur : " + str);
					pstmt2.setString(2, str);
					pstmt2.executeUpdate();
				}
				System.out.println("Fin du processus...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Repas inséré !");
	}

	@Override
	public List<Repas> selectAll() throws DALException {
		List<Repas> sortie = new ArrayList<>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECTALL);
			// pour chaque ID de repas différent, boucler & ajouter chaque aliment dans la
			// liste de l'instance
			int id = 0;
			List<String> alimentsDuRepas = null;
			String dateRepasTemp = null;
			String heureRepasTemp = null;
			Repas repasTemp = null;
			
			while (rs.next()) {
				//nouveau repas
				if (id==0) {
					id = rs.getInt(1);
					alimentsDuRepas = new ArrayList<>();
					dateRepasTemp = rs.getString(2);
					heureRepasTemp = rs.getString(3);
				}
				if (id != rs.getInt(1)) {
					id = rs.getInt(1);
					repasTemp = new Repas(dateRepasTemp, heureRepasTemp, alimentsDuRepas);
					sortie.add(repasTemp);
					System.out.println("Ajout d'un nouveau " + repasTemp.toString());
					alimentsDuRepas = new ArrayList<>();
					dateRepasTemp = rs.getString(2);
					heureRepasTemp = rs.getString(3);
				}
				//ajout des aliments dans le repas
				alimentsDuRepas.add(rs.getString(6));
			}
			repasTemp = new Repas(dateRepasTemp, heureRepasTemp, alimentsDuRepas);
			sortie.add(repasTemp);
			System.out.println("Ajout d'un nouveau " + repasTemp.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Ajout de tous les repas réussi");
		return sortie;
	}
}
