package com.financial.api.repository;

import com.financial.api.model.Lancamento;
import com.financial.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
