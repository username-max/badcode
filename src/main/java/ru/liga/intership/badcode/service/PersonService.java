package ru.liga.intership.badcode.service;


import ru.liga.intership.badcode.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private List<Person> adultPersons;
    private double totalIMT = 0.0;
    private long countOfPerson = 0;
    private ResultSet sqlResult;

    /**
     * Возвращает средний индекс массы тела всех лиц мужского пола старше 18 лет
     */

    public void getAdultMaleUsersAverageBMI(String url, String userName, String password, String sql) throws SQLException {
        sqlResult = SqlQuery.getResult(url, userName, password, sql);
        adultPersons = addPerson(sqlResult);
        countOfPerson = adultPersons.size();
        countingTotalIMT();
        averageBodyMassIndex();
    }

    private List<Person> addPerson(ResultSet sqlResult) throws SQLException {
        List<Person> adultPersons = new ArrayList<>();
        while (sqlResult.next()) {
            Person p = new Person(
                    sqlResult.getLong("id"),
                    sqlResult.getString("sex"),
                    sqlResult.getString("name"),
                    sqlResult.getLong("age"),
                    sqlResult.getLong("weight"),
                    sqlResult.getLong("height"));
            adultPersons.add(p);
        }
        return adultPersons;
    }

    private void countingTotalIMT() {
        for (Person person : adultPersons) {
            double heightInMeters = person.getHeight() / 100d;
            double imt = person.getWeight() / (Double) (heightInMeters * heightInMeters);
            totalIMT += imt;
        }
    }

    private void averageBodyMassIndex() {
        System.out.println("Average imt - " + totalIMT / countOfPerson);
    }

}
