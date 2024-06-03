package com.gestion.notasExamen.mapper;

import com.gestion.notasExamen.dto.UserDTO;
import com.gestion.notasExamen.entity.UserEntity;
import com.gestion.notasExamen.security.LoginRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StudentMapper.class , TeacherMapper.class})
public interface UserMapper {

  UserDTO UserEntityToUserDTO(UserEntity userEntity);

  UserEntity UserDTOToUserEntity(UserDTO userDTO);

  List<UserDTO> UserEntityListToUserDTOList (List<UserEntity> userEntityList);

  UserEntity userEntityToAuthRequest(LoginRequest loginRequest);
}
