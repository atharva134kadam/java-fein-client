package com.car.controller;

import com.car.entity.car;
import com.car.service.carService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/car")
public class carController {

    private final carService carService;

    public carController(carService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<car> createcar(
            @RequestBody car car) {

        car savedcar =
                carService.createcar(car);

        return new ResponseEntity<>(
                savedcar,
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<car>> getAllcars() {
        return ResponseEntity.ok(
                carService.getAllcars()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<car> getcarById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                carService.getcarById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<car> updatecar(
            @PathVariable int id,
            @RequestBody car car) {

        return ResponseEntity.ok(
                carService.updatecar(id, car)
        );
    }

    @PostMapping("/buy")
    public ResponseEntity<Map<String, Object>> buyCar(
            @RequestBody car car) {
        return new ResponseEntity<>(
                carService.buyCar(car),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletecar(
            @PathVariable int id) {

        carService.deletecar(id);

        return ResponseEntity.ok(
                "Car deleted successfully"
        );
    }
}