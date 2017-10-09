package com.brijesh1100.tournament.chess;

import java.util.Date;

public class Match {

	private Player player;
	private Player opponent;

	/**
	 * Default DRAW_PROBABILITY_RATE = 10 if you increase probability rate of
	 * DRAW_PROBABILITY_RATE, Chance of draw match rate will decrease.
	 * 
	 * */
	private int DRAW_PROBABILITY_RATE = 10;

	public int getDRAW_PROBABILITY_RATE() {
		return DRAW_PROBABILITY_RATE;
	}

	public void setDRAW_PROBABILITY_RATE(int dRAW_PROBABILITY_RATE) {
		DRAW_PROBABILITY_RATE = dRAW_PROBABILITY_RATE;
	}

	private Date matchDate = new Date();

	private String location;

	private Player winner;
	private Player losser;

	public Player getLosser() {
		return losser;
	}

	public void setLosser() {
		if (this.player.equals(this.winner)) {
			this.losser = this.opponent;
		} else {
			this.losser = this.player;
		}
	}

	private boolean isMatchDraw = false;

	public boolean isMatchDraw() {
		return isMatchDraw;
	}

	public void setMatchDraw(boolean isMatchDraw) {
		this.isMatchDraw = isMatchDraw;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public Date getMatchDate() {
		return matchDate;
	}
}
