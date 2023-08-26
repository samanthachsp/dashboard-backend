package com.dashboard.model.portal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user_authorization")
@Getter @Setter
public class UserAuthorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonBackReference
	User user;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private UserGroup group;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

	public UserGroup getGroup() {
		return group;
	}

}

