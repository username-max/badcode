package ru.liga.intership.badcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.liga.intership.badcode.service.PersonService;

import java.sql.SQLException;

@SpringBootApplication
public class BadCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadCodeApplication.class, args);
        PersonService personService = new PersonService();
        try {
            personService.getAdultMaleUsersAverageBMI(
                    "jdbc:hsqldb:mem:test",
                    "sa",
                    "",
                    "SELECT * FROM person WHERE sex = 'male' AND age > 18");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
