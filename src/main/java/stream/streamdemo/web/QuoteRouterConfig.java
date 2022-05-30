package stream.streamdemo.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class QuoteRouterConfig {
    public static final String QUOTES = "/quotes";

    @Bean
    public RouterFunction<ServerResponse> quoteRoutes(QuoteHandler handler) {
        return route().GET(QUOTES, RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::fetchQuotes)
                .GET(QUOTES, RequestPredicates.accept(MediaType.APPLICATION_NDJSON), handler::streamQuotes)
                .build();
    }
}
