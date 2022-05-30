package com.example.MyTFE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MyTfeApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(MyTfeApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO Diabetic (id_doctor,name,firstname,birthdate,mail,password,phone,emergencyContact,address) VALUES (?,?,?,?,?,?,?,?,?)";
		//int result=jdbcTemplate.update(sql,"8","nameTest","firstnTest","10/02/1988","test@gamail.com","mdp123","0476276735","027331528","205 avenue des test");
		/*if(result>0){
			System.out.println(" new diabetic add to db");
		}
		else {

		}*/
	}
}
