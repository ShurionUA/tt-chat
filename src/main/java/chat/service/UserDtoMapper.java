package chat.service;

import chat.dto.UserDto;
import chat.model.User;

public interface UserDtoMapper {
    User fromDto(UserDto dto);

    UserDto toDto(User user);
}
