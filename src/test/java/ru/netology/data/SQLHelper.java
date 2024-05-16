package ru.netology.data;


import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    public static final QueryRunner QUERY_RUNNER = new QueryRunner();
    private SQLHelper() {
    }
    private static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(System.getProperty("db.url"),"app","pass");
    }
    @SneakyThrows
    public static String getVerificationCode() {
        var codeSQL = "SELECT code FROM auth_codes ORDER BY created DESC LIMIT 1;";
        var conn = getConnection();
        return QUERY_RUNNER.query(conn, codeSQL, new ScalarHandler<>());
    }
    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConnection();
        QUERY_RUNNER.execute(connection, "DELETE FROM auth_codes");
        QUERY_RUNNER.execute(connection, "DELETE FROM card_transactions");
        QUERY_RUNNER.execute(connection, "DELETE FROM cards");
        QUERY_RUNNER.execute(connection, "DELETE FROM users");
    }
    @SneakyThrows
    public static void cleanAuthCodes() {
        var connection = getConnection();
        QUERY_RUNNER.execute(connection, "DELETE FROM auth_codes");
    }
}