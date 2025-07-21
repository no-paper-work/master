/**
 * @package com.nopaper.work.master.config -> master
 * @author saikatbarman
 * @date 2025 16-Jul-2025 11:36:48 pm
 * @git 
 */
package com.nopaper.work.master.config;

/**
 * 
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class ReactiveLoggingFilter implements WebFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReactiveLoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        long startTime = System.currentTimeMillis();

        return chain.filter(exchange)
            .doOnSubscribe(subscription -> {
                // Equivalent to preHandle: Executes before the chain continues.
                LOGGER.info("Request received for {}: {}", exchange.getRequest().getMethod(), exchange.getRequest().getURI());
            })
            .doOnSuccess(aVoid -> {
                // Executes when the request is successfully handled (after response is committed).
                long duration = System.currentTimeMillis() - startTime;
                LOGGER.info("Request completed successfully in {} ms. Status: {}", duration, exchange.getResponse().getStatusCode());
            })
            .doOnError(throwable -> {
                // Equivalent to afterCompletion (with an exception): Executes if an error occurs.
                long duration = System.currentTimeMillis() - startTime;
                LOGGER.error("Request failed in {} ms. Error: {}", duration, throwable.getMessage());
            });
    }
}