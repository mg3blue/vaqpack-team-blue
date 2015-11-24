/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbprototype;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class DBPrototype {
    static final String DATABASE_URL = "jdbc:mysql://127.0.0.1/test";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> what = new ArrayList<>();
        try
        {
            connection = DriverManager.getConnection(DATABASE_URL, "local", "Plethora98!");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM SEfile");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            while (resultSet.next())
            {
                for (int i = 1; i <= numberOfColumns; i++)               
                    what.add(resultSet.getObject(i) + "");               
            }            
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }
    
}
