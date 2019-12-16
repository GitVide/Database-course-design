package scu.cj.community.mapper;

import scu.cj.community.dto.UserDTO;
import scu.cj.community.model.User;

import java.util.List;

public interface UserExtMapper {

    List<User> selectBySearch(UserDTO userDTO);
}