package com.api.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users_role")
@IdClass(UserRoleId.class)
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    @Column(name="role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private Usuario user;
}
