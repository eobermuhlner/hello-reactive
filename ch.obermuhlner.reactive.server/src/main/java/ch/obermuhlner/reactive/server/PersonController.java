package ch.obermuhlner.reactive.server;

import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import ch.obermuhlner.reactive.domain.Person;

@RestController
public class PersonController {

    @GetMapping("/person")
    public Publisher<Person> home() {
        return Mono.just(new Person("Eric"));
    }
}
