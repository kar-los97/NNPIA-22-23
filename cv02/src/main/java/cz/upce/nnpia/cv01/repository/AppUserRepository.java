package cz.upce.nnpia.cv01.repository;

import cz.upce.nnpia.cv01.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {

    @Query
    List<AppUser> findByActive(Boolean active);
}
