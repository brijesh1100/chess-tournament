package com.brijesh1100.tournament.rule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import com.brijesh1100.tournament.chess.Match;
import com.brijesh1100.tournament.chess.Player;

/**
 * This class is responsible for pick Winner player.
 * */
public class RuleExecutor extends AbstractRule<Match> {

	private Random random = new Random();
	private static RuleExecutor RULE_INSTANCE;
	
	private RuleExecutor() {

	}

	/**
	 * Lazy Singleton Object.
	 * */
	public static RuleExecutor getInstance() {
		if (RULE_INSTANCE == null) {
			synchronized (RuleExecutor.class) {
				if (RULE_INSTANCE == null) {
					RULE_INSTANCE = new RuleExecutor();
				}
			}
		}
		return RULE_INSTANCE;
	}

	/**
	 * @param match  {@link Match}
	 * This method will randomly select the winner player and calculate Rating for Player.
	 * */
	@Override
	public void pickWinner(Match match) {
		Set<Player> list = new HashSet<Player>();
		list.add(match.getPlayer());
		list.add(match.getOpponent());
		List<Integer> randomSet = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			int num = ThreadLocalRandom.current().nextInt(match.getDRAW_PROBABILITY_RATE());
			randomSet.add(num);
		}
		int size = new HashSet<>(randomSet).size();
		if (list.size() != size) {
			match.setMatchDraw(true);
			RULE_INSTANCE.calculateRating(match);
		} else {
			Player winner = new ArrayList<>(list).get(random.nextInt(list
					.size()));
			match.setWinner(winner);
			match.setLosser();
			RULE_INSTANCE.calculateRating(match);
		}
		
	}

	

}
