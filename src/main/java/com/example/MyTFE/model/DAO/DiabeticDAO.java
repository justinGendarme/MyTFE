package com.example.MyTFE.model.DAO;

import com.example.MyTFE.model.Diabetic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DiabeticDAO {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("diabetic")
                .usingGeneratedKeyColumns("id_diabetic");
    }

    public Diabetic getDiabById(int id){
        return jdbcTemplate.queryForObject("select * from Diabetic where id_diabetic=?", new Object[]{id}, new DiabeticRowMapper());
    }



    private final class DiabeticRowMapper implements RowMapper<Diabetic> {
        @Override
        public Diabetic mapRow(ResultSet rs, int rowNum) throws SQLException{
            Diabetic diabetic = new Diabetic();
            diabetic.setId_diabetic(rs.getInt("id_diabetic"));
            diabetic.setName(rs.getString("name"));
            diabetic.setFirstname(rs.getString("firstname"));
            diabetic.setBirthdate(rs.getDate("birthdate"));
            diabetic.setMail(rs.getString("mail"));
            diabetic.setPassword(rs.getString("password"));
            diabetic.setPhone(rs.getString("phone"));
            diabetic.setEmergencyContact(rs.getString("emergencyContact"));
            diabetic.setAddress(rs.getString("address"));
            return diabetic;
        }

    }



}
