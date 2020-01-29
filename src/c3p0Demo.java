import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.omg.CORBA.Request;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName c3p0Demo
 * @Description: TODO
 * @Author mxd
 * @Date 2019/9/28 14:32
 * @Version 1.0
 **/
public class c3p0Demo {
    public static DataSource getDataSource_C3P0(){
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        try {
            c3p0.setDriverClass("com.mysql.cj.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        c3p0.setJdbcUrl("jdbc:mysql://localhost:3306/mxd");
        c3p0.setUser("root");

        c3p0.setPassword("@#MA847547125**");
return c3p0;

    }

    public static void main(String[] args) throws SQLException {
        System.out.println(1);
        Connection connection=getDataSource_C3P0().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            System.out.println(resultSet.getInt(1)+resultSet.getString(2)+resultSet.getInt(3));

        }
    }
}
