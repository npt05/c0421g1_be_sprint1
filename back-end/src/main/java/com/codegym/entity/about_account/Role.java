package com.codegym.entity.about_account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Set<Account> accounts;

<<<<<<< HEAD
=======
    public Role(Integer roleId, String roleName, Set<Account> accounts) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.accounts = accounts;
    }

>>>>>>> manager_account
    public Role() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
