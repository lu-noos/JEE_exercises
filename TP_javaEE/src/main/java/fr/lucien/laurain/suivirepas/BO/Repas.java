package fr.lucien.laurain.suivirepas.BO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Repas {

	private String date;
	private String heure;
	private List<String> aliments;
	
	public Repas(String date, String heure, List<String> aliments) {
		this.date = date;
		this.heure = heure;
		this.aliments = aliments;
	}

	public String getDate() {
		return date;
	}

	public String getHeure() {
		return heure;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public List<String> getAliments() {
		return aliments;
	}

	public void setAliments(List<String> aliments) {
		this.aliments = aliments;
	}

	@Override
	public String toString() {
		return "Repas " + (date != null ? "date : " + date + ", " : "")
				+ (heure != null ? "heure : " + heure + ", " : "")
				+ (aliments != null ? "aliments : " + aliments.toString(): "");
	}

	
	
}