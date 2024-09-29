package lk.ijse.noteCollector.dao;

import lk.ijse.noteCollector.dto.impl.UserDTO;
import lk.ijse.noteCollector.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//dao paththa handle krnne me annotation eken
public interface UserDao extends JpaRepository<UserEntity ,String > {
//    UserEntity saveUser(UserDTO userDTO);

}
