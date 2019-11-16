package pl.auk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bidders")
public class Bidders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id-bidder")
	private int idBidder;
	
	@Column(name="id-aukcja")
	private int idAukcja;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="domiar")
	private int domiar;


	public Bidders() {
		super();
	}


	public Bidders(int idAukcja, String name, String email, int domiar) {
		super();
		this.idAukcja = idAukcja;
		this.name = name;
		this.email = email;
		this.domiar = domiar;
	}


	public int getIdBidder() {
		return idBidder;
	}


	public void setIdBidder(int idBidder) {
		this.idBidder = idBidder;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getDomiar() {
		return domiar;
	}


	public void setDomiar(int domiar) {
		this.domiar = domiar;
	}


	public int getIdAukcja() {
		return idAukcja;
	}


	@Override
	public String toString() {
		return "Bidders [idBidder=" + idBidder + ", idAukcja=" + idAukcja + ", name=" + name + ", email=" + email
				+ ", domiar=" + domiar + "]";
	}
	
	
	

}
