package chat.model;

import java.util.Objects;

public class Message {
    private Long id;
    private String message;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(this.message, message.message)
                && Objects.equals(user, message.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, user);
    }

    @Override
    public String toString() {
        return "Message{"
                + "id=" + id
                + ", value='" + message + '\''
                + ", user=" + user
                + '}';
    }
}
