package chat.dao;

import chat.model.Message;
import java.util.List;

public interface MessageDao {
    Message add(Message message);

    List<Message> getMessagesByNumber(int number);
}
