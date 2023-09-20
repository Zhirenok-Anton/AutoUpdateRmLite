package JDBC;

import org.postgresql.Driver;

import java.sql.*;

public class JdbcRunner {


    public static void main(String args[]) {

        connectJDBS();
        //createTable();

    }

    public static void connectJDBS() {


        String url = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
         Statement stmt = null;
         ResultSet rs;
        //String query = "select count(*) from books";
        //String query = "CREATE DATABASE public.test3";
        String sql = "CREATE DATABASE create_test_DB5;";


        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Register JDBC driver");

            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");




        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main

    public static void createTable() {
        String url = "jdbc:postgresql://localhost:5432/create_test_DB5";
        String user = "postgres";
        String password = "postgres";

         Connection con = null;
         Statement stmt = null;
         ResultSet rs;
        /*String sql = "CREATE TABLE public.discountspread1 (\n" +
                "    id bigint NOT NULL,\n" +
                "    id_basket bigint NOT NULL,\n" +
                "    id_basket_disc bigint NOT NULL,\n" +
                "    id_basket_item bigint\n" +
                ");";*/

        //String query = "select count(*) from books";
        String sql = "CREATE TABLE test3;";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            stmt.executeQuery(sql);

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }
}//end JDBCExample
