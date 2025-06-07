package cn.iocoder.yudao.module.iot.plugin.tcp.upstream;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.module.iot.api.device.IotDeviceUpstreamApi;

import cn.iocoder.yudao.module.iot.plugin.tcp.config.IotPluginTcpProperties;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServer;
import io.vertx.core.net.NetServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * IoT 设备下行服务端，接收来自 device 设备的请求，转发给 server 服务器
 * <p>
 * 协议：HTTP、MQTT
 *
 * @author haohao
 */
@Slf4j
public class IotDeviceUpstreamServer {
    public IotDeviceUpstreamServer(IotPluginTcpProperties properties, IotDeviceUpstreamApi deviceUpstreamApi) {

    }

    public void start() {
    }

    public void stop(){
        log.info("IotDeviceUpstreamServer stop--->");
    }
}