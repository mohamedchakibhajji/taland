/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author Amine
 */
public class user {
    private int id;
    private String username;
    private String email;
    private String password;
    private String roles;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String picture;
    private String sexe;
    private int rating=0;
    private String biography;
    private int strike;
    private String status;
    
    

    public user() {
    }

    public user(int id, String username, String email, String password, String roles, String firstname, String lastname, String birthdate, String picture, String sexe, String biography, int strike, String status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.picture = picture;
        this.sexe = sexe;
        this.biography = biography;
        this.strike = strike;
        this.status = status;
        
    }

    public user(int id, String username, String email, String firstname, String lastname, String birthdate, String sexe, String biography) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.sexe = sexe;
        this.biography = biography;
    }
    
    



    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getPicture() {
        return picture;
    }

    public String getSexe() {
        return sexe;
    }

    public int getRating() {
        return rating;
    }

    public String getBiography() {
        return biography;
    }

    public int getStrike() {
        return strike;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", roles=" + roles + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate + ", picture=" + picture + ", sexe=" + sexe + ", rating=" + rating + ", biography=" + biography + ", strike=" + strike + ", status=" + status + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final user other = (user) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.rating != other.rating) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.birthdate, other.birthdate)) {
            return false;
        }
        if (!Objects.equals(this.picture, other.picture)) {
            return false;
        }
        if (!Objects.equals(this.sexe, other.sexe)) {
            return false;
        }
        if (!Objects.equals(this.biography, other.biography)) {
            return false;
        }
        if (!Objects.equals(this.strike, other.strike)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
