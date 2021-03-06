package ee.sda.javaest1blog.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class User {

    @GeneratedValue
    @Id
    Long id;
    String username;
    String password;
    String email;
    Date created;
    Date lastLogin;
    String firstName;
    String lastName;
    @OneToMany(mappedBy = "user")
    List<Post> postList;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    List<Role> roles;
}
