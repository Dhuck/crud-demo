package mx.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.crud.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
