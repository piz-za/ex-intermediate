package com.example.ex_intermediate.Repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.ex_intermediate.Domain.Team;

/**
 * 野球チームのリポジトリクラス
 */
@Repository
public class teamRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setLeague_name(rs.getString("league_name"));
        team.setTeam_name(rs.getString("team_name"));
        team.setHeadquarters(rs.getString("headquarters"));
        team.setInauguration(rs.getString("inauguration"));
        team.setHistory(rs.getString("history"));

        return team;
    };

    /**
     * 野球チームの全件検索
     * 
     * @return 野球チームの一覧
     */
    public List<Team> findAll() {
        String sql = "SELECT id,league_name,team_name,headquarters,"
                + " inauguration,history FROM teams"
                + " ORDER BY inauguration";
        List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
        return teamList;
    }

    /**
     * 野球チームの一件検索
     * @param id 野球チームのid
     * @return 野球チームの詳細情報
     */
    public Team load(Integer id) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);
        String sql = "SELECT id,league_name,team_name,headquarters,"
                + "inauguration,history FROM teams"
                + " WHERE id = :id";
        Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
        return team;
    }

}
