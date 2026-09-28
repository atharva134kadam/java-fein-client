package com.mobile.service;
import com.mobile.entity.mobile;
import com.mobile.repository.mobileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class mobileService {

    private final mobileRepository mobileRepository;
	

    public mobileService(mobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    public mobile createmobile(mobile mobile) {
        return mobileRepository.save(mobile);
    }

    public List<mobile> getAllmobile() {
        return mobileRepository.findAll();
    }

    public mobile getmobileById(Integer id) {
        return mobileRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("mobile not found with id: " + id));
    }

    public mobile updatemobile(int id, mobile mobileDetails) {
        mobile mobile = getmobileById(id);

        mobile.setBrand(mobileDetails.getBrand());
        mobile.setModel(mobileDetails.getModel());
        mobile.setPrice(mobileDetails.getPrice());
        mobile.setColour(mobileDetails.getColour());

        return mobileRepository.save(mobile);
    }

    public void deletemobile(int id) {
        mobile mobile = getmobileById(id);
        mobileRepository.delete(mobile);
    }
}
