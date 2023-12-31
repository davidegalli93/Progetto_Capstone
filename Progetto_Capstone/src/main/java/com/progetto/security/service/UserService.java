package com.progetto.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.security.entity.User;
import com.progetto.security.repository.UserRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class UserService {
	
	@Autowired UserRepository repo;
	
	public List<User> getAll(){
		return repo.findAll();
	}
	
	public User getByUsername (String username) {
		if(!repo.existsByUsername(username)) {
			throw new EntityExistsException("Utente non esistente!!");
		}
		return repo.findByUsername(username).get();
	}
	
	public User update (Long id, User s) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Utente non esistente!!");
		}
		return repo.save(s);
	}
	
	public String delete (Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Utente non esistente!!");
		}
		repo.deleteById(id);
		return "Utente eliminato!!";
	}

}
