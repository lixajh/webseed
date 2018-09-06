package com.peake.webseed.feature.device.mapper;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.feature.device.model.Device;

public interface DeviceMapper extends Mapper<Device> {

    void batchDelete(Long ids[]);
}