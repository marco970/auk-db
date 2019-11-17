package pl.auk.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="bidders")
public class Bidders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id-bidder")
	private int idBidder; 
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id-aukcja")
	private Aukcje aukcje;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="domiar")
	private int domiar;
	
	@OneToMany(mappedBy="bidder",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Bids> bids;

	
	public Bidders() {
		super();
	}
	
	public Bidders(String name, String email, int domiar) {
		super();
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

	public List<Bids> getBids() {
		return bids;
	}

	public void setBids(List<Bids> bids) {
		this.bids = bids;
	}

	public Aukcje getAukcja() {
		return aukcje;
	}


	public void setAukcja(Aukcje aukcje) {
		this.aukcje = aukcje;
	}
	
	public void add(Bids bid)	{
		if (bids == null)	{
			bids = new ArrayList<>();
		}
		bids.add(bid);
		
		bid.setBidder(this);
	}
	


	@Override
	public String toString() {
		return "Bidders [idBidder=" + idBidder + ", name=" + name + ", email=" + email + ", domiar=" + domiar + "]";
	}
	
}
