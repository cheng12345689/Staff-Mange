package bwc04.tools.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库链接
 * @author KSaMar
 * @version 1.0
 */
public class SqlConnect {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(SqlConfig.SQL_URL, SqlConfig.SQL_USERNAME, SqlConfig.SQL_PASSWORD);
    }
}
