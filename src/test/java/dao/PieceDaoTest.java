package dao;

import model.piece.Piece;
import model.piece.PieceProfile;
import model.piece.PieceType;
import model.piece.Pieces;
import model.piece.position.Position;
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
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceDaoTest {

    private static Connection connection;
    private PieceDao pieceDao;

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
        pieceDao = new PieceDao(connection);
        pieceDao.deleteAllPieces();
    }

    @AfterAll
    static void close() throws SQLException {
        connection.close();
    }

    @Test
    void 기물_하나를_DB에_저장한다() {
        // Given
        Piece piece = new Piece(PieceProfile.generateFromPieceType(PieceType.GENERAL), new Position(1, 4));

        // When
        pieceDao.addPiece(piece, Team.RED);

        // Then
        assertThat(pieceDao.findPieceByTeam(Team.RED)).isEqualTo(List.of(piece));
    }

    @Test
    void 기물_여러_개를_DB에_저장한다() {
        // Given
        Piece piece = new Piece(PieceProfile.generateFromPieceType(PieceType.GENERAL), new Position(1, 4));
        Piece piece2 = new Piece(PieceProfile.generateFromPieceType(PieceType.GUARD), new Position(0, 5));
        Pieces pieces = Pieces.continuePiecesFrom(List.of(piece, piece2));

        // When
        pieceDao.addPieces(pieces, Team.RED);

        // Then
        assertThat(pieceDao.findPieceByTeam(Team.RED)).isEqualTo(List.of(piece, piece2));
    }

    @Test
    void 저장된_기물을_DB에서_삭제한다() {
        // Given
        Piece piece = new Piece(PieceProfile.generateFromPieceType(PieceType.GENERAL), new Position(1, 4));
        pieceDao.addPiece(piece, Team.RED);

        // When
        pieceDao.deletePieceByPosition(new Position(1, 4));

        // Then
        assertThat(pieceDao.findPieceByTeam(Team.RED)).isEqualTo(Collections.emptyList());
    }

    @Test
    void 저장된_기물의_위치를_변경한다() {
        // Given
        Position originalPosition = new Position(1, 4);
        Position newPosition = new Position(2, 4);
        Piece piece = new Piece(PieceProfile.generateFromPieceType(PieceType.GENERAL), originalPosition);
        pieceDao.addPiece(piece, Team.RED);

        // When
        pieceDao.updatePiecePosition(originalPosition, newPosition);

        // Then
        assertThat(pieceDao.findPieceByTeam(Team.RED))
                .isEqualTo(List.of(new Piece(PieceProfile.generateFromPieceType(PieceType.GENERAL), newPosition)));
    }
}
