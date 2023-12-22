package com.lcws.electronic.store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private java.lang.String userId;

    @Column(name="user_name")
    private String name;

    @Column(name="user_email",unique = true)
    private String email;

    @Column(name="user_password",length = 10)
    private String password;
    private String gender;

    @Column(length = 500)
    private String about;

    @Column(name="user_image_name")
    private String imageName;

}
