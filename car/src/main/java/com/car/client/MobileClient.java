package com.car.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "mobile-service", url = "http://localhost:8081")
public interface MobileClient {

    @GetMapping("/api/mobile")
    List<MobileDto> getAllMobiles();

    @GetMapping("/api/mobile/{id}")
    MobileDto getMobileById(@PathVariable("id") Integer id);

    @PostMapping("/api/mobile")
    MobileDto createMobile(@RequestBody MobileDto mobile);
}
