package lk.ijse.backend.service;


import lk.ijse.backend.DTO.UserDTO;


public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
    int deleteUser(String email);
    int updateUser(UserDTO userDTO);
}