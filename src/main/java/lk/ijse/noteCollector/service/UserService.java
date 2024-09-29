package lk.ijse.noteCollector.service;

import lk.ijse.noteCollector.dto.impl.NoteDTO;
import lk.ijse.noteCollector.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUser (String userId);
    void deleteUser(String userId);
    boolean updateUser(String noteId,UserDTO userDTO);


}
