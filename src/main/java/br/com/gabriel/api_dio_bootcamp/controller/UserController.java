package br.com.gabriel.api_dio_bootcamp.controller;

import br.com.gabriel.api_dio_bootcamp.domain.model.User;
import br.com.gabriel.api_dio_bootcamp.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default server URL")})
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.userById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User userToCreate){
        User userCreated = service.create(userToCreate);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userToCreate.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(userCreated);
    }

}
