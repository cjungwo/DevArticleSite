package org.visiondeveloper.devarticlesite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.visiondeveloper.devarticlesite.domain.UserAccount;

@RepositoryRestResource
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
