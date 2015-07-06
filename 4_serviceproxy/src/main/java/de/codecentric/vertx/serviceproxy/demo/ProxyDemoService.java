package de.codecentric.vertx.serviceproxy.demo;

import de.codecentric.vertx.serviceproxy.demo.impl.ProxyDemoServiceImpl;
import io.vertx.codegen.annotations.ProxyClose;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * Created by jmader on 03.07.15.
 */
@ProxyGen
public interface ProxyDemoService {
    static ProxyDemoService create(Vertx vertx) {
        return new ProxyDemoServiceImpl(vertx);
    }

    static ProxyDemoService createProxy(Vertx vertx, String address) {
        return new ProxyDemoServiceVertxEBProxy(vertx, address);
    }

    void save(String collection, JsonObject document, Handler<AsyncResult<Void>> resultHandler);

    @ProxyClose
    void close();

}
