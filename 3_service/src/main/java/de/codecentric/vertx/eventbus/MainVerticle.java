package de.codecentric.vertx.eventbus;

import io.vertx.core.AbstractVerticle;

/**
 * Created by jmader on 03.07.15.
 */
public class MainVerticle extends AbstractVerticle{
    @Override
    public void start() throws Exception {
        vertx.deployVerticle("service:de.codecentric.vertx.service.demo-service");
//        vertx.deployVerticle("service:de.codecentric.vertx.service.demo-serviceproxy", result -> {
//            ProxyDemoService.create(vertx).save("dfsdf", new JsonObject(), res2 -> {
//                System.out.println("DONE");
//            });
//        });
    }
}
