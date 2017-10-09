package com.brijesh1100.tournament.chess;

public class Player implements Comparable<Player> {

	private String name;
	private int noOfMatch;
	private int won;
	private int lose;
	private int draw;
	private long point;
	private int currentRating;

	public Player(String name) {
		this.name = name;
		this.noOfMatch = 0;
		this.won = 0;
		this.lose = 0;
		this.point = 0;
		this.currentRating = 0;
	}
	
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfMatch() {
		return noOfMatch;
	}

	public void setNoOfMatch(int noOfMatch) {
		this.noOfMatch = noOfMatch;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public long getPoint() {
		return point;
	}

	public void setPoint(long point) {
		this.point = point;
	}

	public int getCurrentRating() {
		return currentRating;
	}

	public void setCurrentRating(int currentRating) {
		this.currentRating = currentRating;
	}

	/**
	 * Natural sort by currentRating.
	 * */
	@Override
	public int compareTo(Player player) {
		if (this.currentRating > player.currentRating) {
			return -1;
		} else if (this.currentRating < player.currentRating) {
			return 1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentRating;
		result = prime * result + lose;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + noOfMatch;
		result = prime * result + (int) (point ^ (point >>> 32));
		result = prime * result + won;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (currentRating != other.currentRating)
			return false;
		if (lose != other.lose)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (noOfMatch != other.noOfMatch)
			return false;
		if (point != other.point)
			return false;
		if (won != other.won)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", noOfMatch=" + noOfMatch + ", won="
				+ won + ", lose=" + lose + ", draw=" + draw + ", point="
				+ point + ", currentRating=" + currentRating + "]";
	}
	
	
}
