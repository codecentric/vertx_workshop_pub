package de.codecentric.vertx.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jmader on 06.07.15.
 */
public class FlakyDBVerticle extends AbstractVerticle{
    public static final String ADDRESS_DB = "db";

    public static final String JSON_ACTION = "action";
    public static final String JSON_KEY = "key";
    public static final String JSON_VALUE = "value";
    public static final String ACTION_PUT = "put";
    public static final String ACTION_DELETE = "delete";
    public static final String ACTION_GET = "get";

    private Map<String, String> keyValueStore = new HashMap<>();

    private boolean stopped = false;

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.eventBus().<JsonObject>consumer(ADDRESS_DB, req -> {
            if (!stopped) {
                JsonObject body = req.body();
                switch (body.getString(JSON_ACTION)) {
                    case ACTION_GET: req.reply(keyValueStore.get(body.getString(JSON_KEY)));break;
                    case ACTION_PUT: keyValueStore.put(body.getString(JSON_KEY), body.getString(JSON_VALUE));
                                     req.reply(true);break;
                    case ACTION_DELETE: req.reply(keyValueStore.remove(body.getString(JSON_KEY)) != null);break;
                }
            }
        });

        vertx.setPeriodic(2000, period -> stopped = !stopped);
    }
}
