package pl.lublin.wsei.java.cwiczenia;

import java.sql.Connection;

public class TestMyDB {
    public static void main(String[] args) {
        MyDB dataBase = new MyDB("localhost","mydb", 3306);
        dataBase.setUser("root");
        dataBase.setPasssword("12345");
        Connection conn= dataBase.getConnection();
        if(conn!=null){
            System.out.printf("udalo sie");
        }
        dataBase.closeConnection();
        System.out.printf("polacznie zakoncvzone");
    }




}
