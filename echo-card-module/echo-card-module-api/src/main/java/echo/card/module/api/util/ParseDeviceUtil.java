package echo.card.module.api.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import echo.card.module.api.entity.DeviceResult;
import echo.card.module.api.entity.GwDeviceResult;

import java.util.List;

public class ParseDeviceUtil {
    public static DeviceResult getIotDeviceInfo(String username, String clientId,String productKey) {

        DeviceResult deviceResult = new DeviceResult();
        deviceResult.setUserName(username);
        deviceResult.setClientId(clientId);
        if (StrUtil.startWithAny(clientId, "GW_","EC_")) {
            deviceResult.setUserName(clientId+"&"+productKey);
            deviceResult.setClientId(productKey+"."+clientId);
        }
        return deviceResult;
    }

    public static GwDeviceResult getIotDeviceInfos(GwDeviceResult gwDeviceResult,String productKey) {

        if(gwDeviceResult == null || CollUtil.isEmpty(gwDeviceResult.getDevices())){
            return gwDeviceResult;
        }

        gwDeviceResult.getDevices().forEach(item->{
            String clientId = item.getClientId();
            String userName = clientId;
            DeviceResult deviceResult = getIotDeviceInfo(userName,clientId,productKey);
            item.setClientId(deviceResult.getClientId());
            item.setUserName(deviceResult.getUserName());
        });

        return gwDeviceResult;
    }
}
