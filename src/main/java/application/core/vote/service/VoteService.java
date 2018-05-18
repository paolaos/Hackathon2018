package application.core.vote.service;

import application.model.Vote;
import application.model.VoteId;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public interface VoteService {
    /**
     * Given an VoteId, find it's vote.
     *
     * @param id Id of the desired vote.
     * @return The vote of the given id.
     */
    Vote findById(VoteId id);

    /**
     * Return all votes from our database.
     *
     * @return List of votes.
     */
    List<Vote> getAllVotes();

    /**
     * Insert a new vote.
     *
     * @throws HibernateException Error inserting a new vote.
     */
    void insert(Vote vote) throws HibernateException;

    /**
     * Update a new vote.
     *
     * @throws HibernateException Error updating a new vote.
     */
    void update(Vote vote) throws HibernateException;

    /**
     * Delete a new vote.
     *
     * @throws HibernateException Error deleting a new vote.
     */
    void delete(Vote vote) throws HibernateException;
}
