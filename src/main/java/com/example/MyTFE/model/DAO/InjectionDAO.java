package com.example.MyTFE.model.DAO;

import com.example.MyTFE.model.Injection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InjectionDAO {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public SimpleJdbcInsert simpleJdbcInsert;


    public void addInj (Injection inj)
    {
        String sql="INSERT INTO Injection (id_diabetic, date, day, wakeupTest, morningDose, morningTest, middayTest, middayDose, afternoonTest, supperTest, supperDose, eveningTest, sleepTest, sleepDose, nightTest,comment) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                inj.getId_diabetic(),inj.getDate(), inj.getDay(),inj.getWakeupTest(), inj.getMorningDose(),inj.getMorningTest(), inj.getMiddayTest(),inj.getMiddayDose(),inj.getAfternoonTest(), inj.getSupperTest(), inj.getSupperDose(),inj.getEveningTest(),inj.getSleepTest(), inj.getSleepDose(), inj.getNightTest(), inj.getComment());
    }

    public void editInj(Injection inj,int idInj)
    {
        String sql="UPDATE Injection SET id_injection = ?, id_diabetic = ?, date = ?, day = ?, wakeupTest = ?, morningDose = ?, morningTest = ?, middayTest = ?, middayDose = ?,afternoonTest = ?, supperTest = ?, supperDose = ?, eveningTest = ?, sleepTest = ?, sleepDose = ?, nightTest = ?,comment = ? WHERE id_injection = ?)";
        jdbcTemplate.update(sql,inj.getId_injection(),inj.getId_diabetic(), inj.getDate(),inj.getDay(),inj.getWakeupTest(),inj.getMorningDose(),inj.getMorningTest(),inj.getMiddayTest(),inj.getMiddayDose(),inj.getAfternoonTest(),inj.getSupperTest(),inj.getSupperDose(),inj.getEveningTest(), inj.getSleepTest(),inj.getSleepDose(),inj.getNightTest(),inj.getComment(),idInj);
    }
    public void delInj(int idInj)
    {
        String sql = "DELETE FROM Injection WHERE id_injection = ?";
        jdbcTemplate.update(sql,idInj);
    }

    public List<Injection> getAllInj(){
        return jdbcTemplate.query("SELECT * FROM Injection",new InjectionDAO.InjectionRowMapper());

    }


    public List<Injection> getAllInjFromIdDia(int idDia){
        return jdbcTemplate.query("select * from Injection where id_diabetic=?", new InjectionDAO.InjectionRowMapper(),idDia);
    }
    public boolean checkInjExist(List<Injection> listInj,Date date)
    {

        for (int i = 0; i < listInj.size(); i++)
        {
            if(listInj.get(i).getDate().equals(date))
            {
                return true;
            }
        }
        return  false;
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
            inj.setMiddayTest(rs.getInt("middayTest"));
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
