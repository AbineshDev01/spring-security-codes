package dev.abinesh.config;

import dev.abinesh.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> userRouter(UserHandler userHandler) {
        return route(POST("/register"), userHandler::saveUser)
                .andRoute(GET("/hello"), userHandler::hello)
                .andRoute(POST("/login"), userHandler::login);
    }
}
