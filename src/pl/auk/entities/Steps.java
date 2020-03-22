package pl.auk.entities;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.CollectionId;

@Entity
@Table(name="steps")
public class Steps {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_step")
	private int idStep;
	
	
	
	@OneToMany(fetch=FetchType.EAGER,
				mappedBy="step",
				cascade= {
						CascadeType.PERSIST, 
						CascadeType.MERGE,
						CascadeType.DETACH, 
						CascadeType.REFRESH})
	private List<Bids> bids;
	
//	@Column(name="id-aukcja")
//	private int idAukcja;
	
	@Column(name="krok_nr")
	private int krokNr;
	
	@Column(name="min_change")
	private double minPost;
	
	@Column(name="id_aukcja") 
	private int idAukcja;


	public Steps() {
	}

	public int getIdAukcja() {
		return idAukcja;
	}



	public void setIdAukcja(int idAukcja) {
		this.idAukcja = idAukcja;
	}

	public Steps(int krokNr, double minPost, int idAukcja) {
		super();
		this.krokNr = krokNr;
		this.minPost = minPost;
		this.idAukcja = idAukcja;
	}


	public int getKrokNr() {
		return krokNr;
	}


	public void setKrokNr(int krokNr) {
		this.krokNr = krokNr;
	}


	public double getMinPost() {
		return minPost;
	}


	public void setMinPost(double minPost) {
		this.minPost = minPost;
	}


	public int getIdStep() {
		return idStep;
	}
	
	
	public void add(Bids bid)	{
		if (bids == null)	{
			bids = new ArrayList<>();
		}
		bids.add(bid);
		
		bid.setStep(this);
	}
	
	@Override
	public String toString() {
		return "Steps [idStep=" + idStep + ", bids=" + bids + ", krokNr=" + krokNr + ", minPost=" + minPost
				+ ", idAukcja=" + idAukcja + "]";
	}




	
	
	
	
}
