package de.codecentric.vertx.intro;

import io.vertx.core.Vertx;

/**
 * Created by jmader on 26.06.15.
 */
public class VertxMain {
    public static void main(String[] args) throws Exception{
        Vertx.vertx().deployVerticle(DemoVerticle.class.getName());
    }
}
