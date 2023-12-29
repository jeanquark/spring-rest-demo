package com.webtoucan.restdemo.controller;

import com.webtoucan.restdemo.model.CloudVendor;
import com.webtoucan.restdemo.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }



    // Read specific cloud vendor details from DB
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        return cloudVendorService.getCloudVendor(vendorId);
    }

    // Read all cloud vendor details from DB
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails()
    {
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor created successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor updated successfully";
    }

    @PatchMapping("{vendorId}")
    public String updateCloudVendorDetailsById(@PathVariable("vendorId") String vendorId, @RequestBody Map<Object,Object> objectMap)
    {
        cloudVendorService.updateCloudVendorWithMap(vendorId, objectMap);
        return "Cloud Vendor partially updated successfully";
    }

    @PatchMapping("{vendorId}/{vendorName}")
    public String updateCloudVendorDetailsById(@PathVariable("vendorId") String vendorId, @PathVariable("vendorName") String vendorName)
    {
        cloudVendorService.updateCloudVendorName(vendorId, vendorName);
        return "Cloud Vendor name updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        cloudVendorService.deleteCloudVendor(vendorId);

        return "Cloud Vendor deleted successfully";
    }
}
