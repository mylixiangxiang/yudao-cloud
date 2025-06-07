package cn.iocoder.yudao.module.iot.plugin.tcp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "yudao.iot.plugin.tcp")
@Validated
@Data
public class IotPluginTcpProperties {

    /**
     * TCP 服务端口
     */
    private Integer serverPort;

}
