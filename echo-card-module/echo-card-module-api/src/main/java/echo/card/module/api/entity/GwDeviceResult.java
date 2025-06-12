package echo.card.module.api.entity;

import lombok.Data;

import java.util.List;

@Data
public class GwDeviceResult {
    private String gw;
    private String gateWayKey;
    private List<DeviceResult> devices;
}
