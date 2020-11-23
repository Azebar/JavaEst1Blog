package ee.sda.javaest1blog.services;

import ee.sda.javaest1blog.configurations.JEBlogUserDetails;
import ee.sda.javaest1blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JEBlogUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new JEBlogUserDetails(userRepository.findByUsername(s));
    }
}
