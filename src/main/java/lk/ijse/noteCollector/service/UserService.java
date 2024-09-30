package lk.ijse.noteCollector.service;

import lk.ijse.noteCollector.dto.UserStatus;
import lk.ijse.noteCollector.dto.impl.NoteDTO;
import lk.ijse.noteCollector.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserStatus getUser (String userId);
    void deleteUser(String userId);
    void updateUser(String userId,UserDTO userDTO);


}
