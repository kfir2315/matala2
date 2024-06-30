package init;

import java.io.*;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import core.Found;
import core.Match;
import core.MatchResult;
import core.Person;
import core.Player;
import core.Sponsor;
import core.Team;
import core.Trophy;
import core.Coach;
import core.Customer;
import utils.Country;
import utils.E_Levels;
import utils.E_Position;
import utils.E_Trophy;
import utils.Role;
import utils.Stadium;

/**
 * This JEuroTournament object represents the class system
 * @author Fadi Yassin
 * @author Amik  - 2024 
 
 */
public class JEuroTournament {
    // ---------------------the class parameters -------------------------
	// -------------------------------Class Members------------------------------
	private static JEuroTournament instance;
	private HashMap<String, Player> players; // All the Players
	private HashMap<String, Coach> coaches; // All the Coaches
	private HashMap<String, Customer> customers; // All Customers
	private HashMap<String, Sponsor> sponsors; // All Sopnsores
	private HashMap<String, Team> teams; // All teams
	private HashMap<String, Match> matches; // all matches
	private HashMap<String,MatchResult> matchResults; // all matches results
	private HashSet<Trophy> trophies;

    // --------------------- Constructors -------------------------
    /**
     * Constructor
     * Perform initialization for related data structures
     */
    public JEuroTournament() {
        super();
        teams = new HashMap<>();  //done
        matches = new HashMap<>(); //done
        players = new HashMap<>(); // done
        coaches = new HashMap<>(); // done
		customers= new HashMap<>(); // done
		sponsors = new HashMap<>(); //done
		matchResults = new HashMap<>();
		trophies = new HashSet<>();
				
    }

    // ---------------------- DB Methods -----------------------------

    public static JEuroTournament getInstance() {
    	if (instance == null) 
			instance = new JEuroTournament();
 		return instance;
 	}

 	public HashMap<String, Player> getPlayers() {
 		return players;
 	}

 	public HashMap<String, Coach> getCoaches() {
 		return coaches;
 	}

 	public HashMap<String, Customer> getCustomers() {
 		return customers;
 	}

 	public HashMap<String, Sponsor> getsponsors() {
 		return sponsors;
 	}

 	public HashMap<String, Team> getTeams() {
 		return teams;
 	}

 	public HashMap<String, Match> getMatches() {
 		return matches;
 	}

 	public HashMap<String,MatchResult> getMatchResults() {
 		return matchResults;
 	}

 	public HashSet<Trophy> getTrophies() {
 		return trophies;
 	}
    /**
     * the method creates and add new team to the system
     * IFF the team does not exist.
     * @param tId
     * @param tName
     * @param represents
     * @param fansCount
     * @param finalStage
     * @return if manage to add
     */
 	public boolean addPlayer(String pId, String fullName, int age, String nation, int pNum,E_Position position, int fansCount,
			Team currentTeam) {
 		if(pId == null || fullName == null || age <=0 || nation == null || pNum <=0
 				|| position==null || fansCount <=0 ||  currentTeam ==null) return false;
 		Player player = new Player(pId);
 		if(players.containsKey(player.getpId())) {
 			return false;
 		}
 		Player toPlayer = new Player(pId,fullName,age,nation,pNum,position,fansCount,currentTeam);
 		players.put(pId, toPlayer);
 		return true;
 	      
    }
    /**
     * the method creates and add new team to the system
     * IFF the team does not exist.
     * @param tId
     * @param tName
     * @param represents
     * @param fansCount
     * @param finalStage
     * @return if manage to add
     */
 	public boolean addCoach(String pId, String fullName, int age, String nation, Team currentTeam, E_Levels level) {
 		if(pId == null || fullName == null || age <=0 || nation == null
 				|| level==null ||  currentTeam ==null) return false;
 		Coach coach = new Coach(pId);
 		if(coaches.containsKey(coach.getpId())) {
 			return false;
 		}
 		Coach toCoach = new Coach(pId,fullName,age,nation,currentTeam,level);
 		coaches.put(pId, toCoach);
 		return true;
 	      
    }
 	 /**
     * the method creates and add new team to the system
     * IFF the team does not exist.
     * @param tId
     * @param tName
     * @param represents
     * @param fansCount
     * @param finalStage
     * @return if manage to add
     */
 	public boolean addCustomer(String pId, String fullName, int age, String nation, URL email, E_Levels level, Team favoriteTeam) {
 		if(pId == null || fullName == null || age <=0 || nation == null
 				|| email==null|| level==null ||  favoriteTeam ==null) return false;
 		Customer customer = new Customer(pId);
 		if(customers.containsKey(customer.getpId())) {
 			return false;
 		}
 		Customer toCostumer = new Customer(pId,fullName,age,nation,email,level,favoriteTeam);
 		customers.put(pId, toCostumer);
 		return true;
 	      
    }
	 /**
     * the method creates and add new team to the system
     * IFF the team does not exist.
     * @param tId
     * @param tName
     * @param represents
     * @param fansCount
     * @param finalStage
     * @return if manage to add
     */
 	public boolean addSponsor(String pId, String fullName, int age, String nation, String nickName) {
 		if(pId == null || fullName == null || age <=0 || nation == null
 				|| nickName==null) return false;
 		Sponsor sponsor = new Sponsor(pId);
 		if(sponsors.containsKey(sponsor.getNickName())) {
 			return false;
 		}
 		Sponsor tosponsor = new Sponsor(pId,fullName,age,nation,nickName);
 		sponsors.put(pId, tosponsor);
 		return true;
 	      
    }
    /**
     * the method creates and add new team to the system
     * IFF the team does not exist.
     * @param tId
     * @param tName
     * @param represents
     * @param fansCount
     * @param finalStage
     * @return if manage to add
     */
    public boolean addTeam(String tNumber, String tName, int fansCount,String represents) {
    	if(tNumber == null || tName == null || represents == null
 				|| fansCount <=0 ) return false;
 		Team team = new Team(tNumber);
 		if(teams.containsKey(team.gettNumber())) {
 			return false;
 		}
 		Team toTeam = new Team(tNumber,tName,fansCount,represents);
 		teams.put(tNumber, toTeam);
 		return true;
	
    } // ~ END OF addTeam

 

