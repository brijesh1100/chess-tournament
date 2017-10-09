package com.brijesh1100.tournament.rule;

public interface GameRule<T> {

	public static final int WINNER_POINT = 1;
	public static final float DRAW_POINT = 0.5f;
	public static final int LOSER_POINT = 0;
	
	public void calculateRating(T type);
	
}
