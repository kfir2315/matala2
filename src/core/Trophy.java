package core;

import java.util.Date;
import java.util.Objects;

import utils.E_Trophy;

public class Trophy<T> implements Comparable<Trophy<T>> {
	
	private E_Trophy trophy;
	private T owner;
	private Date trophyWinningDate;
	private Coach coach;
	private Player player;
	private Team team;
	
	public Trophy(E_Trophy trophy, T owner, Date trophyWinningDate, Coach coach, Player player, Team team) {
		super();
		this.trophy = trophy;
		this.owner = owner;
		this.trophyWinningDate = trophyWinningDate;
		this.coach = coach;
		this.player = player;
		this.team = team;
	}
	
	
	

	public Trophy(E_Trophy trophy, T owner, Date trophyWinningDate) {
		super();
		this.trophy = trophy;
		this.owner = owner;
		this.trophyWinningDate = trophyWinningDate;
	}




	public E_Trophy getTrophy() {
		return trophy;
	}

	public void setTrophy(E_Trophy trophy) {
		this.trophy = trophy;
	}

	public T getOwner() {
		return owner;
	}

	public void setOwner(T owner) {
		this.owner = owner;
	}

	public Date getTrophyWinningDate() {
		return trophyWinningDate;
	}

	public void setTrophyWinningDate(Date trophyWinningDate) {
		this.trophyWinningDate = trophyWinningDate;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coach, owner, player, team, trophy, trophyWinningDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trophy other = (Trophy) obj;
		return Objects.equals(coach, other.coach) && Objects.equals(owner, other.owner)
				&& Objects.equals(player, other.player) && Objects.equals(team, other.team) && trophy == other.trophy
				&& Objects.equals(trophyWinningDate, other.trophyWinningDate);
	}

	@Override
	public String toString() {
		return "Trophy [trophy=" + trophy + ", owner=" + owner + ", trophyWinningDate=" + trophyWinningDate + ", coach="
				+ coach + ", player=" + player + ", team=" + team + "]";
	}
	
	
	@Override
	public int compareTo(Trophy<T> o) {
		return this.trophyWinningDate.compareTo(o.getTrophyWinningDate());
	}
	

}
