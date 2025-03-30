package lk.ijse.backend.service;


import lk.ijse.backend.DTO.UpdateUserDTO;
import lk.ijse.backend.DTO.UserDTO;


public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
    int deleteUser(String email);
    int updateUser(UpdateUserDTO updateUserDTO);
}