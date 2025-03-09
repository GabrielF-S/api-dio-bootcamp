package br.com.gabriel.api_dio_bootcamp.domain.repository;

import br.com.gabriel.api_dio_bootcamp.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    boolean existsByAccountNumber(String accountNumber);
}
