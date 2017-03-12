package cn.bisonqin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Basil on 2017/2/28.
 */
public class SQLServerConnUtils_JTDS {

    // Connect to SQLServer.
    // (Using JTDS library)
    public static Connection getSQLServerConnection_JTDS() throws SQLException,
            ClassNotFoundException {
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String database = "simplehr";
        String userName = "sa";
        String password = "12345";

        return getSQLServerConnection_JTDS(hostName, sqlInstanceName, database,
                userName, password);
    }


    // JTDS & SQLServer.
    private static Connection getSQLServerConnection_JTDS(String hostName,
                                                          String sqlInstanceName, String database, String userName,
                                                          String password) throws ClassNotFoundException, SQLException {

        // Declare the class Driver for Oracle DB
        // This is necessary with Java 5 (or older)
        // Java6 (or newer) automatically find the appropriate driver.
        // If you use Java> 5, then this line is not needed.
        Class.forName("net.sourceforge.jtds.cn.bisonqin.jdbc.Driver");

        // Example:
        // cn.bisonqin.jdbc:jtds:sqlserver://localhost:1433/simplehr;instance=SQLEXPRESS
        String connectionURL = "cn.bisonqin.jdbc:jtds:sqlserver://" + hostName + ":1433/"
                + database + ";instance=" + sqlInstanceName;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }

}