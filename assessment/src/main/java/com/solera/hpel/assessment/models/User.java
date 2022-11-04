package com.solera.hpel.assessment.models;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "andresGoncalvesTable")


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class User {

    @Id
    @Column(nullable = true)
    private long id;
    @Column(nullable = true, length = 25)
    private String firstName;
    @Column(nullable = true, length = 25)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    @Column(nullable = true, length = 20)
    private String phoneNumber;

    @Column(nullable = true, length = 25)
    @Email
    private String email;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override public int hashCode() {
        return Objects.hash( id, firstName, lastName, email);
    }



}
