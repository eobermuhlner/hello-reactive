package ch.obermuhlner.reactive.client;

import ch.obermuhlner.reactive.domain.Person;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ClientApplication {

    WebClient webClient = WebClient.create("http://localhost:8080");

    public void run() {
        Mono<Person> personMono = webClient.get()
                .uri("/person")
                .retrieve()
                .bodyToMono(Person.class);

        personMono.subscribe(person -> {
            System.out.println("PERSON " + person);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClientApplication clientApplication = new ClientApplication();
        clientApplication.run();
    }
}
