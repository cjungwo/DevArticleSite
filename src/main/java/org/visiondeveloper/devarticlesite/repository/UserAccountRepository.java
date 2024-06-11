package org.visiondeveloper.devarticlesite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visiondeveloper.devarticlesite.domain.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}