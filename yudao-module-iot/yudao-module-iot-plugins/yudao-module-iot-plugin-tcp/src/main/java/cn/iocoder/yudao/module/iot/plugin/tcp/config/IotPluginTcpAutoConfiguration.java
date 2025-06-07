package cn.iocoder.yudao.module.iot.plugin.tcp.config;

import cn.iocoder.yudao.module.iot.api.device.IotDeviceUpstreamApi;
import cn.iocoder.yudao.module.iot.plugin.common.downstream.IotDeviceDownstreamHandler;
import cn.iocoder.yudao.module.iot.plugin.tcp.downstream.IotDeviceDownstreamHandlerImpl;
import cn.iocoder.yudao.module.iot.plugin.tcp.service.IotTcpServer;
import cn.iocoder.yudao.module.iot.plugin.tcp.upstream.IotDeviceUpstreamServer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * IoT 插件 HTTP 的专用自动配置类
 *
 * @author haohao
 */
@Configuration
@EnableConfigurationProperties(IotPluginTcpProperties.class)
public class IotPluginTcpAutoConfiguration {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public IotDeviceUpstreamServer deviceUpstreamServer(IotDeviceUpstreamApi deviceUpstreamApi,
                                                        IotPluginTcpProperties properties) {
        return new IotDeviceUpstreamServer(properties, deviceUpstreamApi);
    }

    @Bean
    public IotDeviceDownstreamHandler deviceDownstreamHandler() {
        return new IotDeviceDownstreamHandlerImpl();
    }

    @Bean
    public IotTcpServer getIotTcpServer(IotPluginTcpProperties properties){
        return new IotTcpServer(properties);
    }
}
