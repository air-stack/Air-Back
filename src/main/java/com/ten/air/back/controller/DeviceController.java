package com.ten.air.back.controller;

import com.ten.air.back.entity.AirDevice;
import com.ten.air.back.model.ResponseCode;
import com.ten.air.back.model.ResultModel;
import com.ten.air.back.service.AirDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Device 设备控制器
 */
@RestController
@RequestMapping(value = "/air/device")
public class DeviceController extends BaseController<AirDevice> {
    private static final Logger logger = Logger.getLogger("Device");

    private final AirDeviceService service;

    @Autowired
    public DeviceController(AirDeviceService service) {
        this.service = service;
    }

    /**
     * 获取AirDevice设备信息
     */
    @Override
    public ResultModel get(AirDevice airDevice) {
        logger.info("DEVICE GET :" + airDevice);

        // 设置查询条件
        airDevice.setIsDeleted(NO_DELETED);

        List<AirDevice> deviceList = service.select(airDevice);
        return new ResultModel(ResponseCode.OK, deviceList);
    }

    /**
     * 创建或者更新AirDevice设备信息
     */
    @Override
    public ResultModel post(@RequestBody AirDevice airDevice) {
        logger.info("DEVICE POST :" + airDevice);

        AirDevice entity = new AirDevice();
        entity.setImei(airDevice.getImei());
        entity.setIsDeleted(NO_DELETED);

        List<AirDevice> devices = service.select(entity);
        Integer result;
        String time = timeGenerator.currentTime();
        // 设备已存在 -> 更新状态
        if (devices.size() > 0) {
            entity.setId(devices.get(0).getId());
            entity.setDeviceStatus(1);
            entity.setBjUpdateTime(time);
            entity.setLastOnlineTime(time);
            result = service.update(entity);
        }
        // 设备不存在 -> 创建设备
        else {
            // 新增设备属性
            airDevice.setAlias("新增嵌入式设备");
            airDevice.setDeviceStatus(1);
            airDevice.setBjCreateTime(time);
            airDevice.setLastOnlineTime(time);
            airDevice.setIsDeleted(NO_DELETED);
            result = service.insert(airDevice);
        }

        if (result > 0) {
            return new ResultModel(ResponseCode.OK, airDevice);
        }
        return new ResultModel(ResponseCode.ERROR, airDevice);
    }

    /**
     * TODO 更新记录信息
     */
    @Override
    public ResultModel update(AirDevice airDevice) {
        logger.info("DEVICE UPDATE :" + airDevice);
        Integer result = service.update(airDevice);
        return new ResultModel(ResponseCode.OK, result);
    }

    /**
     * TODO 删除
     */
    @Override
    public ResultModel delete(AirDevice airDevice) {
        logger.info("DEVICE DELETE :" + airDevice);
        Integer result = service.update(airDevice);
        return new ResultModel(ResponseCode.OK, result);
    }
}
