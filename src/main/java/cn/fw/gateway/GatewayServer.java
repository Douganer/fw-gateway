package cn.fw.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关 Server
 *
 * @author demo
 * @date 2019-05-20
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServer {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServer.class, args);
    }

}
