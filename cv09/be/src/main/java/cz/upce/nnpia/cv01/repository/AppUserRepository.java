package cz.upce.nnpia.cv01.repository;

import cz.upce.nnpia.cv01.entity.AppUser;
import cz.upce.nnpia.cv01.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {

    @Query
    List<AppUser> findByActive(Boolean active);

    @Query("SELECT distinct u.id,u.active,u.password,u.creationDate,u.updateDate,u.username from AppUser u join u.role r where r.id=:roleId")
    Set<Object> findAppUsersByRole(Integer roleId);
}
