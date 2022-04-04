package vttp.paf.day11.bgg.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Game {
    private int gid;
    private String name;
    private int year;
    private int ranking;
    private int usersRated;
    private String url;
    private String image;

    public int getGid() {
        return this.gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRanking() {
        return this.ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getUsersRated() {
        return this.usersRated;
    }

    public void setUsersRated(int usersRated) {
        this.usersRated = usersRated;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static Game createGame(SqlRowSet result) {
        Game game = new Game();
        game.setGid(result.getInt("gid"));
        game.setName(result.getString("name"));
        game.setYear(result.getInt("year"));
        game.setRanking(result.getInt("ranking"));
        game.setUsersRated(result.getInt("users_rated"));
        game.setUrl(result.getString("url"));
        game.setImage(result.getString("image"));
        return game;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("gid", getGid())
                .add("name", getName())
                .add("year", getYear())
                .add("ranking", getRanking())
                .add("usersRated", getUsersRated())
                .add("url", getUrl())
                .add("image", getImage())
                .build();
    }
}
