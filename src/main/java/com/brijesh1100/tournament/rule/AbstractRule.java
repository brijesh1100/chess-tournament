package com.brijesh1100.tournament.rule;

import com.brijesh1100.tournament.chess.Match;
import com.brijesh1100.tournament.chess.Player;



/**
 * This class is responsible to give rating.
 * If Player win rating goes up |^|
 * If player lose rating goes down 
 * If player draw with high rating player rating goes up |^|
 * if player draw with lower rating player rating goes down.
 * when draw with same rating player rating will remain unchanged <-->  
 * If lower rating player will win against strong player then player gain more rating then if player defeat a beginner. 
 * */
public abstract class AbstractRule<T> implements GameRule<Match>{

	@Override
	public void calculateRating(Match match) {
		Player p1 = match.getPlayer();
		Player p2 = match.getOpponent();
		p1.setNoOfMatch(p1.getNoOfMatch() + 1);
		p2.setNoOfMatch(p2.getNoOfMatch() + 1);

		if (match.isMatchDraw()) {
			drawRule(p1, p2);
		} else {
			winnerAndLoserRule(match);
		}
	}

	/**
	 * Formula
	 * Player rating point before the start of the match. 
	 * then winner will get-
	 * winnerPlayerPoint = (WinnerMatchPoint * 50) + (OpponentCurrentRatingBeforeMatch + 50) point more then player own point.
	 * and loser will get-
	 * loserPlayerPoint = (loserMatchPoint * 50) + (winnerCurrentRatingBeforeMatch - 50) point more then player own point.
	 * and
	 * rating = (noOfTotalPoint/noOfMatch)
	 * 
	 * for example if A and B player playing 
	 * Player noOfMatch  win  lose  draw  point  rating
	 * A        0		  0     0     0     0      0
	 * B        0		  0     0     0     0      0
	 * if A won the match the updated leader board will be.
	 * APlayerpoint = (1 * 50)+ (0 +50) = 100
	 * and A Player rating = 100/1 = 100 
	 * and B will get
	 * BPlayerpoint = (0 * 50)+ (0 - 50) = -50
	 * and A Player rating = -50/1 = -50
	 * result would be 
	 * Player noOfMatch  win  lose  draw  point  rating
	 * A        1		  1     0     0     100      100
	 * B        1		  0     1     0     0        -50
	 * 
	 * Similarly this leader point will keep on update as soon as player play with another player.
	 * 
	 * If lower rating player will win against strong player the the rating will go up.
	 * For example if A and C player will play match and C will win the match in this case C player rating will go up.
	 * as A is strong player, A already won 1 match.
	 * let see how it will work.
	 * APlayerpoint = (0 * 50)+ (0 - 50) = -50 and He already has score 100 point in previous match
	 * so AplayerPoint = -50 + 100 = 50 then 
	 * and A Player rating = 50/2 = 25  as He played 2 match with B and C player 
	 * and C will get
	 * BPlayerpoint = (1 * 50)+ (100 + 50) = 200
	 * and C Player rating = 200/1 = 200
	 * now the leader bard will be    
	 * Player   noOfMatch win  lose  draw  point  rating
	 * A        	2		1     1     0     50     25
	 * B        	1		0     1     0     0      -50
	 * C            1       1     0     0     200    200
	 * */
	private void winnerAndLoserRule(Match match) {
		int winnerRatingBeforeMatch = match.getWinner().getCurrentRating();
		int losserRatingBeforMatch = match.getLosser().getCurrentRating();

		int winnerPoint = ((GameRule.WINNER_POINT * 50) + (losserRatingBeforMatch + 50));
		match.getWinner().setPoint(
				match.getWinner().getPoint() + winnerPoint);
		match.getWinner().setCurrentRating(
				(int) Math.ceil(match.getWinner().getPoint()
						/ match.getWinner().getNoOfMatch()));
		match.getWinner().setWon(match.getWinner().getWon() + 1);

		int loserPoint = ((GameRule.LOSER_POINT * 50) + (winnerRatingBeforeMatch - 50));
		match.getLosser().setPoint(
				match.getLosser().getPoint() + loserPoint);
		match.getLosser().setCurrentRating(
				(int) Math.ceil(match.getLosser().getPoint()
						/ match.getWinner().getNoOfMatch()));
		match.getLosser().setLose(match.getLosser().getLose() + 1);
	}

	/**
	 * Formula for draw
	 * Player rating point before the start of the match. 
	 * playerPoint = (DrawPoint * 50) + (OpponentCurrentRatingBeforeMatch + 50) point more then player own point.
	 * rating = (noOfTotalPoint/noOfMatch)
	 * for example if A and B player playing 
	 * Player  noOfMatch win  lose  draw  point  rating
	 * A        0		 0     0     0     0      0
	 * B        0		 0     0     0     0      0
	 * 
	 * Match get Draw
	 * playerPoint = (0.5 * 50) + (0 + 50) = 75
	 * rating = 75/1 = 75
	 * Result 
	 * Player  noOfMatch win  lose  draw  point  rating
	 * A        1		 0     0     1     75      75
	 * B        1		 0     0     1     75      75 
	 * 
	 * Similarly this leader point will keep on update as soon as player play with another player.
	 * */
	private void drawRule(Player p1, Player p2) {
		int p1Point = (int) ((GameRule.DRAW_POINT * 50) + (p2
				.getCurrentRating() + 50));
		p1.setPoint(p1.getPoint() + p1Point);
		p1.setCurrentRating((int) Math.ceil(p1.getPoint()
				/ p1.getNoOfMatch()));
		p1.setDraw(p1.getDraw() + 1);

		int p2Point = (int) ((GameRule.DRAW_POINT * 50) + (p1
				.getCurrentRating() + 50));
		p2.setPoint(p2.getPoint() + p2Point);
		p2.setCurrentRating((int) Math.ceil(p2.getPoint()
				/ p2.getNoOfMatch()));
		p2.setDraw(p2.getDraw() + 1);
	}

	public abstract void pickWinner(T type);
}