	/**
     * adds a match to the system IFF it does not exist
     * @param matchID
     * @param date
     * @param stadium
     * @return true if managed to add the match
     */
    public boolean addMatch(String matchID, Date date, String stadium, long totalTickets, MatchResult MatchR) {
    	if(matchID == null || date == null || stadium == null || totalTickets <=0 ) return false;
 		Match match = new Match(matchID);
 		if(matches.containsKey(match.getmId())) {
 			return false;
 		}
 		Match toMatch = new Match(matchID,date,stadium,totalTickets,MatchR);
 		matches.put(matchID, toMatch);
 		return true;

    } // ~ END OF addMatch
    
	/**
     * adds a match to the system IFF it does not exist
     * @param matchID
     * @param date
     * @param stadium
     * @return true if managed to add the match
     */
    public boolean addMatchResult(Team homeTeam, Team awayTeam, String matchId,  int homeTeamScore,
			int awayTeamScore, int totalTime,boolean penaltyEnd) {
    	if(homeTeam == null || awayTeam == null || matchId == null || homeTeamScore <=0 || awayTeamScore <=0 || totalTime<0) return false;
 		MatchResult matchResult = new MatchResult(homeTeam,awayTeam,matchId,totalTime,penaltyEnd,homeTeamScore,awayTeamScore);
 	
 		if(matchResults.containsKey(matchId)) {
 			return false;
 		}	
 		
 		matchResults.put(matchId,matchResult);
 		return true;

    } // ~ END OF addMatch
	/**
     * adds a match to the system IFF it does not exist
     * @param matchID
     * @param date
     * @param stadium
     * @return true if managed to add the match
     */
    public <T> boolean addTrophy(E_Trophy trophy, T owner, Date trophyWinningDate) {
		//TODO
    	if(trophy == null || owner == null || trophyWinningDate == null) return false;
    	Trophy<T> trophys = new Trophy<T>(trophy,owner,trophyWinningDate);
 		if(trophies.contains(trophys)) {
 			return false;
 		}
 		trophies.add(trophys);
 		return true;
	}// ~ END OF addTrophy

  

    // ===================== Queries =================================== 

	/**
     * adds a Team to Coach
     * @param TeamID
     * @param CoachID
     * @return true if managed to add the Team to coach
     * 
     */
    public boolean addTeamToCoach(String teamId, String coachId) {
        if (teamId == null || coachId == null) return false;

        Team team = teams.get(teamId);
        Coach coach = coaches.get(coachId);

        if (team == null || coach == null) return false;

        if (coach.getTeams() == null) {
            coach.setTeams(new HashSet<>());
        }

        if (coach.getTeams().contains(team)) {
            return false;
        }

        coach.getTeams().add(team);
        team.setCoach(coach);
        return true;
    }

