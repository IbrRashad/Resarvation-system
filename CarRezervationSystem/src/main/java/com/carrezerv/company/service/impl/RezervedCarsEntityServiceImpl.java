package com.carrezerv.company.service.impl;

import com.carrezerv.company.dto.RezervedCarsEntityDto;
import com.carrezerv.company.entity.RezervedCarsEntity;
import com.carrezerv.company.enums.ErrorCodeEnum;
import com.carrezerv.company.enums.RezervedCarsErrorCodeEnum;
import com.carrezerv.company.exception.CustomNotFoundException;
import com.carrezerv.company.exception.RezervedCarsException;
import com.carrezerv.company.repository.RezervedCarsEntityRepository;
import com.carrezerv.company.service.RezervedCarsEntityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RezervedCarsEntityServiceImpl implements RezervedCarsEntityService {

    private final RezervedCarsEntityRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public void create(RezervedCarsEntityDto rezervedCarsEntityDto) {
        RezervedCarsEntity check=repository
                .findByRezCarId(rezervedCarsEntityDto.getRezCarId());
        if (check!=null){
            throw new RezervedCarsException(RezervedCarsErrorCodeEnum.ALREADY_EXIST);
        }
        RezervedCarsEntity rezervedCarsEntity = RezervedCarsEntity.builder()
                .rezCarId(rezervedCarsEntityDto.getRezCarId())
                .userId(rezervedCarsEntityDto.getUserId())
                .build();
        repository.save(rezervedCarsEntity);
    }

    @Override
    public List<RezervedCarsEntityDto> getAll() {
        List<RezervedCarsEntity> rezCarList = repository.findAll();
        if (rezCarList.size() == 0) {
            throw new CustomNotFoundException(ErrorCodeEnum.NOT_ENOUGH_REZERVED_CARS);
        }
        return rezCarList.stream().
                map(rezervedCarsEntity -> modelMapper.map(rezervedCarsEntity, RezervedCarsEntityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer id, RezervedCarsEntityDto rezervedCarsEntityDto) {
        RezervedCarsEntity rezervedCarsEntity = repository.findById((int) id);
        if (rezervedCarsEntity == null) {
            throw new CustomNotFoundException(ErrorCodeEnum.NOT_ENOUGH_REZERVED_CARS);
        }
        rezervedCarsEntity.setRezCarId(rezervedCarsEntityDto.getRezCarId());
        rezervedCarsEntity.setUserId(rezervedCarsEntityDto.getUserId());
        repository.save(rezervedCarsEntity);
    }

    @Override
    public void deleteById(Integer idd) {
        RezervedCarsEntity rezervedCarsEntity = repository.findById((int) idd);
        if (rezervedCarsEntity == null) {
            throw new CustomNotFoundException(ErrorCodeEnum.NOT_ENOUGH_REZERVED_CARS);
        }
        repository.deleteById(idd);
    }

    @Override
    public RezervedCarsEntityDto findById(Integer idd) {
        Optional<RezervedCarsEntity> rezervedCarsEntity = repository.findById(idd);
        return rezervedCarsEntity
                .map(rezervedCarsEntity1 -> modelMapper.map(rezervedCarsEntity1, RezervedCarsEntityDto.class))
                .orElseThrow(() -> new CustomNotFoundException(ErrorCodeEnum.NOT_ENOUGH_REZERVED_CARS));
    }
}
