package de.codecentric.vertx.intro;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;

/**
 * Created by jmader on 26.06.15.
 */
public class DemoVerticle extends AbstractVerticle{

    public static final String CONFIG_PORT = "port";

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        HttpServer httpServer = vertx.createHttpServer();
        httpServer.requestHandler(request -> {
            if (request.method().equals(HttpMethod.GET)) request.response().end("Hello World");
            else request.response().setStatusCode(HttpResponseStatus.NOT_IMPLEMENTED.code()).end("Whut?");
        }).listen(config().getInteger(CONFIG_PORT, 8070), result -> {
            if (result.succeeded()) startFuture.complete();
            else startFuture.fail(result.cause());
        });
    }
}
