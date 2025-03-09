package br.com.gabriel.api_dio_bootcamp.service;

import br.com.gabriel.api_dio_bootcamp.domain.model.User;

public interface UserService {

    User userById(Long id);

    User create(User user);
}
