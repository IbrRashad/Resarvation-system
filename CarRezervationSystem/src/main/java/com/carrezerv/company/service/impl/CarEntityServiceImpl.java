package com.carrezerv.company.service.impl;

import com.carrezerv.company.dto.CarEntityDto;
import com.carrezerv.company.dto.UserEntityDto;
import com.carrezerv.company.entity.CarEntity;
import com.carrezerv.company.entity.UserEntity;
import com.carrezerv.company.enums.ErrorCarCodeEnum;
import com.carrezerv.company.enums.ErrorCodeEnum;
import com.carrezerv.company.exception.CarNotFoundException;
import com.carrezerv.company.exception.CustomNotFoundException;
import com.carrezerv.company.repository.CarEntityRepository;
import com.carrezerv.company.service.CarEntityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class CarEntityServiceImpl implements CarEntityService {
    private  final CarEntityRepository carEntityRepository;
    private  final ModelMapper modelMapper;
    @Override
    public void create(CarEntityDto carEntityDto) {
        CarEntity car = CarEntity.builder()
                .model(carEntityDto.getModel())
                .brand(carEntityDto.getBrand())
                .color(carEntityDto.getColor())
                .eDate(carEntityDto.getEDate())
                .rezPrice(carEntityDto.getRezPrice())
                .segment(carEntityDto.getSegment())
                .build();
        carEntityRepository.save(car);

    }

    @Override
    public List<CarEntityDto> getAll() {
        List<CarEntity> carlist = carEntityRepository.findAll();
        if (carlist.size() == 0) {
            throw new CarNotFoundException(ErrorCarCodeEnum.NOT_ENOUGH_CAR);
        }
        return carlist.stream().
                map(carEntity -> modelMapper.map(carEntity, CarEntityDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public void update(Integer id,CarEntityDto carEntityDto) {
        CarEntity car=  carEntityRepository.findById((int) id);
        if(car==null){
            throw new CarNotFoundException(ErrorCarCodeEnum.CAR_NOT_FOUND);
        }
        car.setBrand(carEntityDto.getBrand());
        car.setColor(carEntityDto.getColor());
        car.setEDate(carEntityDto.getEDate());
        car.setModel(carEntityDto.getModel());
        car.setSegment(carEntityDto.getSegment());
        car.setRezPrice(carEntityDto.getRezPrice());


        carEntityRepository.save(car);


    }

    @Override
    public void deleteById(Integer idd) {
        CarEntity car=carEntityRepository.findById((int) idd);
        if(car==null){
            throw new CarNotFoundException(ErrorCarCodeEnum.CAR_NOT_FOUND);

        }carEntityRepository.deleteById(idd);

    }

    @Override
    public CarEntityDto findById(Integer idd) {
        Optional<CarEntity> car=carEntityRepository.findById(idd);
        return car.map(carEntity -> modelMapper.map(carEntity, CarEntityDto.class))
                .orElseThrow(()->new CarNotFoundException(ErrorCarCodeEnum.CAR_NOT_FOUND));

    }
}
