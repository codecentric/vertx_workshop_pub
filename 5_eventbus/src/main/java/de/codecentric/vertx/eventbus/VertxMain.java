package de.codecentric.vertx.eventbus;

import io.vertx.core.Vertx;

/**
 * Created by jmader on 01.07.15.
 */
public class VertxMain {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(MainVerticle.class.getName());
    }
}
