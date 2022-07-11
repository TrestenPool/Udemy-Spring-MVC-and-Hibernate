package jdbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class TestConnection {
    public static void main(String[] args) {

        Properties properties = new Properties();
        String propertiesFile = "src/jdbc/jdbc_config.properties";

        String url = "";
        String user = "";
        String pass = "";

        // try with resources
        try ( FileReader fileReader = new FileReader(propertiesFile) ){
            properties.load(fileReader);
            url = properties.getProperty("db.conn.url");
            user = properties.getProperty("db.username");
            pass = properties.getProperty("db.password");
        } catch (Exception e){
            e.printStackTrace();
        }

        // attempt to connect to the db
        Connection myConnection = connectToDb(url, user, pass);

        // connection unsuccessful
        if(myConnection == null){
            System.out.println("Unable to connect to the db");
            return;
        }

        // let the user know connection was good
        System.out.println("Connection successfull");

        // do stuff
        try{
            Statement statement = myConnection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from student");

            while(resultSet.next()){
                System.out.printf("%d %s %s\n", resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("email"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("complete");



        // close the resource
        try{
            myConnection.close();
        } catch (Exception e){
          e.printStackTrace();
        }
    }

    public static Connection connectToDb(String url, String user, String pass){
        Connection myConn;

        try {
            myConn = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException exception){
            return null;
        }

        return myConn;
    }

}
