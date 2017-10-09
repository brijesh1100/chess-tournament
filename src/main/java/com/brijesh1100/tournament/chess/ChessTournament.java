package com.brijesh1100.tournament.chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.brijesh1100.tournament.AbstractTournament;
import com.brijesh1100.tournament.rule.RuleExecutor;

public class ChessTournament extends AbstractTournament{

	private int noOfAudience;
	private int DRAW_PROBABILITY_RATE;

	/**
	 * @param players  list of register player
	 * @param tournamentName Name of Tournament
	 * @param noOfAudience Number of Audience who come to watching a match.
	 * @param dRAW_PROBABILITY_RATE by default 10 {@link Match}
	 * Default DRAW_PROBABILITY_RATE = 10 if you increase probability rate of
	 * DRAW_PROBABILITY_RATE, Chance of draw match rate will decrease.
	 * */
	public ChessTournament(List<Player> players, String tournamentName,
			int noOfAudience, int dRAW_PROBABILITY_RATE) {
		super(players, tournamentName);
		this.noOfAudience = noOfAudience;
		this.DRAW_PROBABILITY_RATE = dRAW_PROBABILITY_RATE;
	}

	/**
	 * It will give you no of total possible game. 
	 * formula totalGame = n(n-1)/2 where n is no of player
	 * */
	public int getTotalGame() {
		int totalPlayer = players.size();
		int totalGame = (totalPlayer * (totalPlayer - 1)) / 2;
		return totalGame;
	}

	@Override
	public void startMatch() {
		for (Match match : this.matchPool) {
			System.out.println(match.getPlayer().getName() + " vs "
					+ match.getOpponent().getName());
			RuleExecutor.getInstance().pickWinner(match);
			if (match.isMatchDraw()) {
				System.out.println("Match draw" + "\n");
			} else {
				System.out.println("Winner: " + match.getWinner());
				System.out.println("Loser: " + match.getLosser());
				System.out.println("\n");
			}
		}
	}

	/**
	 * This method define what are the possible combination needed to organize match for two player
	 * Constraint: One player only can play once to other player.
	 * Suppose if n=5 (number of player), so each player play 4 match max, default (m = n-1) (m is no of match per player) 
	 * @param players, who's going to play in this tournament.
	 * */
	@Override
	public void setMatchPool(List<Player> players) {
		List<Match> matchs = new ArrayList<Match>();
		for (int i = 0; i < players.size(); i++) {
			for (int j = i + 1; j < players.size(); j++) {
				Match match = new Match();
				if (this.DRAW_PROBABILITY_RATE >= match
						.getDRAW_PROBABILITY_RATE()) {
					match.setDRAW_PROBABILITY_RATE(this.DRAW_PROBABILITY_RATE);
				}
				match.setPlayer(players.get(i));
				match.setOpponent(players.get(j));
				matchs.add(match);
			}
		}
		Collections.shuffle(matchs);
		this.matchPool = matchs;
	}

	public int getNoOfAudience() {
		return noOfAudience;
	}

	public void setNoOfAudience(int noOfAudience) {
		this.noOfAudience = noOfAudience;
	}
	
}
