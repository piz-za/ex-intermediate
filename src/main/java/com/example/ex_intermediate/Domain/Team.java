package com.example.ex_intermediate.Domain;

/**
 * 野球チームクラス
 */
public class Team {
    private Integer id;
    private String league_name ;
    private String team_name;
    private String headquarters;
    private String inauguration;
    private String history;
    @Override
    public String toString() {
        return "team [id=" + id + ", league_name=" + league_name + ", team_name=" + team_name + ", headquarters="
                + headquarters + ", inauguration=" + inauguration + ", history=" + history + "]";
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }
    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }
    public void setInauguration(String inauguration) {
        this.inauguration = inauguration;
    }
    public void setHistory(String history) {
        this.history = history;
    }
    public Integer getId() {
        return id;
    }
    public String getLeague_name() {
        return league_name;
    }
    public String getTeam_name() {
        return team_name;
    }
    public String getHeadquarters() {
        return headquarters;
    }
    public String getInauguration() {
        return inauguration;
    }
    public String getHistory() {
        return history;
    }

}
