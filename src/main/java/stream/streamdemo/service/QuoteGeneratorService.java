package stream.streamdemo.service;

import reactor.core.publisher.Flux;
import stream.streamdemo.model.Quote;

import java.time.Duration;

public interface QuoteGeneratorService {
    Flux<Quote> fetchQuoteStream(Duration period);
}
