package com.CourseScheduleBuilder.Model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean EWT;
    private ArrayList<String> prereqs = new ArrayList<>();
    @Transient
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;



    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEWT() {
        return EWT;
    }

    public void setEWT(boolean EWT) {
        this.EWT = EWT;
    }

    public void addToPrereqs(String prereq){
        this.prereqs.add(prereq);
    }

    public ArrayList<String> getPrereqs() {
        return prereqs;
    }

    @Override
    public String toString() {
        return "CourseDb{" +
                "id=" + id +
                ", First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", Username Address='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
