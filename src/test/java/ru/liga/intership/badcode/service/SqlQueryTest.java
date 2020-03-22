package ru.liga.intership.badcode.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.liga.intership.badcode.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SqlQueryTest {
    @BeforeClass
    public static void setup() {
    }

    @Test(expected = SQLException.class)
    public void SqlQueryGetSQLException() throws SQLException {
        SqlQuery.getResult("", "", "", "");

    }

}
