package core;
/**
 * 
 * 
 * @author Java Course Fadi Yassin
 * @author YVC college - 2024
 * 
 */


import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import utils.Country;

public class Sponsor extends Person implements Comparable<Sponsor>{

	private static final long serialVersionUID = 1L;
	private String nickName;
	private Set<Sponsor> sponsors;
	private List<Found> founds;

	// -------------------------------Constructor---------------------------------------------------------
	public Sponsor(String pId) {
		super(pId);
		// TODO Auto-generated constructor stub
	}
	


	public Sponsor(String pId, String fullName, int age, String nation, String nickName) {
		super(pId, fullName, age, nation);
		this.nickName = nickName;

	}
	

	public Sponsor(String pId, String fullName, int age, String nation, String nickName, Set<Sponsor> sponsors,
			List<Found> founds) {
		super(pId, fullName, age, nation);
		this.nickName = nickName;
		this.sponsors = sponsors;
		this.founds = founds;
	}



	// -------------------------------Getters And Setters---------------------------------------------------

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public Set<Sponsor> getSponsors() {
		return sponsors;
	}



	public void setSponsors(Set<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Found> getFounds() {
		return founds;
	}



	public void setFounds(List<Found> founds) {
		this.founds = founds;
	}
	
	// -------------------------------HashCode And Equlas---------------------------------------------------------

	
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nickName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sponsor other = (Sponsor) obj;
		return Objects.equals(nickName, other.nickName);
	}


	// -------------------------------More Methods---------------------------------------------------------
	@Override
	public int compareTo(Sponsor o) {
		// TODO Auto-generated method stub
		return this.getpId().compareTo(o.getpId());
	}



	



	

	


}
