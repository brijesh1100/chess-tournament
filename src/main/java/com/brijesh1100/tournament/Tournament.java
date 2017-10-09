package com.brijesh1100.tournament;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.brijesh1100.tournament.chess.ChessTournament;
import com.brijesh1100.tournament.chess.Match;
import com.brijesh1100.tournament.chess.Player;

/**
 * {@link}TournamentOrganizer will create new {@link Tournament} as a ${link
 * ChessTournament} {@link Player} Entity will be register for this
 * {@link Tournament} {@link Tournament} class is a entry point to run the
 * program.
 * */
public class Tournament implements TournamentOrganizer<ChessTournament, Player> {

	private Set<Player> playersDetail;

	public Set<Player> getPlayersDetail() {
		return playersDetail;
	}

	/**
	 * {@link}TournamentOrganizer will create new {@link}Tournament and He
	 * will register Player for {@link} ChessTournament and start the Game.
	 * 
	 * {@value tournamentName} tournamentName Name of the tournament
	 * {@value noOfAudience} noOfAudience Number of Audience in tournament.
	 * Default {@value DRAW_PROBABILITY_RATE} DRAW_PROBABILITY_RATE = 10 if you increase probability rate of
	 * DRAW_PROBABILITY_RATE, Chance of draw match rate will decrease.
	 * @see Match
	 * 
	 * To see the result variation run this program multiple time.
	 * */
	public static void main(String[] args) {
		TournamentOrganizer<ChessTournament, Player> organizer = new Tournament();
		String tournamentName = "Chess League";
		int noOfAudience = 1300;
		int DRAW_PROBABILITY_RATE = 10;
		ChessTournament chessTournament = new ChessTournament(
				organizer.register(), tournamentName, noOfAudience,
				DRAW_PROBABILITY_RATE);
		organizer.start(chessTournament);

	}

	@Override
	public void start(ChessTournament tournamet) {
		tournamet.startMatch();
		System.out
				.println("Tournament Name : " + tournamet.getTournamentName());
		System.out.println("Number Of Audience : "
				+ tournamet.getNoOfAudience());
		System.out.println("Total Game: " + tournamet.getTotalGame());
		tournamet.getLeaderBoard();
	}

	/**
	 * Player Registration it can be dynamic also can read from File you can add
	 * here more player for tournament
	 * */
	@Override
	public List<Player> register() {
		this.playersDetail = new HashSet<Player>();
		Player p1 = new Player("Praveen");
		Player p2 = new Player("Narendra");
		Player p3 = new Player("Prakhar");
		Player p4 = new Player("Venu");
		Player p5 = new Player("Yaswant");
		Player p6 = new Player("Prashant");
		Player p7 = new Player("Brijesh");
		Player p8 = new Player("Vikrant");
		Player p9 = new Player("Ram");
		Player p10 = new Player("Sumukh");
		this.playersDetail.add(p1);
		this.playersDetail.add(p2);
		this.playersDetail.add(p3);
		this.playersDetail.add(p4);
		this.playersDetail.add(p5);
		this.playersDetail.add(p6);
		this.playersDetail.add(p7);
		this.playersDetail.add(p8);
		this.playersDetail.add(p9);
		this.playersDetail.add(p10);
		return new ArrayList<Player>(this.getPlayersDetail());
	}

}
