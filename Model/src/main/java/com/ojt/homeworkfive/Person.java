package com.ojt.homeworkfive;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="first_name")
    String firstName;
    @Column(name="last_name")
    String lastName;

    public Person(){
        super();
    }

    public Person(String firstName, String lastName){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "Person [personId=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}   