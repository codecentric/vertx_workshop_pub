package de.codecentric.vertx.eventbus.demo;

import io.vertx.core.AbstractVerticle;

/**
 * Created by jmader on 03.07.15.
 */
public class DemoVerticle extends AbstractVerticle{
    @Override
    public void start() throws Exception {
        System.out.println("Started!");
    }
}
