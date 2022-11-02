package com.carrezerv.company.controller;

import com.carrezerv.company.dto.CarEntityDto;
import com.carrezerv.company.service.CarEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carss")
@RequiredArgsConstructor
public class CarEntityController {
    private final CarEntityService carEntityService;

    @PostMapping("/car")
    public void createCar(@RequestBody CarEntityDto carEntityDto) {

        carEntityService.create(carEntityDto);
    }
    @GetMapping("/car")
    public ResponseEntity<List<CarEntityDto>> getAll() {
        List<CarEntityDto> carEntityDtoList = carEntityService.getAll();
        return ResponseEntity.ok(carEntityDtoList);
    }

    @PatchMapping("/car/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody CarEntityDto carEntityDto) {
        carEntityService.update(id, carEntityDto);
    }

    @DeleteMapping("/car/{id}")
    public void deleteUser(@PathVariable Integer id) {
        carEntityService.deleteById(id);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarEntityDto> findById(@PathVariable Integer id) {
        CarEntityDto car = carEntityService.findById(id);
        return ResponseEntity.ok(car);
    //edssasfc
    }
}
