package com.currencyconverter.services.springdatajpa;

import com.currencyconverter.model.Role;
import com.currencyconverter.repositories.RoleRepository;
import com.currencyconverter.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleSDJpaService implements RoleService {

    RoleRepository roleRepository;

    public RoleSDJpaService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(Long aLong) {
        return roleRepository.findById(aLong).orElse(null);
    }

    @Override
    public Role save(Role object) {
        return roleRepository.save(object);
    }

    @Override
    public void delete(Role object) {
        roleRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        roleRepository.deleteById(aLong);
    }

    @Override
    public Set<Role> findAll() {
        Set<Role> roles = new HashSet<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }
}
