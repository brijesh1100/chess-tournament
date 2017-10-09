package com.brijesh1100.tournament;

import java.util.Collections;
import java.util.List;

import com.brijesh1100.tournament.chess.Match;
import com.brijesh1100.tournament.chess.Player;

public abstract class AbstractTournament {

	protected String tournamentName;
	protected LeaderBoard leaderBoard;

	protected List<Player> players;
	protected List<Match> matchPool;

	public List<Match> getMatchPool() {
		return this.matchPool;
	}

	public AbstractTournament(List<Player> players, String name) {
		this.players = players;
		this.tournamentName = name;
		this.setMatchPool(players);
	}

	/**
	 * Get Tournament Name
	 * */
	public String getTournamentName() {
		return tournamentName;
	}

	public void getLeaderBoard() {
		Collections.sort(players);
		leaderBoard = new LeaderBoard();
		leaderBoard.setPlayers(players);
		leaderBoard.disPlay();
	}

	public abstract void setMatchPool(List<Player> players);

	public abstract void startMatch();
}
