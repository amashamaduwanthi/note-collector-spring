package lk.ijse.noteCollector.imp;

import lk.ijse.noteCollector.dao.UserDao;
import lk.ijse.noteCollector.dto.impl.UserDTO;
import lk.ijse.noteCollector.entity.impl.UserEntity;
import lk.ijse.noteCollector.service.UserService;
import lk.ijse.noteCollector.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceIMPL implements UserService {
    @Autowired
   private UserDao userDao;
    @Autowired
    private Mapping mapping;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity savedUser = userDao.save(mapping.toUserEntity(userDTO));
        return mapping.toUserDto(savedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUsers = userDao.findAll();
        return mapping.asUserDtoList(allUsers);
    }

    @Override
    public UserDTO getUser(String userId) {
     UserEntity selectedUser=  userDao.getReferenceById(userId);
     return mapping.toUserDto(selectedUser);
    }

    @Override
    public void deleteUser(String userId) {
      userDao.deleteById(userId);
    }

    @Override
    public boolean updateUser(String noteId, UserDTO userDTO) {
        return false;
    }
}
