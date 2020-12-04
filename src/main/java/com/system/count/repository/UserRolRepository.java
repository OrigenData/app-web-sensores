package com.system.count.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.count.model.Usuarios;

@Repository
public interface UserRolRepository extends JpaRepository<Usuarios, Long>{
	
	@Query("SELECT u FROM Usuarios u WHERE u.username = :username and u.rol='CLIENTE'")
    public List<Usuarios> findUser(@Param("username") String username);

    @Query("SELECT u FROM Usuarios u WHERE u.username = :username and u.rol='ADMIN'")
    public List<Usuarios> findAdmin(@Param("username") String username);

}
