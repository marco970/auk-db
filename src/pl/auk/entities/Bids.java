package pl.auk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bids")
public class Bids {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id-bid")	
	private int idBid;
	
	@Column(name="id-bidder")
	private int idBidder;
	
	@Column(name="id-step")
	private int idStep;
	
	@Column(name="min-post")
	private int minPost;
	
	@Column(name="cena")
	private int cena;
	
	@Column(name="pozycja")
	private int pozycja; 
	
	@Column(name="id-aukcja")
	private int idAukcja;
	
	
	public Bids()	{
		
	}


	public Bids(int idBidder, int idStep, int minPost, int cena, int pozycja, int idAukcja) {
		super();
		this.idBidder = idBidder;
		this.idStep = idStep;
		this.minPost = minPost;
		this.cena = cena;
		this.pozycja = pozycja;
		this.idAukcja = idAukcja;
	}


	public int getIdBid() {
		return idBid;
	}


	public void setIdBid(int idBid) {
		this.idBid = idBid;
	}


	public int getIdBidder() {
		return idBidder;
	}


	public void setIdBidder(int idBidder) {
		this.idBidder = idBidder;
	}


	public int getIdStep() {
		return idStep;
	}


	public void setIdStep(int idStep) {
		this.idStep = idStep;
	}


	public int getMinPost() {
		return minPost;
	}


	public void setMinPost(int minPost) {
		this.minPost = minPost;
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


	public int getIdAukcja() {
		return idAukcja;
	}


	public void setIdAukcja(int idAukcja) {
		this.idAukcja = idAukcja;
	}


	@Override
	public String toString() {
		return "Bids [idBid=" + idBid + ", idBidder=" + idBidder + ", idStep=" + idStep + ", minPost=" + minPost
				+ ", cena=" + cena + ", pozycja=" + pozycja + ", idAukcja=" + idAukcja + "]";
	}
	
	
	
	
	

}
