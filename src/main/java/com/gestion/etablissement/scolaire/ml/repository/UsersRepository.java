package com.gestion.etablissement.scolaire.ml.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Optional<Users> findUsersById(Long id);

	Optional<Users> findUsersByEmailAndPassword(String email, String password);

}
