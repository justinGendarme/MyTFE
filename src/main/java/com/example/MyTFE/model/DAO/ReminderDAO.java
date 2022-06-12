package com.example.MyTFE.model.DAO;

import com.example.MyTFE.model.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReminderDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SimpleJdbcInsert simpleJdbcInsert;

    public List <Reminder> getAllReminderFromUser(int id){
        return jdbcTemplate.query("SELECT * FROM Reminder WHERE id_diabetic=?",new ReminderRowMapper(),id);
    }


    private final class ReminderRowMapper implements RowMapper<Reminder> {
        @Override
        public Reminder mapRow(ResultSet rs, int rowNum) throws SQLException {
            Reminder rmd = new Reminder();
            rmd.setId_reminder(rs.getInt("id_reminder"));
            rmd.setId_doctor(rs.getInt("id_doctor"));
            rmd.setId_diabetic(rs.getInt("id_diabetic"));
            rmd.setDate(rs.getDate("date"));
            rmd.setDescription(rs.getString("description"));
            return rmd;
        }

    }
}
