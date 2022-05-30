package com.example.MyTFE.model.DAO;

import com.example.MyTFE.model.Help;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HelpDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final class HelpRowMapper implements RowMapper<Help> {
        @Override
        public Help mapRow(ResultSet rs, int rowNum) throws SQLException {
            Help help = new Help();
            help.setId_help(rs.getInt("id_help"));
            help.setCategory(rs.getString("category"));
            help.setQuestion(rs.getString("question"));
            help.setReply(rs.getString("reply"));
            return help;
        }

    }

    public List<Help> getAllHelp(){
        return jdbcTemplate.query("select * from help",new HelpDAO.HelpRowMapper());

    }
}
