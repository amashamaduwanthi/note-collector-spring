package lk.ijse.noteCollector.imp;

import lk.ijse.noteCollector.customStatusCode.SelectedUserStatus;
import lk.ijse.noteCollector.dao.UserDao;
import lk.ijse.noteCollector.dto.UserStatus;
import lk.ijse.noteCollector.dto.impl.UserDTO;
import lk.ijse.noteCollector.entity.impl.UserEntity;
import lk.ijse.noteCollector.exception.DataPersistException;
import lk.ijse.noteCollector.exception.UserNotFoundException;
import lk.ijse.noteCollector.service.UserService;
import lk.ijse.noteCollector.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIMPL implements UserService {
    @Autowired
   private UserDao userDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity savedUser = userDao.save(mapping.toUserEntity(userDTO));
        if(savedUser==null){
            throw new DataPersistException("user not saved");
        }
//        return mapping.toUserDto(savedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUsers = userDao.findAll();
        return mapping.asUserDtoList(allUsers);
    }

    @Override
    public UserStatus getUser(String userId) {
        if(userDao.existsById(userId)){
            UserEntity selectedUser = userDao.getReferenceById(userId);
            return mapping.toUserDto(selectedUser);
        }else {
            return new SelectedUserStatus(2, "User with id " + userId + " not found");
        }
    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> existedUser = userDao.findById(userId);
        if(!existedUser.isPresent()){
            throw new UserNotFoundException("User with id " + userId + " not found");
        }else {
            userDao.deleteById(userId);
        }

    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {


        Optional<UserEntity> tmpUser = userDao.findById(userId);
        if(tmpUser.isPresent()) {
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilePic(userDTO.getProfilePic());
        }
    }
}
