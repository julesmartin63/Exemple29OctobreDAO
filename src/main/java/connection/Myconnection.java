package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Une unique connection à la bd (utilise le design pattern Singleton)
 */
public class Myconnection {

    //URL
    private String url = "jdbc:mysql://localhost:3306/catalog?createDatabaseIfNotExist=true";
    //User Name
    private String user = "root";
    //User password
    private String passwd = "Michelle0987!";
    //Connection Object
    private static Connection connect;

    //Private Constructor
    private Myconnection(){
        try {
            connect = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Return the instance or ceate if it doesn't exist
    public static Connection getInstance(){
        if(connect == null){
            new Myconnection();
        }
        return connect;
    }
}

