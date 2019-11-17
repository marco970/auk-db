package pl.auk.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="steps")
public class Steps {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id-step")
	private int idStep;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id-aukcja")
	private Aukcje aukcja;
	
	@OneToMany(mappedBy="step",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Bids> bids;
	
//	@Column(name="id-aukcja")
//	private int idAukcja;
	
	@Column(name="krok-nr")
	private int krokNr;
	
	@Column(name="min-change")
	private int minPost;


	public Steps() {
	}

	public Steps(int krokNr, int minPost) {
		super();
		this.krokNr = krokNr;
		this.minPost = minPost;
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
	
	public Aukcje getAukcja () {
		return aukcja;
	}


	public void setAukcja(Aukcje aukcje) {
		this.aukcja = aukcje;
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
		return "Steps [idStep=" + idStep + ", krokNr=" + krokNr + ", minPost=" + minPost + "]";
	}
	


	
	
	
	
}
