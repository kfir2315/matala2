package core;
/**
 * 
 * 
 * @author Java Course Fadi Yassin
 * @author YVC college - 2024
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import utils.Country;
import utils.E_Trophy;


public class Team {
	/**
	 * the team identification number 
	 */
	private String tNumber;
	/**
	 * team full name
	 */
	private String tName;
	/**
	 * this calculated field is a result of total fans of all player 
	 * of this team  
	 */
	private int fansCount;
	/**
	 * sponsor that the team sponsored from 
	 * of this team  
	 */
	private Sponsor sponsor;
	/**
	 * country that this team represent, each team 
	 * represent one country 
	 */
	private Country represents;
	/**
	 * The coach of the team 
	 *  
	 */
	private Coach coach;
	
	private Player[] players;
	private Trophy<Team> trophy;
	private List<Found> founds; 
	private Set<Match> matches;

	  // -------------------------------Constructors------------------------------
	public Team(String tNumber) {
		super();
		this.tNumber = tNumber;
	}

	public Team(String tNumber, String tName, int fansCount, String represents) {
		super();
		this.tNumber = tNumber;
		this.tName = tName;
		this.fansCount = fansCount;
		setRepresents(represents);
	
	}

	
	  // -------------------------------Getters And Setters------------------------------

	public String gettNumber() {
		return tNumber;
	}


	public void settNumber(String tNumber) {
		this.tNumber = tNumber;
	}


	public String gettName() {
		return tName;
	}


	public void settName(String tName) {
		this.tName = tName;
	}


	public int getFansCount() {
		return fansCount;
	}


	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}


	public Country getRepresents() {
		return represents;
	}


	public void setRepresents(String represents) {
		 this.represents = Country.getCounrtyByName(represents);
	}



	public void setRepresents(Country represents) {
		this.represents = represents;
	}


	  public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	

	public List<Found> getFounds() {
		return founds;
	}

	public void setFounds(List<Found> founds) {
		this.founds = founds;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public Trophy<Team> getTrophy() {
		return trophy;
	}

	public void setTrophy(Trophy<Team> trophy) {
		this.trophy = trophy;
	}
	
	

	public Set<Match> getMatches() {
		return matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

	// -------------------------------HashCode And Equals------------------------------
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Team team = (Team) o;
	    return tNumber.equals(team.tNumber); // Ensure you are comparing unique identifiers
	}

	@Override
	public int hashCode() {
	    return Objects.hash(tNumber); // Use unique identifier
	}

	  // -------------------------------More Methods------------------------------




	

}
