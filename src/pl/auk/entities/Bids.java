package pl.auk.entities;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="bids")
public class Bids {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id-bid")	
	private int idBid;
	
//	@Column(name="id-bidder")
//	private int idBidder;
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id-bidder")
	private Bidders bidder;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id-aukcja")
	private Steps step;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id-aukcja")
	private Aukcje aukcja;
	
	@Column(name="cena")
	private int cena;
	
	@Column(name="pozycja")
	private int pozycja; 
	
	
	public Bids()	{	
	}
	
	public Bids(int cena, int pozycja) {
		super();
		this.cena = cena;
		this.pozycja = pozycja;
	}

	public int getIdBid() {
		return idBid;
	}

	public void setIdBid(int idBid) {
		this.idBid = idBid;
	}

	public Bidders getBidder() {
		return bidder;
	}

	public void setBidder(Bidders bidder) {
		this.bidder = bidder;
	}

	public Steps getStep() {
		return step;
	}

	public void setStep(Steps step) {
		this.step = step;
	}

	public Aukcje getAukcja() {
		return aukcja;
	}

	public void setAukcja(Aukcje aukcja) {
		this.aukcja = aukcja;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getPozycja() {
		return pozycja;
	}

	public void setPozycja(int pozycja) {
		this.pozycja = pozycja;
	}

	@Override
	public String toString() {
		return "Bids [idBid=" + idBid + ", bidder=" + bidder + ", step=" + step + ", aukcja=" + aukcja + ", cena="
				+ cena + ", pozycja=" + pozycja + "]";
	}


	


	
	
	
	
	

}
