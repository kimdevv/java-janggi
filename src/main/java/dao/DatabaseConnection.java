package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String SERVER = "localhost:3307";
    private static final String DATABASE = "janggi";
    private static final String OPTION = "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + DATABASE + OPTION, USERNAME, PASSWORD);
        } catch (final SQLException exception) {
            System.out.println("DB 연결 도중 오류가 발생하였습니다. 해당 게임이 갑작스럽게 종료될 경우, 추후 이어서 진행할 수 없습니다.");
            exception.printStackTrace();
            return null;
        }
    }

    public PreparedStatement generatePreparedStatement(final String query) throws SQLException {
        return getConnection().prepareStatement(query);
    }

}
