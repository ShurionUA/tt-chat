package chat.service.mapper;

import chat.dto.UserDto;
import chat.lib.Service;
import chat.model.User;
import chat.service.UserDtoMapper;

@Service
public class UserDtoMapperImpl implements UserDtoMapper {
    public User fromDto(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        return user;
    }

    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return dto;
    }
}
