package vttp.paf.day11.bgg.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Comment {
    private String commentId;
    private String user;
    private int rating;
    private String commentText;
    private int gid;

    public String getCommentId() {
        return this.commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCommentText() {
        return this.commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getGid() {
        return this.gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public static Comment createComment(SqlRowSet result) {
        Comment comment = new Comment();
        comment.setCommentId(result.getString("c_id"));
        comment.setUser(result.getString("user"));
        comment.setRating(result.getInt("rating"));
        comment.setCommentText(result.getString("c_text"));
        comment.setGid(result.getInt("gid"));
        return comment;
    }
}
