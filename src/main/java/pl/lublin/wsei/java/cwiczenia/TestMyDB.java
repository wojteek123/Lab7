package pl.lublin.wsei.java.cwiczenia;

import java.sql.*;

public class TestMyDB {
    public static void main(String[] args) {
        MyDB dataBase = new MyDB("localhost","mydb", 3306);
        dataBase.setUser("root");
        dataBase.setPasssword("12345");
        Connection conn= dataBase.getConnection();
        if(conn!=null){
            System.out.printf("udalo sie");
            try {
                Statement polecenie = conn.createStatement();
                Number dostawa = 100;
                polecenie.executeUpdate("UPDATE coffee_houses SET COFFEE= COFFEE+"+dostawa+" WHERE CITY ='SF' ");

                ResultSet res = polecenie.executeQuery("SELECT * FROM coffee_houses");
                System.out.printf("%10s%20s%7s%7s%7s \n", "STORE_ID", "CITY", "COFFEE", "MERCH", "TOTAL");
                while (res.next()) {
                    System.out.printf("%10d%20s%7d%7d%7d \n", res.getInt(1), res.getString("CITY"), res.getInt(3), res.getInt(4), res.getInt(5));
                }

            }catch(SQLException e){
                System.out.printf("blad w poleceniu");
            }



        }
        dataBase.closeConnection();
        System.out.printf("polacznie zakoncvzone");
    }




}
