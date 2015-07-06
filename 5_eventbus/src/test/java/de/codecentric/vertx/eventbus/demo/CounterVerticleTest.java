package de.codecentric.vertx.eventbus.demo;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.TestContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by jmader on 05.07.15.
 */

@RunWith(io.vertx.ext.unit.junit.VertxUnitRunner.class)
public class CounterVerticleTest {

    @Before
    public void setUp(TestContext context) throws Exception{
        Vertx.vertx().deployVerticle(CounterVerticle.class.getName(), context.asyncAssertSuccess());
    }

}
