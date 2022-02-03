package chat.dao;

import chat.lib.Dao;
import chat.model.Message;
import chat.model.User;
import chat.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Dao
public class MessageDaoImpl implements MessageDao {
    @Override
    public Message add(Message message) {
        String query = "INSERT INTO messages (message, user_id) "
                + "VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement = connection.prepareStatement(query,
                        Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, message.getMessage());
            createDriverStatement.setLong(2, message.getUser().getId());
            createDriverStatement.executeUpdate();
            ResultSet resultSet = createDriverStatement.getGeneratedKeys();
            if (resultSet.next()) {
                message.setId(resultSet.getObject(1, Long.class));
            }
            return message;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't add message: "
                    + message.getMessage() + ". ", e);
        }
    }

    @Override
    public List<Message> getMessagesByNumber(int number) {
        String query = "SELECT m.id AS message_id, u.id AS user_id, "
                + "u.name AS user_name, m.message AS message_message "
                + "FROM messages m "
                + "JOIN users u ON m.user_id = u.id "
                + "ORDER BY m.id DESC "
                + "LIMIT ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement = connection.prepareStatement(query)) {
            getDriverStatement.setInt(1, number);
            ResultSet resultSet = getDriverStatement.executeQuery();
            List<Message> messages = new ArrayList<>();
            while (resultSet.next()) {
                Message message = parserMessageWhitUserFromResultSet(resultSet);
                messages.add(message);
            }
            return messages;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get messages from DB. ", e);
        }
    }

    private Message parserMessageWhitUserFromResultSet(ResultSet resultSet) throws SQLException {
        Message message = new Message();
        message.setId(resultSet.getObject("message_id", Long.class));
        message.setMessage(resultSet.getString("message_message"));
        message.setUser(this.parserUserFromResultSet(resultSet));
        return message;
    }

    private User parserUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getObject("user_id", Long.class));
        user.setName(resultSet.getString("user_name"));
        return user;
    }
}
