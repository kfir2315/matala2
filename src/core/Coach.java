package core;

import java.util.Objects;

import java.util.Set;

import utils.E_Levels;

public class Coach extends Person{
	
	private Team MainTeam;
	private Trophy<Coach> trophy;
	private E_Levels level;
	private Set<Team> teams;
	
	
	public Coach(String pId, String fullName, int age, String nation, Team mainTeam, E_Levels level) {
		super(pId, fullName, age, nation);
		this.MainTeam = mainTeam;
		this.level = level;
		
	}
	
	
	public Coach(String pId) {
		super(pId);
		// TODO Auto-generated constructor stub
	}
	
	


	// -------------------------------Getters And Setters------------------------------
	public Team getMainTeam() {
		return MainTeam;
	}


	public void setMainTeam(Team mainTeam) {
		MainTeam = mainTeam;
	}

	public Trophy<Coach> getTrophy() {
		return trophy;
	}


	public void setTrophy(Trophy<Coach> trophy) {
		this.trophy = trophy;
	}


	public E_Levels getLevel() {
		return level;
	}


	public void setLevel(E_Levels level) {
		this.level = level;
	}


	public Set<Team> getTeams() {
		return teams;
	}


	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}
	
	// -------------------------------hashCode equals & toString------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(MainTeam, level, teams, trophy);
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
		Coach other = (Coach) obj;
		return Objects.equals(MainTeam, other.MainTeam) && level == other.level && Objects.equals(teams, other.teams)
				&& Objects.equals(trophy, other.trophy);
	}


	@Override
	public String toString() {
		return "Coach [MainTeam=" + MainTeam + ", trophy=" + trophy + ", level=" + level + ", teams=" + teams + "]";
	}
	
	public boolean transferTo(Team team) {
        if (team == null || team.equals(this.MainTeam)) {
            return false; // Cannot transfer to null or the same team
        }

        // Remove coach from the current team if it exists
        if (this.MainTeam != null) {
            this.MainTeam.setCoach(null);
        }

        // Add coach to the new team
        team.setCoach(this);
        this.MainTeam = team;

        return true;
    }
	

}
