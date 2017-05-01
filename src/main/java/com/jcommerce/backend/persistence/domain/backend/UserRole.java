package com.jcommerce.backend.persistence.domain.backend;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Riyazuddin M on 5/1/2017.
 */
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

    /*The Serial Version UID constant for Serializable classes*/
    private static final long serialVersionUID = 1L;

    public UserRole() {  }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private  User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (!user.equals(userRole.user)) return false;
        return role.equals(userRole.role);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
