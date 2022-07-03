package com.ojt.homeworkfive;

import javax.persistence.*;

@Entity
@Table(name="contactinfo")
public class ContactInformation{

	@Id
	@Column(name="contact_info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="mobile_number")
    private String mobileNumber;

    @ManyToOne
    @JoinColumn(name="Person_id", insertable = true, updatable = true)
    private Person person;

    public ContactInformation(){
    	super();
    }

    public ContactInformation(String mobileNumber, Person person){
    	super();
    	this.mobileNumber = mobileNumber;
    	this.person = person;
    }


    public int getId(){
    	return this.id;
    }

    public void setId(int id){
    	this.id = id;
    }

    public String getMobileNumber(){
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    public Person getPerson(){
    	return this.person;
    }

    public void setPerson(Person person){
    	this.person = person;
    }

}