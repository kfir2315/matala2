package core;

/**
 * 
 * 
 * @author Java Course Fadi Yassin
 * @author YVC college - 2024
 * 
 */

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import utils.Stadium;

public class Match implements Comparable<Match> {
	/**
	 * game identification number , used as key
	 */
	private String mId;
	/**
	 * the date when the game took place
	 */
	private Date mDate;
	/**
	 * the place where the game took place;
	 */
	private Stadium tookPlace;
	
	/**
	 * total Tickets sold 
	 */
	private long totalTickets;
	/**
	 * as the two teams participant in ONE match
	 */
	private MatchResult result;
	
	private Set<Player> players;

	private Set<Customer> customers;
	
	private Team team;
	
	private Stadium stadium;
	//constructors
	
	public Match(String mId, Date mDate, String tookPlace, long totalTickets, MatchResult result) {
		super();
		this.mId = mId;
		setmDate(mDate);
		setTookPlace(tookPlace);
		this.totalTickets = totalTickets;
		this.result = result;
	
	
	}
	
	

	public Match(String mId, Date mDate, Stadium tookPlace, long totalTickets, MatchResult result, Set<Player> players,
			Set<Customer> customers, Team team) {
		super();
		this.mId = mId;
		this.mDate = mDate;
		this.tookPlace = tookPlace;
		this.totalTickets = totalTickets;
		this.result = result;
		this.players = players;
		this.customers = customers;
		this.team = team;
	}



	public Match(String mId) {
		super();
		this.mId = mId;
	}
	// -------------------------------Getters And Setters------------------------------
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public Date getmDate() {
		return mDate;
	}
	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}
	public Stadium getTookPlace() {
		return tookPlace;
	}
	public void setTookPlace(String tookPlace) {
		this.tookPlace = Stadium.getStadiumByName(tookPlace);
	}
	public long getTotalTickets() {
		return totalTickets;
	}
	public void setTotalTickets(long totalTickets) {
		this.totalTickets = totalTickets;
	}
	public MatchResult getResult() {
		return result;
	}
	public void setResult(MatchResult result) {
		this.result = result;
	}
	
	public Set<Player> getPlayers() {
		return players;
	}



	public void setPlayers(Set<Player> players) {
		this.players = players;
	}



	public Set<Customer> getCustomers() {
		return customers;
	}



	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}



	public Team getTeam() {
		return team;
	}



	public void setTeam(Team team) {
		this.team = team;
	}



	public void setTookPlace(Stadium tookPlace) {
		this.tookPlace = tookPlace;
	}

	// -------------------------------hashCode equals & toString------------------------------
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Match match = (Match) o;
	    return mId.equals(match.mId); // Ensure you are comparing unique identifiers
	}

	@Override
	public int hashCode() {
	    return Objects.hash(mId); // Use unique identifier
	}


	// -------------------------------More Methods------------------------------
	@Override
	public int compareTo(Match o) {
		// TODO Auto-generated method stub
		return this.getmDate().compareTo(o.getmDate());
	}

	@Override
	public String toString() {
		return "Match [mId=" + mId + ", mDate=" + mDate + ", tookPlace=" + tookPlace + ", totalTickets=" + totalTickets
				+ ", result=" + result + ", players=" + players + ", customers=" + customers + ", team=" + team + "]";
	}

	
	
	
}
