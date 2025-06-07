package cn.iocoder.yudao.module.iot.plugin.tcp.downstream;
import cn.hutool.json.JSONUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.iot.api.device.dto.control.downstream.*;
import cn.iocoder.yudao.module.iot.plugin.common.downstream.IotDeviceDownstreamHandler;
import lombok.extern.slf4j.Slf4j;
import static cn.iocoder.yudao.module.iot.enums.ErrorCodeConstants.MQTT_TOPIC_ILLEGAL;

/**
 * EMQX 插件的 {@link IotDeviceDownstreamHandler} 实现类
 *
 * @author 芋道源码
 */
@Slf4j
public class IotDeviceDownstreamHandlerImpl implements IotDeviceDownstreamHandler {


    @Override
    public CommonResult<Boolean> invokeDeviceService(IotDeviceServiceInvokeReqDTO reqDTO) {
        log.info("[invokeService][开始调用设备服务][reqDTO: {}]", JSONUtil.toJsonStr(reqDTO));
        return CommonResult.error(MQTT_TOPIC_ILLEGAL.getCode(), MQTT_TOPIC_ILLEGAL.getMsg());
    }

    @Override
    public CommonResult<Boolean> getDeviceProperty(IotDevicePropertyGetReqDTO getReqDTO) {
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> setDeviceProperty(IotDevicePropertySetReqDTO reqDTO) {
        // 验证参数
        return CommonResult.success(true);

    }

    @Override
    public CommonResult<Boolean> setDeviceConfig(IotDeviceConfigSetReqDTO setReqDTO) {
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> upgradeDeviceOta(IotDeviceOtaUpgradeReqDTO upgradeReqDTO) {
        return CommonResult.success(true);
    }



}