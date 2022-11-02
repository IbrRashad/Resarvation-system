package com.carrezerv.company.service.impl;


import com.carrezerv.company.dto.UserCarsEntityDto;
import com.carrezerv.company.dto.UserEntityDto;

import com.carrezerv.company.entity.UserCarsEntity;

import com.carrezerv.company.enums.ErrorUSerCarsEntityEnum;

import com.carrezerv.company.exception.UsersCarNotFound;
import com.carrezerv.company.repository.UserCarsEntityRepository;
import com.carrezerv.company.service.UserCarsEntityService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCarsEntityServiceImpl implements UserCarsEntityService {
    private final UserCarsEntityRepository userCarsEntityRepository;

    private  final ModelMapper modelMapper;
    @Override
    public void create(UserCarsEntityDto userCarsEntityDto) {
        UserCarsEntity userCarsEntity=  UserCarsEntity.builder()

                .userId(userCarsEntityDto.getUserId())
                .carId(userCarsEntityDto.getCarId())
                .build();
        userCarsEntityRepository.save(userCarsEntity);

    }

    @Override
    public List<UserCarsEntityDto > getAll() {

        List<UserCarsEntity> userCarsEntityList =userCarsEntityRepository.findAll();
        if(userCarsEntityList.size()==0){
            throw new UsersCarNotFound(ErrorUSerCarsEntityEnum.NOT_ENOUGH_USERSCAR);
        }
        return userCarsEntityList.stream().
                map(userCarsEntity -> modelMapper.map(userCarsEntity , UserCarsEntityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer id,UserCarsEntityDto userCarsEntityDto) {
        UserCarsEntity userCar=  userCarsEntityRepository.findById((int) id);
        if(userCar==null){
            throw new UsersCarNotFound(ErrorUSerCarsEntityEnum.USERCARS_NOT_FOUND);
        }

       userCar.setCarId(userCarsEntityDto.getCarId());
       userCar.setUserId(userCarsEntityDto.getUserId());

        userCarsEntityRepository.save(userCar);

    }

    @Override
    public void deleteById(Integer idd) {
        UserCarsEntity userCar=userCarsEntityRepository.findById((int) idd);
        if(userCar==null){
            throw new UsersCarNotFound(ErrorUSerCarsEntityEnum.USERCARS_NOT_FOUND);

        }userCarsEntityRepository.deleteById(idd);

    }

    @Override
    public UserCarsEntityDto findById(Integer idd) {
        Optional<UserCarsEntity> userCars=userCarsEntityRepository.findById(idd);
        return userCars.map(userCarsEntity -> modelMapper.map(userCarsEntity, UserCarsEntityDto.class))
                .orElseThrow(()->new UsersCarNotFound(ErrorUSerCarsEntityEnum.UNKNOWN_ERROR.USERCARS_NOT_FOUND));


    }
}
