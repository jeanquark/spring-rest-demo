package com.webtoucan.restdemo.service;

import com.webtoucan.restdemo.model.CloudVendor;

import java.util.List;
import java.util.Map;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public void updateCloudVendorName(String cloudVendorId, String cloudVendorName);
    public void updateCloudVendorWithMap(String vendorId, Map<Object, Object> objectMap);
    public String deleteCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendor(String cloudVendorId);
    public List<CloudVendor> getAllCloudVendors();
}
