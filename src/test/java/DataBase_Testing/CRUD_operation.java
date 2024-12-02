package DataBase_Testing;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD_operation extends BaseClass{
    @Test
    public void InsertData_DBTest() throws SQLException {
        connection = this.setUp();
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Departments values(?,?)");
            ps.setInt(1, 5);
            ps.setString(2, "Hiring");
            ps.executeUpdate();
        }catch(SQLException sqe) {
            System.out.println(sqe.getErrorCode());
            System.out.println(sqe.getSQLState());
            System.out.println(sqe.getMessage());
            sqe.printStackTrace();
        }

    }

    @Test
    public void UpdateData_DBTest() throws SQLException {
        connection = this.setUp();
        PreparedStatement ps = connection.prepareStatement("update Departments set department_name='Marketing' where department_id=4");
        ps.executeUpdate();
    }

    @Test
    public void DeleteData_DBTest() throws SQLException {

        connection = this.setUp();

        try {
            PreparedStatement ps = connection.prepareStatement("Delete from Projects where department_id = 3");
            ps.execute();
        }catch(SQLException sqe) {
            System.out.println(sqe.getErrorCode());
            System.out.println(sqe.getSQLState());
            System.out.println(sqe.getMessage());
            sqe.printStackTrace();
        }

    }

    @Test
    public void SelectQuery() throws SQLException{
        connection = this.setUp();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("Select * from Departments");
        while(rs.next()) {
            String Department_id=rs.getString(1);
            String Department_name=rs.getString(2);

            System.out.println(Department_id+ " " + Department_name);
        }
    }
}
