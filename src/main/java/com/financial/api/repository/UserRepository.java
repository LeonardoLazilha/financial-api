package com.financial.api.repository;

import com.financial.api.model.Lancamento;
import com.financial.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);
}
