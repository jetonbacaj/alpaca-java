package net.jacobpeterson.alpaca.util.sse;

import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link SSEListenerAdapter} and adapter for {@link SSEListener}.
 *
 * @param <T> the data type
 */
public class SSEListenerAdapter<T> implements SSEListener<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SSEListenerAdapter.class);

    public void onOpen() {
        LOGGER.info("SSE connection opened.");
    }

    public void onClose() {
        LOGGER.info("SSE connection closed.");
    }

    public void onFailure(@Nullable Throwable throwable, @Nullable Response response) {
        LOGGER.error("SSE connection failed! {}", response, throwable);
    }

    public void onEvent(@NotNull T data) {
        LOGGER.info("SSE event received: {}", data);
    }
}
