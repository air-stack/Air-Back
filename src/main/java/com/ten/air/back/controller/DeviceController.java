package com.ten.air.back.controller;

import com.ten.air.back.entity.AirDevice;
import com.ten.air.back.model.ResponseCode;
import com.ten.air.back.model.ResultModel;
import com.ten.air.back.service.AirDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/air/device")
public class DeviceController extends BaseController<AirDevice> {

    private final AirDeviceService service;

    @Autowired
    public DeviceController(AirDeviceService service) {
        this.service = service;
    }

    @Override
    public ResultModel get(AirDevice airDevice) {
        List<AirDevice> deviceList = service.select(airDevice);
        return new ResultModel(ResponseCode.OK, deviceList);
    }

    @Override
    public ResultModel post(AirDevice airDevice) {
        Integer result = service.insert(airDevice);
        return new ResultModel(ResponseCode.OK, result);
    }

    @Override
    public ResultModel update(AirDevice airDevice) {
        Integer result = service.update(airDevice);
        return new ResultModel(ResponseCode.OK, result);
    }

    @Override
    public ResultModel delete(AirDevice airDevice) {
        Integer result = service.update(airDevice);
        return new ResultModel(ResponseCode.OK, result);
    }
}
