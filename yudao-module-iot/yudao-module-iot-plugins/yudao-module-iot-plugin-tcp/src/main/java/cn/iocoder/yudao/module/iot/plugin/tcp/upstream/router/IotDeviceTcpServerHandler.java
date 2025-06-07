package cn.iocoder.yudao.module.iot.plugin.tcp.upstream.router;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetServer;
import io.vertx.ext.web.RoutingContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class IotDeviceTcpServerHandler implements Handler<RoutingContext> {

    @Override
    public void handle(RoutingContext routingContext) {
        
    }
}
