package application.core.vote.dao;

import application.model.Vote;
import application.model.VoteId;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public interface VoteDao {
    /**
     * Given an VoteId, find it's respective vote.
     *
     * @param id Id of the desired id.
     * @return The vote of the given id.
     */
    Vote findById(VoteId id);

    Integer countVotesByProcessMeasure(VoteId voteId);

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
     * @throws HibernateException Error updating an existing vote.
     */
    void update(Vote vote) throws HibernateException;

    /**
     * Delete a new vote.
     *
     * @throws HibernateException Error deleting an existing vote.
     */
    void delete(Vote vote) throws HibernateException;
}
