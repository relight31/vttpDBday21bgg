package vttp.paf.day11.bgg.repo;

public interface Queries {
    public static final String SQL_SELECT_GAME_BY_GID = "select * from game where gid = ?";
    // ? marks are numbered left to right starting from 1

    public static final String SQL_SELECT_COMMENT = "select * from comment where gid = ? limit ? offset ?";
}
