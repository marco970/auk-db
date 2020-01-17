package pl.auk.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="aukcje")
public class Aukcje {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aukcja")
	private int idAukcja;

	
	@Column(name="name")
	private String nazwaAuk;
	
	@Column(name="opis")
	private String opisAuk;
	
	@Column(name="data_conf")
	private String dataCreateAuk;
	
	@Column(name="data_end")
	private String dataStartAk;
	
	@Column(name="waluta")
	private String waluta;
	

	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="aukcja",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Bidders> bidders;
	

	


	public Aukcje()	{
	}

	public Aukcje(String nazwaAuk, String opisAuk, String dataCreateAuk, String dataStartAk, String waluta) {
//	public Aukcje(String nazwaAuk) {
		this.nazwaAuk = nazwaAuk;
		this.opisAuk = opisAuk;
		this.dataCreateAuk = dataCreateAuk;
		this.dataStartAk = dataStartAk;
		this.waluta = waluta;
		
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
	
	


	public String getWaluta() {
		return waluta;
	}

	public void setWaluta(String waluta) {
		this.waluta = waluta;
	}
	
	

//	public List<Bidders> getBidders() {
//		return bidders;
//	}
//
//
//	public void setBidders(List<Bidders> bidders) {
//		this.bidders = bidders;
//	}
//
//
	public void add(Bidders bidder)	{
		if(bidders == null)	{
			bidders = new ArrayList<>();
		}
		bidders.add(bidder);
		bidder.setAukcja(this);
	}
//	
	

	@Override
	public String toString() {
		return "Aukcje [idAukcja=" + idAukcja + ", nazwaAuk=" + nazwaAuk + ", opisAuk=" + opisAuk + ", dataCreateAuk="
				+ dataCreateAuk + ", dataStartAk=" + dataStartAk + ", waluta=" + waluta + "]";
	}	


//	public String toString() {
//		return "Aukcje [idAukcja=" + idAukcja + ", nazwaAuk=" + nazwaAuk + "]";
//	}	
}
