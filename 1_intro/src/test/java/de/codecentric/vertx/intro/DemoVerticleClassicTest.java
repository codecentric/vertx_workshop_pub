package de.codecentric.vertx.intro;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.test.core.TestVerticle;
import io.vertx.test.core.VertxTestBase;
import org.junit.Before;
import org.junit.Test;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by jmader on 26.06.15.
 */
public class DemoVerticleClassicTest extends VertxTestBase{

    @Before
    public void setUpTest() {
        vertx.deployVerticle(DemoVerticle.class.getName());
        waitUntil(() -> vertx.deploymentIDs().size() == 1);
    }

    @Test
    public void containerTest() {
        vertx.createHttpClient().get(8070, "localhost", "/", res -> {
            res.bodyHandler(body -> {
                assertEquals("Hello World", body.toString());
                testComplete();
            });
        }).end();
        await();
    }

}
