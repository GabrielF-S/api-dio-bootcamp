package br.com.gabriel.api_dio_bootcamp.service.impl;

import br.com.gabriel.api_dio_bootcamp.domain.model.User;
import br.com.gabriel.api_dio_bootcamp.domain.repository.UserRepository;
import br.com.gabriel.api_dio_bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User userById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (repository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account Number id already exists.");
        }
        return repository.save(user);
    }
}
