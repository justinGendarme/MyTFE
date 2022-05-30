package com.example.MyTFE.model.DAO;

import com.example.MyTFE.model.Injection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class InjectionDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final class InjectionRowMapper implements RowMapper<Injection> {
        @Override
        public Injection mapRow(ResultSet rs, int rowNum) throws SQLException {
            Injection inj = new Injection();
            inj.setId_injection(rs.getInt("id_injection"));
            inj.setId_diabetic(rs.getInt("id_diabetic"));
            inj.setDate(rs.getDate("date"));
            inj.setDay(rs.getString("day"));
            inj.setWakeupTest(rs.getInt("wakeupTest"));
            inj.setMorningDose(rs.getString("morningDose"));
            inj.setMorningTest(rs.getInt("morningTest"));
            inj.setMiddayTest(rs.getInt(rs.getInt("middayTest")));
            inj.setMiddayDose(rs.getString("middayDose"));
            inj.setAfternoonTest(rs.getInt("afternoonTest"));
            inj.setSupperTest(rs.getInt("supperTest"));
            inj.setSupperDose(rs.getString("supperDose"));
            inj.setEveningTest(rs.getInt("eveningTest"));
            inj.setSleepTest(rs.getInt("sleepTest"));
            inj.setSleepDose(rs.getString("sleepDose"));
            inj.setNightTest(rs.getInt("nightTest"));
            inj.setComment(rs.getString("comment"));
            return inj;
        }

    }
}
