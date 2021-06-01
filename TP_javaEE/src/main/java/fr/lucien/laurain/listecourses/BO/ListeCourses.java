package fr.lucien.laurain.listecourses.BO;

import java.time.LocalDate;
import java.util.Map;

public class ListeCourses {

	private int idListe;
	private String nomListe;
	private LocalDate date;
	private Map<String, Boolean> courses;
	
	public ListeCourses(int idListe, String nomListe, LocalDate date, Map<String, Boolean> courses) {
		this.idListe = idListe;
		this.nomListe = nomListe;
		this.date = date;
		this.courses = courses;
	}

	public int getIdListe() {
		return idListe;
	}

	public String getNomListe() {
		return nomListe;
	}

	public LocalDate getDate() {
		return date;
	}

	public Map<String, Boolean> getCourses() {
		return courses;
	}

	public void setIdListe(int idListe) {
		this.idListe = idListe;
	}

	public void setNomListe(String nom) {
		this.nomListe = nom;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setCourses(Map<String, Boolean> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "ListeCourses ID : " + idListe + ", " + (nomListe != null ? "nom : " + nomListe + ", " : "")
				+ (date != null ? "date : " + date + ", " : "") + (courses != null ? "courses : " + courses : "");
	}
	
	
	
}
