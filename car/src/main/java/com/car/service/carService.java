package com.car.service;
import com.car.client.MobileClient;
import com.car.client.MobileDto;
import com.car.entity.car;
import com.car.repository.carRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class carService {

    private final carRepository carRepository;
    private final MobileClient mobileClient;

    public carService(carRepository carRepository, MobileClient mobileClient) {
        this.carRepository = carRepository;
        this.mobileClient = mobileClient;
    }

    public car createcar(car car) {
        return carRepository.save(car);
    }

    public List<car> getAllcars() {
        return carRepository.findAll();
    }

    public car getcarById(Integer id) {
        return carRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("car not found with id: " + id));
    }

    public car updatecar(int id, car carDetails) {
        car car = getcarById(id);

        car.setBrand(carDetails.getBrand());
        car.setModel(carDetails.getModel());
        car.setPrice(carDetails.getPrice());
        car.setColour(carDetails.getColour());

        return carRepository.save(car);
    }

    public void deletecar(int id) {
        car car = getcarById(id);
        carRepository.delete(car);
    }

    // Offer: >15L (1500000) = 1 iPhone, >25L (2500000) = iPhone Duo (2 iPhones)
    public Map<String, Object> buyCar(car car) {
        car saved = carRepository.save(car);
        Map<String, Object> resp = new HashMap<>();
        resp.put("car", saved);

        if (saved.getPrice() > 2500000) {
            List<MobileDto> gifts = new ArrayList<>();
            gifts.add(mobileClient.createMobile(new MobileDto("Apple", "iPhone 15", 79900, "Black")));
            gifts.add(mobileClient.createMobile(new MobileDto("Apple", "iPhone 15", 79900, "White")));
            resp.put("offer", "25L+ : Free iPhone Duo (2 iPhones)");
            resp.put("freeGift", gifts);
        } else if (saved.getPrice() > 1500000) {
            MobileDto gift = mobileClient.createMobile(new MobileDto("Apple", "iPhone 15", 79900, "Black"));
            resp.put("offer", "15L+ : Free iPhone");
            resp.put("freeGift", gift);
        } else {
            resp.put("offer", "No offer - buy car above 15L to get free iPhone");
            resp.put("freeGift", null);
        }
        return resp;
    }
}
