package com.yyy;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.yyy.mapper")           //扫描：mapper包的路径
public class Application {
//    // http 请求端口，线上配置为 80
//    @Value("${myHttp}")
//    private int serverPortHttp;
//
//    // 服务器运行端口，等同于 HTTPS 请求端口，线上 443
//    @Value("${server.port}")
//    private int serverPortHttps;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    /**
//     * http重定向到https （部署上线：请打开注释）
//     */
//    @Bean
//    public TomcatServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat;
//        tomcat = new TomcatServletWebServerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint constraint = new SecurityConstraint();
//                constraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                constraint.addCollection(collection);
//                context.addConstraint(constraint);
//            }
//        };
//        tomcat.addAdditionalTomcatConnectors(httpConnector());
//
//        return tomcat;
//    }
//
//    /**
//     * （部署上线：请打开注释）
//     * @return
//     */
//    @Bean
//    public Connector httpConnector() {
//        Connector connector = new Connector(Http11NioProtocol.class.getName());
//        connector.setScheme("http");
//        //Connector监听的http的端口号
//        connector.setPort(serverPortHttp);           //默认设置：80
//        connector.setSecure(false);
//        //监听到http的端口号后转向到的https的端口号
//        connector.setRedirectPort(serverPortHttps);   // 默认设置：443
//        return connector;
//    }

}
