package com.carrezerv.company.service.impl;

import com.carrezerv.company.dto.UserEntityDto;
import com.carrezerv.company.entity.UserEntity;
import com.carrezerv.company.enums.ErrorCodeEnum;
import com.carrezerv.company.exception.CustomNotFoundException;
import com.carrezerv.company.repository.UserEntityRepository;
import com.carrezerv.company.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService {
    private final UserEntityRepository userEntityRepository;
    private final ModelMapper modelMapper;

    @Override
    public void create(UserEntityDto userEntityDto) {
        UserEntity user = UserEntity.builder()
                .name(userEntityDto.getName())
                .password(userEntityDto.getPassword())
                .email(userEntityDto.getEmail())
                .build();
        userEntityRepository.save(user);
    }

    @Override
    public List<UserEntityDto> getAll() {
        List<UserEntity> userList = userEntityRepository.findAll();
        if (userList.size() == 0) {
            throw new CustomNotFoundException(ErrorCodeEnum.NOT_ENOUGH_USERS);
        }
        return userList.stream().
                map(userEntity -> modelMapper.map(userEntity, UserEntityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer id, UserEntityDto userEntityDto) {
        UserEntity user = userEntityRepository.findById((int) id);
        if (user == null) {
            throw new CustomNotFoundException(ErrorCodeEnum.USER_NOT_FOUND);
        }
        user.setName(userEntityDto.getName());
        user.setEmail(userEntityDto.getEmail());
        user.setPassword(userEntityDto.getPassword());
        userEntityRepository.save(user);
    }

    @Override
    public void deleteById(Integer idd) {
        UserEntity user = userEntityRepository.findById((int) idd);
        if (user == null) {
            throw new CustomNotFoundException(ErrorCodeEnum.USER_NOT_FOUND);
        }
        userEntityRepository.deleteById(idd);
    }

    @Override
    public UserEntityDto findById(Integer idd) {
        Optional<UserEntity> user = userEntityRepository.findById(idd);
        return user.map(userEntity -> modelMapper.map(userEntity, UserEntityDto.class))
                .orElseThrow(() -> new CustomNotFoundException(ErrorCodeEnum.USER_NOT_FOUND));
    }
}
