package chat.controller;

import chat.dto.UserDto;
import chat.lib.Injector;
import chat.model.Message;
import chat.service.MessageService;
import chat.service.UserDtoMapper;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChatController extends HttpServlet {
    private static final int NUMBER_MESSAGES_ON_SCREEN = 50;
    private static final String SESSION_ATTRIBUTE_ID = "userDto";
    private static final Injector injector = Injector.getInstance("chat");
    private final MessageService messageService = (MessageService) injector
            .getInstance(MessageService.class);
    private UserDtoMapper userDtoMapper = (UserDtoMapper) injector
            .getInstance(UserDtoMapper.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Message> messages = messageService.getMessagesByNumber(NUMBER_MESSAGES_ON_SCREEN);
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/WEB-INF/views/chat.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserDto userDto = (UserDto) req.getSession().getAttribute(SESSION_ATTRIBUTE_ID);
        Message message = new Message();
        message.setUser(userDtoMapper.fromDto(userDto));
        message.setMessage(req.getParameter("message"));
        messageService.add(message);
        try {
            HttpSession session = req.getSession();
            session.setAttribute(SESSION_ATTRIBUTE_ID, userDto);
            resp.sendRedirect("/chat");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
