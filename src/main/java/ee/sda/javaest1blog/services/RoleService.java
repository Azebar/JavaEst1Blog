package ee.sda.javaest1blog.services;

import ee.sda.javaest1blog.entities.Role;
import ee.sda.javaest1blog.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleService {
    final RoleRepository roleRepository;

    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
