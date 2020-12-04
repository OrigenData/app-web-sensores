package com.system.count.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.system.count.model.Usuarios;
import com.system.count.repository.UserRolRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRolRepository repository;

	@Autowired
	private UserRolRepository admrepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<Usuarios> rolUsersList = repository.findUser(userName);
		List<Usuarios> rolAdminList = admrepository.findAdmin(userName);

		if (rolUsersList != null && rolUsersList.size() == 1) {
			Usuarios users = rolUsersList.get(0);

			System.out.println("Clase UserDetailsServiceImpl ===> " + users.getNombre());

			return User.builder().username(users.getUsername())
					// change here to store encoded password in db
					.password(bCryptPasswordEncoder.encode(users.getPassword())).roles("CLIENTE").build();

		} else if (rolAdminList != null && rolAdminList.size() == 1) {

			Usuarios users = rolAdminList.get(0);

			return User.builder().username(users.getUsername())
					// change here to store encoded password in db
					.password(bCryptPasswordEncoder.encode(users.getPassword())).roles("ADMIN").build();

		} else {
			throw new UsernameNotFoundException("User Name is not Found");
		}
	}

}
