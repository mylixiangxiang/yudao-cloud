package cn.iocoder.yudao.module.iot.plugin.tcp.service;

import cn.iocoder.yudao.module.iot.plugin.tcp.config.IotPluginTcpProperties;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.SocketAddress;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class IotTcpServer {

    public IotTcpServer(IotPluginTcpProperties properties) {
        startTcpServer(properties);
    }

    void startTcpServer(IotPluginTcpProperties properties) {
        Vertx vertx = Vertx.vertx();
        // 创建TCP服务器
        NetServer server = vertx.createNetServer();

        // 处理连接 (等效于ChannelHandler)
        server.connectHandler(socket -> {

            log.info("Connect From :"+socket.remoteAddress());
            // 接收数据 (等效于channelRead)
            socket.handler(buffer -> {
                String registerPacket = buffer.toString().trim();
                System.out.println("Received: " + buffer.toString());
//                if (!"726567".equals(registerPacket)) {
//                    socket.close();
//                    log.warn("无效注册包来自: {}", socket.remoteAddress());
//                    return;
//                }
                // 发送响应 (等效于writeAndFlush)
                socket.write(Buffer.buffer("Hello from Vert.x\n"));
            });


            // 连接关闭处理 (等效于channelInactive)
            socket.closeHandler(v -> {
                System.out.println("Connection closed");
            });
        });

        // 监听端口 (等效于bind)
        int port = properties.getServerPort();
        server.listen(port, "0.0.0.0", res -> {
            if (res.succeeded()) {
                System.out.println("Server started on port 8080");
            } else {
                System.err.println("Failed to start: " + res.cause());
            }
        });
    }
}
