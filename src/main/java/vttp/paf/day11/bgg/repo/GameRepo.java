package vttp.paf.day11.bgg.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import static vttp.paf.day11.bgg.repo.Queries.*;

import vttp.paf.day11.bgg.model.Comment;
import vttp.paf.day11.bgg.model.Game;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class GameRepo {

    @Autowired
    private JdbcTemplate template;
    /*
     * spring automatically uses the vars from application.properties to make
     * connection to DB
     */

    public Optional<Game> getGamebyGID(int queryGID) {
        final SqlRowSet result = template.queryForRowSet(
                SQL_SELECT_GAME_BY_GID, queryGID);
        // NEVER concatenate SQL requests. SQL injection!!
        // use ? in SQL statements instead

        if (!result.next()) {
            // pointer starts before first element retrieved
            return Optional.empty();
        }
        return Optional.of(Game.createGame(result));
    }

    public List<Comment> getCommentsByGID(int gid) {
        return getCommentsByGID(gid, Integer.MAX_VALUE, 0);
    }

    public List<Comment> getCommentsByGID(int gid, int limit, int offset) {
        final List<Comment> comments = new LinkedList<>();
        final SqlRowSet result = template.queryForRowSet(SQL_SELECT_COMMENT, gid, limit, offset); // returns a table

        while (result.next()) {
            Comment comment = Comment.createComment(result);
            comments.add(comment);
        }
        return comments;
    }

}
