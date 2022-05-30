package com.example.MyTFE.model.DAO;

import com.example.MyTFE.model.Reminder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ReminderDAO {
    private JdbcTemplate jdbcTemplate;

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
