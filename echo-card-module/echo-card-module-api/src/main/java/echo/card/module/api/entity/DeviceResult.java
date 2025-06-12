package echo.card.module.api.entity;

import lombok.Data;

@Data
public class DeviceResult {
    private Integer slaveId;
    private String clientId;
    private String userName;
    private String deviceKey;
}
