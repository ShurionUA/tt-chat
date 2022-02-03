package chat.service;

import chat.model.Message;
import java.util.List;

public interface MessageService {
    void add(Message message);

    List<Message> getMessagesByNumber(int count);
}
