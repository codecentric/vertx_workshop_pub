package de.codecentric.vertx.eventbus.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.DeliveryOptions;

import static de.codecentric.vertx.eventbus.demo.CounterVerticle.HEADER;
import static de.codecentric.vertx.eventbus.demo.CounterVerticle.ADDRESS_COUNTER;

/**
 * Created by jmader on 03.07.15.
 */
public class Sender2Verticle extends AbstractVerticle{
    @Override
    public void start() throws Exception {
        vertx.setPeriodic(300, delay -> vertx.eventBus()
                .send(ADDRESS_COUNTER, "wuhu", new DeliveryOptions().addHeader(HEADER, "2")));
    }
}
