package dao;

import model.piece.Piece;
import model.piece.PieceProfile;
import model.piece.PieceType;
import model.piece.position.Position;
import model.player.Team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PieceDao {

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

    private PreparedStatement generatePreparedStatement(final String query) throws SQLException {
        return getConnection().prepareStatement(query);
    }

    public void addPiece(final Piece piece, final Team team) {
        final String query = "INSERT INTO piece VALUES(?, ?, ?, ?)";
        try (final PreparedStatement preparedStatement = generatePreparedStatement(query)) {
            preparedStatement.setInt(1, piece.getPieceType().ordinal());
            preparedStatement.setInt(2, team.ordinal());
            preparedStatement.setInt(3, piece.getPosition().getRow());
            preparedStatement.setInt(4, piece.getPosition().getColumn());
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            System.out.println("DB 연결 도중 오류가 발생하였습니다. 해당 게임이 갑작스럽게 종료될 경우, 추후 이어서 진행할 수 없습니다.");
            exception.printStackTrace();
        }
    }

    public void deletePieceByPosition(final Position position) {
        final String query ="DELETE FROM piece WHERE row = ? AND column = ?";
        try (final PreparedStatement preparedStatement = generatePreparedStatement(query)) {
            preparedStatement.setInt(1, position.getRow());
            preparedStatement.setInt(2, position.getColumn());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("DB 연결 도중 오류가 발생하였습니다. 해당 게임이 갑작스럽게 종료될 경우, 추후 이어서 진행할 수 없습니다.");
            exception.printStackTrace();
        }
    }

    public void deleteAllPieces() {
        final String query = "DELETE FROM piece";
        try (final PreparedStatement preparedStatement = generatePreparedStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("DB 연결 도중 오류가 발생하였습니다. 해당 게임이 갑작스럽게 종료될 경우, 추후 이어서 진행할 수 없습니다.");
            exception.printStackTrace();
        }
    }

    public List<Piece> findPieceByTeam(final Team team) {
        final String query = "SELECT * FROM piece WHERE team = ?";
        try (final  PreparedStatement preparedStatement = generatePreparedStatement(query)) {
            preparedStatement.setInt(1, team.ordinal());
            final ResultSet resultSet = preparedStatement.executeQuery();
            return generateTeamPieces(resultSet);
        } catch (SQLException exception) {
            System.out.println("DB 연결 도중 오류가 발생하였습니다. 해당 게임이 갑작스럽게 종료될 경우, 추후 이어서 진행할 수 없습니다.");
            exception.printStackTrace();
            return null;
        }
    }

    private List<Piece> generateTeamPieces(ResultSet resultSet) throws SQLException {
        List<Piece> teamPieces = new ArrayList<>();
        while (resultSet.next()) {
            PieceType pieceType = PieceType.findByOrdinal(resultSet.getInt("type"));
            Piece piece = new Piece(PieceProfile.generateFromPieceType(pieceType), new Position(resultSet.getInt("row"), resultSet.getInt("column")));
            teamPieces.add(piece);
        }
        return teamPieces;
    }

    public void updatePiecePosition(final Position originalPosition, final Position newPosition) {
        final String query = "UPDATE piece SET row = ?, column = ? WHERE row = ? AND column = ?";
        try (final PreparedStatement preparedStatement = generatePreparedStatement(query)) {
            preparedStatement.setInt(1, newPosition.getRow());
            preparedStatement.setInt(2, newPosition.getColumn());
            preparedStatement.setInt(3, originalPosition.getRow());
            preparedStatement.setInt(4, originalPosition.getColumn());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("DB 연결 도중 오류가 발생하였습니다. 해당 게임이 갑작스럽게 종료될 경우, 추후 이어서 진행할 수 없습니다.");
            exception.printStackTrace();
        }
    }
}
