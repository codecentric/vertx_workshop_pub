package de.codecentric.vertx.serviceproxy;

import de.codecentric.vertx.serviceproxy.demo.ProxyDemoService;
import io.vertx.core.AbstractVerticle;
import io.vertx.serviceproxy.ProxyHelper;

/**
 * Created by jmader on 03.07.15.
 */
public class MainVerticle extends AbstractVerticle{
    @Override
    public void start() throws Exception {
        ProxyHelper.registerService(ProxyDemoService.class, vertx, ProxyDemoService.create(vertx), "vertx.processor");
    }
}
