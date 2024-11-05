package dev.abinesh.handler;

import dev.abinesh.entity.User;
import dev.abinesh.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> saveUser(ServerRequest request) {
        return request.bodyToMono(User.class)
                .flatMap(userService::saveUser)
                .flatMap(savedUser -> ServerResponse.status(HttpStatus.CREATED).bodyValue(savedUser))
                .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).bodyValue("Error saving user"));
    }

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().bodyValue("Hello World");
    }

    public Mono<ServerResponse> login(ServerRequest request) {
        return request.bodyToMono(User.class)
                .flatMap(userService::verify)
                .flatMap(user -> ServerResponse.ok().bodyValue(user));
    }
}
