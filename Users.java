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
public class Users {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int role;
    private String birthdate;
    private String username;
    private String photo;
    private int rating;
    private String datecreation;
    private String biography;
    private int Strike=0;

    public Users() {
    }

    public Users(int id, String firstname, String lastname, String email, String password, int role, String birthdate, String username, String photo, int rating, String datecreation, String biography) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.birthdate = birthdate;
        this.username = username;
        this.photo = photo;
        this.rating = rating;
        this.datecreation = datecreation;
        this.biography = biography;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoto() {
        return photo;
    }

    public int getRating() {
        return rating;
    }

    public String getDatecreation() {
        return datecreation;
    }

    public String getBiography() {
        return biography;
    }

    public int getStrike() {
        return Strike;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDatecreation(String datecreation) {
        this.datecreation = datecreation;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setStrike(int Strike) {
        this.Strike = Strike;
    }
    
    

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", role=" + role + ", birthdate=" + birthdate + ", username=" + username + ", photo=" + photo + ", rating=" + rating + ", datecreation=" + datecreation + ", biography=" + biography + ", Strike=" + Strike + '}';
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
        final Users other = (Users) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }



    

    
    
    
    
    
}
