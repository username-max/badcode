package ru.liga.intership.badcode.service;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class PersonServiceTest {
    private static PersonService personService;

    @BeforeClass
    public static void setup() {
        personService = new PersonService();
    }

    @Test(expected = SQLException.class)
    public void personServiceGetSQLException() throws SQLException {
        personService.getAdultMaleUsersAverageBMI("", "", "", "");
    }

}
