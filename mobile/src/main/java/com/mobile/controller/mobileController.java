package com.mobile.controller;

import com.mobile.entity.mobile;
import com.mobile.service.mobileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mobile")
public class mobileController {

    private final mobileService mobileService;

    public mobileController(mobileService mobileService) {
        this.mobileService = mobileService;
    }

    @PostMapping
    public ResponseEntity<mobile> createmobile(
            @RequestBody mobile mobile) {

        mobile savedmobile =
                mobileService.createmobile(mobile);

        return new ResponseEntity<>(
                savedmobile,
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<mobile>> getAllmobile() {
        return ResponseEntity.ok(
                mobileService.getAllmobile()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<mobile> getmobileById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                mobileService.getmobileById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<mobile> updatemobile(
            @PathVariable int id,
            @RequestBody mobile mobile) {

        return ResponseEntity.ok(
                mobileService.updatemobile(id, mobile)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletemobile(
            @PathVariable int id) {

        mobileService.deletemobile(id);

        return ResponseEntity.ok(
                "Mobile deleted successfully"
        );
    }
}