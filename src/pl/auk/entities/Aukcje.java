package pl.auk.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(name="waluta")
	private String waluta;
	
	@OneToMany(mappedBy="aukcje",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Bidders> bidders;
	
	@OneToMany(mappedBy="aukcje",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Steps> steps;
	
	@OneToMany(mappedBy="aukcje",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Bids> bids;
	


	public Aukcje()	{
	}

	public Aukcje(String nazwaAuk, String opisAuk, String dataCreateAuk, String dataStartAk, String waluta) {
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

	public List<Bidders> getBidders() {
		return bidders;
	}


	public void setBidders(List<Bidders> bidders) {
		this.bidders = bidders;
	}


	public void add(Bidders bidder)	{
		if(bidders == null)	{
			bidders = new ArrayList<>();
		}
		bidders.add(bidder);
		bidder.setAukcja(this);
	}
	
	public List<Steps> getSteps() {
		return steps;
	}

	public void setSteps(List<Steps> steps) {
		this.steps = steps;
	}
	
	public void add(Steps step)	{
		if(steps == null)	{
			steps = new ArrayList<>();
		}
		steps.add(step);
		step.setAukcja(this);
	}

	public List<Bids> getBids() {
		return bids;
	}

	public void setBids(List<Bids> bids) {
		this.bids = bids;
	}
	
	public void add(Bids bid)	{
		if(bids == null)	{
			bids = new ArrayList<>();
		}
		bids.add(bid);
		bid.setAukcja(this);
	}

	@Override
	public String toString() {
		return "Aukcje [idAukcja=" + idAukcja + ", nazwaAuk=" + nazwaAuk + ", opisAuk=" + opisAuk + ", dataCreateAuk="
				+ dataCreateAuk + ", dataStartAk=" + dataStartAk + ", waluta=" + waluta + "]";
	}	
}
