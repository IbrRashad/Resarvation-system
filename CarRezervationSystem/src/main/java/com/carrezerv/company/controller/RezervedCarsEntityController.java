package com.carrezerv.company.controller;

import com.carrezerv.company.dto.RezervedCarsEntityDto;
import com.carrezerv.company.service.RezervedCarsEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rezer-cars")
@RequiredArgsConstructor
public class RezervedCarsEntityController {
    private final RezervedCarsEntityService rezervedCarsEntityService;

    @PostMapping("/rezerved")
    public void createRezervCar(@RequestBody RezervedCarsEntityDto rezervedCarsEntityDto) {
        rezervedCarsEntityService.create(rezervedCarsEntityDto);
    }

    @GetMapping("/rezerved")
    public ResponseEntity<List<RezervedCarsEntityDto>> getAll() {
        List<RezervedCarsEntityDto> rezervedCarsEntityDtoList = rezervedCarsEntityService.getAll();
        return ResponseEntity.ok(rezervedCarsEntityDtoList);
    }

    @PatchMapping("/rezerved/{id}")
    public void updateRezervedCars(@PathVariable Integer id, @RequestBody RezervedCarsEntityDto rezervedCarsEntityDto) {
        rezervedCarsEntityService.update(id, rezervedCarsEntityDto);
    }

    @DeleteMapping("/rezerved/{id}")
    public void deleteById(@PathVariable int id) {
        rezervedCarsEntityService.deleteById(id);
    }

    @GetMapping("/rezerved/{id}")
    public ResponseEntity<RezervedCarsEntityDto> findById(@PathVariable int id) {
        RezervedCarsEntityDto r = rezervedCarsEntityService.findById(id);
        return ResponseEntity.ok(r);
    }

}
