package JDBC;

import JsonObject.ObjectJSON;
import org.postgresql.Driver;

import java.sql.*;

public class JdbcRunner {
    String url;
    String user;
    String pass;

    public JdbcRunner(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public void updateParameterValueSalePointCode(String salePointCode){
        String script = "update parametervalue set value = '"+ salePointCode + "' where \"name\" = 'SalePointCode'";
        updateParameterValue(script);
    }

    public void updateParameterValueLoadDictionaryDirectory(String pathDirectory, String nameDirectory){
        String script = "update parametervalue set value = '"+ pathDirectory + "\\" + nameDirectory + "' where \"name\" = 'LoadDictionaryDirectory'";
        updateParameterValue(script);
    }
    public void updateParameterValueComProServiceIntegrationDirectory(String pathDirectory, String nameDirectory){
        String script = "update parametervalue set value = '"+ pathDirectory + "\\" + nameDirectory + "\\Compro" +"' where \"name\" = 'ComProServiceIntegrationDirectory'";
        updateParameterValue(script);
    }
    public void updateParameterValuePCardsServiceIntegrationDirectory(String pathDirectory, String nameDirectory){
        String script = "update parametervalue set value = '"+ pathDirectory + "\\" + nameDirectory +"\\Pcards"+ "' where \"name\" = 'PCardsServiceIntegrationDirectory'";
        updateParameterValue(script);
    }
    public void updateParameterValueCountry(String Country){
        String script = "update parametervalue set value = '"+ Country + "' where \"name\" = 'Country'";
        updateParameterValue(script);
    }


    private void updateParameterValue(String sql) {

        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            resultSet.next();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
