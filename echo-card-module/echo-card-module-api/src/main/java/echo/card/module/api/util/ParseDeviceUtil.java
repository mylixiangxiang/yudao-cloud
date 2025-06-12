package echo.card.module.api.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import echo.card.module.api.entity.DeviceResult;
import echo.card.module.api.entity.GwDeviceResult;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ParseDeviceUtil {
    public static DeviceResult getIotDeviceInfo(String username, String clientId,String productKey) {

        DeviceResult deviceResult = new DeviceResult();
        deviceResult.setUserName(username);
        deviceResult.setClientId(clientId);
        if (StrUtil.startWithAny(clientId, "GW_","EC_")) {
            deviceResult.setUserName(clientId+"&"+productKey);
            deviceResult.setClientId(productKey+"."+clientId);
            deviceResult.setDeviceKey(clientId.split("_")[1]);
        }
        return deviceResult;
    }

    public static GwDeviceResult getIotDeviceInfos(GwDeviceResult gwDeviceResult,String productKey) {

        if(gwDeviceResult == null || CollUtil.isEmpty(gwDeviceResult.getDevices())){
            return gwDeviceResult;
        }

        gwDeviceResult.setGateWayKey(gwDeviceResult.getGw().split("GW_")[1]);
        gwDeviceResult.getDevices().forEach(item->{
            String clientId = item.getClientId();
            String userName = clientId;
            DeviceResult deviceResult = getIotDeviceInfo(userName,clientId,productKey);
            item.setClientId(deviceResult.getClientId());
            item.setUserName(deviceResult.getUserName());
            item.setDeviceKey(deviceResult.getDeviceKey());
        });

        return gwDeviceResult;
    }

    public static String[] parseUsername(String username) {
        if (StrUtil.isEmpty(username)) {
            return null;
        }
        String[] parts = username.split("&");
        if (parts.length != 2) {
            log.warn("[parseUsername][用户名格式({})不正确，无法解析产品标识和设备名称]", username);
            return null;
        }
        return parts;
    }

}
