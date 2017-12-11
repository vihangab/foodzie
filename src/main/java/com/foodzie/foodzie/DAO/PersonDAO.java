package com.foodzie.foodzie.DAO;

import com.foodzie.foodzie.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer> {

    Person person = new Person();

    public List<Person> findByPasswordIs(@Param("password") String password);

    public List<Person> findByNameIs(@Param("name") String name);

    public Person findByUsernameIs(@Param("username") String username);

    public Person findByIdIs(@Param("Id") Integer Id);

}
