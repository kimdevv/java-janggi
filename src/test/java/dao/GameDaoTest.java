package dao;

import model.player.Team;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.ConfigLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class GameDaoTest {

    private static Connection connection;
    private GameDao gameDao;

    @BeforeAll
    static void setUp() {
        String SERVER = ConfigLoader.getProperty("database.server");
        String DATABASE = ConfigLoader.getProperty("database.database");
        String OPTION = ConfigLoader.getProperty("database.option");
        String USERNAME = ConfigLoader.getProperty("database.username");
        String PASSWORD = ConfigLoader.getProperty("database.password");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + DATABASE + OPTION, USERNAME, PASSWORD);
        } catch (final SQLException exception) {
            throw new RuntimeException("DB 연결 도중 오류가 발생하였습니다. 해당 게임이 갑작스럽게 종료될 경우, 추후 이어서 진행할 수 없습니다.");
        }
    }

    @BeforeEach
    void initialize() {
        gameDao = new GameDao(connection);
    }

    @AfterEach
    void deleteGame() {
        gameDao.deleteGame();
    }

    @AfterAll
    static void close() throws SQLException {
        connection.close();
    }

    @Test
    void 게임을_DB에_저장한다() {
        // Given
        Team currentTurnTeam = Team.RED;

        // When
        gameDao.addGame(currentTurnTeam);

        // Then
        assertThat(gameDao.findPreviousGameTurn()).isEqualTo(Team.RED);
    }

    @Test
    void 턴을_업데이트한다() {
        // Given
        Team currentTurnTeam = Team.GREEN;
        gameDao.addGame(currentTurnTeam);
        Team nextTurnTeam = Team.RED;

        // When
        gameDao.updateGameTurn(nextTurnTeam);

        // Then
        assertThat(gameDao.findPreviousGameTurn()).isEqualTo(Team.RED);
    }

    @Test
    void 이전에_진행된_게임이_없다면_false를_반환한다() {
        // Given
        gameDao.deleteGame();
        // When
        // Then
        assertThat(gameDao.isExist()).isFalse();
    }

    @Test
    void 이전에_진행된_게임이_있다면_true를_반환한다() {
        // Given
        // When
        gameDao.addGame(Team.GREEN);

        // Then
        assertThat(gameDao.isExist()).isTrue();
    }
}
