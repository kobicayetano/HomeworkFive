package com.ojt.homeworkfive;


public interface PersonDAO 
{
    public abstract void addPerson(Person person);
    public abstract Person fetchPerson(int personId);
    public abstract void updatePersonLastnameById(int personId, String newLastname);
    public abstract void deletePersonById(int personId);
}
