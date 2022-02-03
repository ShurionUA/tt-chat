package chat.controller;

import chat.dto.UserDto;
import chat.lib.Injector;
import chat.model.User;
import chat.service.AuthenticationService;
import chat.service.UserDtoMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
    private static final String SESSION_ATTRIBUTE_ID = "userDto";
    private static final Injector injector = Injector.getInstance("chat");
    private final AuthenticationService authService = (AuthenticationService) injector
            .getInstance(AuthenticationService.class);
    private final UserDtoMapper userDtoMapper = (UserDtoMapper) injector
            .getInstance(UserDtoMapper.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        try {
            User user = authService.login(login);
            UserDto userDto = userDtoMapper.toDto(user);
            HttpSession session = req.getSession();
            session.setAttribute(SESSION_ATTRIBUTE_ID, userDto);
            resp.sendRedirect("/chat");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