    /**
     * adds a Match to Player
     * @param MatchId
     * @param PlayerId
     * @return true if managed to add the Match to Player
     * 
     */
    public boolean addMatchToPlayer(String matchId, String playerId) {
        // Initialize players and matches maps if they are null
        if (players == null) {
            players = new HashMap<>();
        }
        if (matches == null) {
            matches = new HashMap<>();
        }

        // Retrieve the Player object
        Player player = players.get(playerId);
        if (player == null) {
            System.out.println("Player with ID " + playerId + " not found.");
            return false;
        }

        // Retrieve the Match object
        Match match = matches.get(matchId);
        if (match == null) {
            System.out.println("Match with ID " + matchId + " not found.");
            return false;
        }

        // Check if the match is already associated with the player
        Set<Match> playerMatches = player.getMatches();
        if (playerMatches.contains(match)) {
            System.out.println("Match is already associated with the player.");
            return false;
        }

        // Add the match to the player's set of matches
        playerMatches.add(match);

        // Add the player to the match's set of players
        Set<Player> matchPlayers = match.getPlayers();
        matchPlayers.add(player);

        System.out.println("Match " + matchId + " added to player " + playerId + ".");
        return true;
    }

    /**
     * adds a Team to Sponsor
     * @param teamId
     * @param nickName
     * @return true if managed to add the Team to Sponsor
     * 
     */
    public boolean addTeamToSponsor(String teamId, String pId) {
  
    }
    /**
     * adds a Player to Team
     * @param teamId
     * @param PlayerId
     * @return true if managed to add the Player to Team
     * 
     */
    public boolean addPlayerToTeam(String teamId, String playerId) {
 
    }
    /**
     * adds a Match to Team
     * @param teamId
     * @param MatchId
     * @return true if managed to add the Match to Team
     * 
     */
    public boolean addMatchToTeam(String matchId, String teamId) {
    
    }
    /**
     * adds a Costumer to match
     * @param costumerId
     * @param matchId
     * @return true if managed to add the Costumer to match
     * 
     */
    public boolean addCustomerToMatch(String customerId, String matchId) {
        if (customerId == null || matchId == null) return false;

        Customer customer = customers.get(customerId);
        Match match = matches.get(matchId);

        if (customer == null || match == null) return false;

        Stadium stadium = match.getTookPlace();
        if (stadium == null) return false;

        int currentCustomerCount = match.getCustomers() == null ? 0 : match.getCustomers().size();
        if (currentCustomerCount >= stadium.getCapacity()) return false;

        if (match.getCustomers() == null) {
            match.setCustomers(new HashSet<>());
        }

        if (customer.getMatches() == null) {
            customer.setMatches(new HashSet<>());
        }

        if (!match.getCustomers().add(customer)) {
            return false; // Customer is already in the match
        }

        customer.getMatches().add(match);
        return true;
    }
	/**
	 * This query returns the most favored team. 
	 * Most favored team is the team that has the highest number of customers 
	 * that the team is their favorite team.
	 * 
	 * @return team object if found, null otherwise
	 */
	public Team getTheMostFavoredTeam() {
		//TODO

    }
	

	/**
	 * This query returns the all best customers. 
	 * "beset customer" that had level of PROFESSIONAL and from UKRAINE.
	 * 
	 * @return array of customers if players were found, empty list otherwise
	 */
	public Collection<Customer> getTheBesetCustomer() {
		//TODO

	}
	/**
	 * This query returns the Match with the high number of crowd. 
	 * from all the matches return the match with high number of crowd
	 * 
	 * @return match object if found, null otherwise
	 */
	public Match getTheBestHomeMatch() {
		//TODO
	
	}
	/**
	 * This query returns the Player that has Played the most games'
	 *  if there more than one return the fist one .
	 * @return Player if found. null otherwise
	 */
	public Player getMostActivePlayer() {
		//TODO

	}
	/**
	 * This query returns the Match with maximum number of sold out Tickets.
	 * and ends with penalty kicks 
	 *  if there more than one return the fist one .
	 * @return Matc if found. null otherwise
	 */
	public Match getMatchWithMaxSoldOutTickets() {

	}

	/**
	 * This query returns Sponsors that supports Germany
	 * @return Collection of Sponsors if found. empty otherwise
	 */
	public Collection<Sponsor> getSponsorsOfGermany() {
		//TODO

	}
	/**
	 * This query returns the entity that has won the most trophies.
	 * @return object if found. null otherwise
	 */
	public Object getEntityWithMostTrophies() {
		//TODO
	}
	/**
	 * This query returns all the Teams of the "Best Home Team" 
	 * "Best Home Team" is the team with the highest homeTeamScore winnings
	 * 
	 * @return array of players if players were found, empty list otherwise  
	 */
	public Collection<Team> getTeamsBestHomeScore() {
		//TODO

	}
	/**
	 * This query returns the most popular position. 
	 * Most popular position is the type that belongs to the highest number of players.
	 * 
	 * @return position object if found, null otherwise
	 */
	public E_Position getTheMostPopularPosition() {
		//TODO
	
	} 


}
