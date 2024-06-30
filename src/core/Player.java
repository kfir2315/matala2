package core;
/**
 * Player Class
 * @author Fadi Yassin
 * @author Amik  - 2024 
 */
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import utils.Country;
import utils.E_Position;
import utils.Role;

public class Player extends Person implements Comparable<Player>, Serializable {
 
	private static final long serialVersionUID = 1L;

    private int pNum;
    private E_Position position;
    private int fansCount;
    private Team currentTeam;
    private Trophy<Player> trophy;
    private Set<Match> matches;
    private Set<Customer> customers; 

    
 // -------------------------------Constructor---------------------------------------------------------
    //constructor with Id
    public Player(String pId) {
 		super(pId);
 		// TODO Auto-generated constructor stub
 	}
    

	public Player(String pId, String fullName, int age, String nation, int pNum, E_Position position, int fansCount,
			Team currentTeam) {
		super(pId, fullName, age, nation);
		this.pNum = pNum;
		this.position = position;
		this.fansCount = fansCount;
		this.currentTeam = currentTeam;

		
	}	

	public Player(String pId, String fullName, int age, String nation, int pNum, E_Position position, int fansCount,
			Team currentTeam, Trophy<Player> trophy, Set<Match> matches, Set<Customer> customers) {
		super(pId, fullName, age, nation);
		this.pNum = pNum;
		this.position = position;
		this.fansCount = fansCount;
		this.currentTeam = currentTeam;
		this.trophy = trophy;
		this.matches = matches;
		this.customers = customers;
	}


	// -------------------------------Getters And Setters---------------------------------------------------------
	public int getpNum() {
		return pNum;
	}


	public void setpNum(int pNum) {
		this.pNum = pNum;
	}


	public int getFansCount() {
		return fansCount;
	}


	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}


	public Team getCurrentTeam() {
		return currentTeam;
	}


	public void setCurrentTeam(Team currentTeam) {
		this.currentTeam = currentTeam;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public E_Position getPosition() {
		return position;
	}


	public void setPosition(E_Position position) {
		this.position = position;
	}
	
	public Trophy<Player> getTrophy() {
		return trophy;
	}


	public void setTrophy(Trophy<Player> trophy) {
		this.trophy = trophy;
	}


	public Set<Match> getMatches() {
		return matches;
	}


	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}


	public Set<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}


	// -------------------------------HashCode And Equlas---------------------------------------------------------



	


	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    if (!super.equals(o)) return false;
	    Player player = (Player) o;
	    return pId.equals(player.pId); // Ensure you are comparing unique identifiers
	}

	@Override
	public int hashCode() {
	    return Objects.hash(super.hashCode(), pId); // Use unique identifier
	}

	


    
    // -------------------------------More Methods------------------------------
    /**
     * This method adds the player to the given team and removes the player from its current team
     * only if the given team doesn't equal to the Player's current team.
     *
     * @param team
     * @return true if the player was added successfully to team, false otherwise
     */
	public boolean transferTo(Team team) {
        if (team == null || team.equals(this.currentTeam)) {
            return false; // Cannot transfer to null or same team
        }

        // Remove player from the currentTeam 
        if (this.currentTeam != null) {
            Player[] currentPlayers = this.currentTeam.getPlayers();
            Player[] newPlayers = new Player[currentPlayers.length - 1];
            int index = 0;
            for (Player player : currentPlayers) {
                if (!player.equals(this)) {
                    newPlayers[index++] = player;
                }
            }
            this.currentTeam.setPlayers(newPlayers);
        }

        // Add player to the new team
        Player[] newTeamPlayers = new Player[team.getPlayers().length + 1];
        System.arraycopy(team.getPlayers(), 0, newTeamPlayers, 0, team.getPlayers().length);
        newTeamPlayers[team.getPlayers().length] = this;
        team.setPlayers(newTeamPlayers);
        team.setFansCount(team.getFansCount() + this.fansCount);
        this.currentTeam = team;

        return true;
    }




	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		 return this.getpId().compareTo(o.getpId());
	}
    
    


}
