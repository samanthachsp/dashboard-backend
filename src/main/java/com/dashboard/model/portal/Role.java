package com.dashboard.model.portal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Getter @Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String name;

//    @ManyToMany(mappedBy ="userRoles")
//    Set<User> users;
    /*public Role(RoleEnum name) {
        this.name = name;
    }*/

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(	name = "role_resource",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "resource_id"))
//    private Set<Resource> resources = new HashSet<>();
}