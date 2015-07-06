package de.codecentric.vertx.eventbus;

import de.codecentric.vertx.eventbus.demo.CounterVerticle;
import de.codecentric.vertx.eventbus.demo.Sender1Verticle;
import de.codecentric.vertx.eventbus.demo.Sender2Verticle;
import io.vertx.core.AbstractVerticle;

/**
 * Created by jmader on 03.07.15.
 */
public class MainVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        vertx.deployVerticle(CounterVerticle.class.getName());
        vertx.deployVerticle(Sender1Verticle.class.getName());
        vertx.deployVerticle(Sender2Verticle.class.getName());
    }
}
