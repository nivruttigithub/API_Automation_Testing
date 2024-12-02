package DataBase_Testing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {
    public static Connection connection;
    @BeforeMethod
    public Connection setUp() {

        try {
            String dburl = "jdbc:mysql://localhost:3306/Database_Testing";
            String UserName = "root";
            String Password = "Root@123";
            connection = DriverManager.getConnection(dburl, UserName, Password);

        }catch(SQLException sqe) {
            System.out.println(sqe.getSQLState());
            System.out.println(sqe.getErrorCode());
            System.out.println(sqe.getMessage());
            sqe.printStackTrace();


        }
        //System.out.println("Connnection sucecssful");

        return connection;
    }

    @AfterMethod
    public void tearDown() throws SQLException{
        connection.close();
    }
}
