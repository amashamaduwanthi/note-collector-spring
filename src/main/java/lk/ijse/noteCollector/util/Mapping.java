package lk.ijse.noteCollector.util;

import lk.ijse.noteCollector.dto.impl.UserDTO;
import lk.ijse.noteCollector.entity.impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class Mapping {
    @Autowired
   private ModelMapper modelMapper;
    //modelmapper thiyenne userdto entity map krnn

    //for use mapping
    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO,UserEntity.class);
    }
    public UserDTO toUserDto(UserEntity userEntity){
        return modelMapper.map(userEntity,UserDTO.class);
    }
    public List<UserDTO> asUserDtoList(List<UserEntity>userEntities){
        return modelMapper.map(userEntities, new TypeToken<List<UserDTO>>() {}.getType());
    }
}
