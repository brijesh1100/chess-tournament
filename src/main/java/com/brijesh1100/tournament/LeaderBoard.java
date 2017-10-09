package com.brijesh1100.tournament;

import java.util.List;

import com.brijesh1100.tournament.chess.Player;

public class LeaderBoard {

	private List<Player> players;

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * Display Player LeaderBoard.
	 * */
	public void disPlay() {
		System.out.println("--------------------------- Leader Board ---------------------------");
		System.out.println(String.format("%-10s%-15s%-10s%-10s%-10s%-10s%-10s", "Name",
				"No Of Match", "Won", "Lose", "Draw", "Point", "Rating"));
		for (Player player : players) {
			System.out.println(String.format("%-10s%-15s%-10d%-10s%-10s%-10s%-10s",
					player.getName(), player.getNoOfMatch(), player.getWon(),
					player.getLose(), player.getDraw(), player.getPoint(),
					player.getCurrentRating()));
		}
		System.out.println("--------------------------------------------------------------------");

	}
}
