package com.ojt.homeworkfive;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="persons")
public class Person{


    @Id
    @Column(name="Person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @OneToMany(mappedBy="person", cascade = CascadeType.ALL)
    private List<ContactInformation> contactInfos = new ArrayList<>();

    public Person(){
        super();
    }

    public Person(String firstName, String lastName){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setList(List<ContactInformation> contactInfos){
        this.contactInfos = contactInfos;
    }

    public List<ContactInformation> getContactInfoList(){
        return this.contactInfos;
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