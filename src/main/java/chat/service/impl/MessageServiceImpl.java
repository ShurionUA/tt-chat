package chat.service.impl;

import chat.dao.MessageDao;
import chat.lib.Inject;
import chat.lib.Service;
import chat.model.Message;
import chat.service.MessageService;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Inject
    private MessageDao messageDao;

    @Override
    public void add(Message message) {
        messageDao.add(message);
    }

    @Override
    public List<Message> getMessagesByNumber(int number) {
        return messageDao.getMessagesByNumber(number);
    }
}
