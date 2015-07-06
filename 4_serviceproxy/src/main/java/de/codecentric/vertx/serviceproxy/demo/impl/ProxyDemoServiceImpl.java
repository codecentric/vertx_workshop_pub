package de.codecentric.vertx.serviceproxy.demo.impl;

import de.codecentric.vertx.serviceproxy.demo.ProxyDemoService;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * Created by jmader on 03.07.15.
 */
public class ProxyDemoServiceImpl implements ProxyDemoService{

    private Vertx vertx;

    public ProxyDemoServiceImpl(Vertx vertx) {
        this.vertx = vertx;
    }

    @Override
    public void save(String collection, JsonObject document, Handler<AsyncResult<Void>> resultHandler) {
        System.out.println("saving "+document);
        resultHandler.handle(Future.succeededFuture());
    }

    @Override
    public void close() {

    }
}
