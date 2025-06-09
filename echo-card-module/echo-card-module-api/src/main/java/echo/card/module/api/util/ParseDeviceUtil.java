package echo.card.module.api.util;

import cn.hutool.core.util.StrUtil;
import echo.card.module.api.entity.DeviceResult;

public class ParseDeviceUtil {
    public static DeviceResult getIotDeviceInfo(String username, String clientId,String productKey) {

        DeviceResult deviceResult = new DeviceResult();
        deviceResult.setUserName(username);
        deviceResult.setClientId(clientId);
        if (StrUtil.startWith(clientId, "GW_")) {
            deviceResult.setUserName(clientId+"&"+productKey);
            deviceResult.setClientId(productKey+"."+clientId);
        }
        return deviceResult;
    }
}
