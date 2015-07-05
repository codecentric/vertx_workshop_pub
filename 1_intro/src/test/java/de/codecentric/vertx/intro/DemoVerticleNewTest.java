package de.codecentric.vertx.intro;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.RunTestOnContext;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jmader on 26.06.15.
 */
@RunWith(io.vertx.ext.unit.junit.VertxUnitRunner.class)
public class DemoVerticleNewTest {

    @Rule
    public final RunTestOnContext rule = new RunTestOnContext(Vertx::vertx);

    @Before
    public void setUp(TestContext context) throws Exception{
        Vertx.vertx().deployVerticle(DemoVerticle.class.getName(), context.asyncAssertSuccess());
    }

    @Test
    public void containerTest(TestContext context) {
        Async async = context.async();
        Vertx.vertx().createHttpClient().get(8070, "localhost", "/", res -> {
            res.bodyHandler(body -> {
                context.assertEquals("Hello World", body.toString());
                async.complete();
            });
        }).end();
    }

}
