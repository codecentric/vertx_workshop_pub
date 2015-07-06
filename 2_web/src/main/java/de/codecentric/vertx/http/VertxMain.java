package de.codecentric.vertx.http;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

import java.util.Random;

/**
 * Created by jmader on 01.07.15.
 */
public class VertxMain {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        Router router = Router.router(vertx);
        SockJSHandler sockJSHandler = SockJSHandler.create(vertx);
        BridgeOptions options = new BridgeOptions().addOutboundPermitted(new PermittedOptions().setAddress("some-address"));
        sockJSHandler.bridge(options);
        router.route("/eventbus/*").handler(sockJSHandler);
        router.route("/static/*").handler(StaticHandler.create());
        vertx.createHttpServer().requestHandler(router::accept).listen(8090);
        Random random = new Random();
        vertx.setPeriodic(100, time -> {
            long currentTime = System.currentTimeMillis()/1000;
            vertx.eventBus().send("some-address", new JsonArray()
                    .add(new JsonObject().put("time",currentTime).put("y", random.nextInt(200)))
                    .add(new JsonObject().put("time", currentTime).put("y", random.nextInt(150)))
                    .add(new JsonObject().put("time", currentTime).put("y", random.nextInt(100)))
            );
        });
    }
}
