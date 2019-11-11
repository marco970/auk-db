package pl.auk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aukcje")
public class Aukcje {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id-aukcja")
	private int idAukcja;

	@Column(name="name")
	private String nazwaAuk;
	
	@Column(name="opis")
	private String opisAuk;
	
	@Column(name="data-create")
	private String dataCreateAuk;
	
	@Column(name="data-start")
	private String dataStartAk;
	
	public Aukcje()	{
		
	}

	
	public Aukcje(String nazwaAuk, String opisAuk, String dataCreateAuk, String dataStartAk) {
		super();
		this.nazwaAuk = nazwaAuk;
		this.opisAuk = opisAuk;
		this.dataCreateAuk = dataCreateAuk;
		this.dataStartAk = dataStartAk;
	}


	public int getIdAukcja() {
		return idAukcja;
	}


	public void setIdAukcja(int idAukcja) {
		this.idAukcja = idAukcja;
	}


	public String getNazwaAuk() {
		return nazwaAuk;
	}


	public void setNazwaAuk(String nazwaAuk) {
		this.nazwaAuk = nazwaAuk;
	}


	public String getOpisAuk() {
		return opisAuk;
	}


	public void setOpisAuk(String opisAuk) {
		this.opisAuk = opisAuk;
	}


	public String getDataCreateAuk() {
		return dataCreateAuk;
	}


	public void setDataCreateAuk(String dataCreateAuk) {
		this.dataCreateAuk = dataCreateAuk;
	}


	public String getDataStartAk() {
		return dataStartAk;
	}


	public void setDataStartAk(String dataStartAk) {
		this.dataStartAk = dataStartAk;
	}


	@Override
	public String toString() {
		return "Aukcje [idAukcja=" + idAukcja + ", nazwaAuk=" + nazwaAuk + ", opisAuk=" + opisAuk + ", dataCreateAuk="
				+ dataCreateAuk + ", dataStartAk=" + dataStartAk + "]";
	}
	
	
}
