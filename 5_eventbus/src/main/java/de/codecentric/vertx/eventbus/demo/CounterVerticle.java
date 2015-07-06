package de.codecentric.vertx.eventbus.demo;

import io.vertx.core.AbstractVerticle;

/**
 * Created by jmader on 03.07.15.
 */
public class CounterVerticle extends AbstractVerticle{
    public static final String ADDRESS_COUNTER = "counter";
    public static final String HEADER = "myheader";

    private int count1s = 0;
    private int count2s = 0;

    @Override
    public void start() throws Exception {
        vertx.eventBus().<String>consumer(ADDRESS_COUNTER, msg -> {
            if("1".equals(msg.headers().get(HEADER))) {
                count1s++;
            } else if("1".equals(msg.headers().get(HEADER))) {
                count2s++;
            }
        });

        vertx.setPeriodic(1000, tick -> {
            System.out.println("Result "+count1s+" "+count2s);
            count1s = 0;
            count2s = 0;
        });
    }


}
