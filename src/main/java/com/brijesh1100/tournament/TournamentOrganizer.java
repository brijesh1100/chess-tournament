package com.brijesh1100.tournament;

import java.util.List;

/**
 * {@link} TournamentOrganizer is Generic Organizer.
 *  
 * */
public interface TournamentOrganizer<T, E> {

	public List<E> register();
	public void start(T tournamet);
}
