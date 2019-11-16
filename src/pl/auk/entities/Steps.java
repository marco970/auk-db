package pl.auk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="steps")
public class Steps {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id-step")
	private int idStep;
	
	@Column(name="id-aukcja")
	private int idAukcja;
	
	@Column(name="krok-nr")
	private int krokNr;
	
	@Column(name="min-change")
	private int minPost;


	public Steps() {
		super();
	}


	public Steps(int idAukcja, int krokNr, int minPost) {
		super();
		this.idAukcja = idAukcja;
		this.krokNr = krokNr;
		this.minPost = minPost;
	}


	public int getIdAukcja() {
		return idAukcja;
	}


	public void setIdAukcja(int idAukcja) {
		this.idAukcja = idAukcja;
	}


	public int getKrokNr() {
		return krokNr;
	}


	public void setKrokNr(int krokNr) {
		this.krokNr = krokNr;
	}


	public int getMinPost() {
		return minPost;
	}


	public void setMinPost(int minPost) {
		this.minPost = minPost;
	}


	public int getIdStep() {
		return idStep;
	}


	@Override
	public String toString() {
		return "Steps [idStep=" + idStep + ", idAukcja=" + idAukcja + ", krokNr=" + krokNr + ", minPost=" + minPost
				+ "]";
	}
	
	
	
	
}
