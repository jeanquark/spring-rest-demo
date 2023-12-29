package com.webtoucan.restdemo.service.impl;

import com.webtoucan.restdemo.exception.CloudVendorNotFoundException;
import com.webtoucan.restdemo.model.CloudVendor;
import com.webtoucan.restdemo.respository.CloudVendorRepository;
import com.webtoucan.restdemo.service.CloudVendorService;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        // More Business Logic
        if (cloudVendorRepository.findById(cloudVendorId).isEmpty()) {
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist.");
        }
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        // More Business Logic
        return cloudVendorRepository.findAll();
    }

    @Override
    public void createCloudVendor(CloudVendor cloudVendor) {
        // More Business Logic
        cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public void updateCloudVendor(CloudVendor cloudVendor) {
        // More Business Logic
        cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public void updateCloudVendorName(String cloudVendorId, String cloudVendorName) {
        // More Business Logic
        CloudVendor cloudVendor = cloudVendorRepository.findById(cloudVendorId).get();
        cloudVendor.setVendorName(cloudVendorName);

        cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public void updateCloudVendorWithMap(String cloudVendorId, Map<Object, Object> objectMap) {
        // More Business Logic
        CloudVendor cloudVendor = cloudVendorRepository.findById(cloudVendorId).get();

        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(CloudVendor.class, (String) key);
            if(field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, cloudVendor, value);
            }
        });
        cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public void deleteCloudVendor(String cloudVendorId) {
        // More Business Logic
        cloudVendorRepository.deleteById(cloudVendorId);
    }


}
