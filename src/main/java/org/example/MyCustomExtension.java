package org.example;
import io.confluent.kafkarest.KafkaRestConfig;
import io.confluent.kafkarest.extension.RestResourceExtension;
import io.confluent.kafkarest.response.TestMessageBody;

import javax.ws.rs.core.Configurable;

public class MyCustomExtension implements RestResourceExtension{
    @Override
    public void register(Configurable<?> config, KafkaRestConfig appConfig) {
//        config.register(new DoNotReturn());
        config.register(new TestMessageBody());
    }

    @Override
    public void clean() {

    }
}