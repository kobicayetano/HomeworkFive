package com.ojt.homeworkfive;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;
/** 
 * 
 *  Titles:
 * 			user
 * 			admin
 * 
 * **/

@Entity
public class Role{

	@Id
	@Column(name="role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title", unique=true)
	private String title;

	@ManyToMany(mappedBy = "role", cascade = CascadeType.ALL)
	Set<Person> person = new HashSet<Person>();  

	public Role(){
		super();
	}

	public Role(String title){
		this.title = title;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return this.id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}


    public void setPersonSet(Set <Person> person){
        this.person = person;
    }

     public Set<Person> getRoleSet(){
        return this.person;
    }




}