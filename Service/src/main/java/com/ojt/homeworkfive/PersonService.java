package com.ojt.homeworkfive;

public interface PersonService 
{
    public abstract void createPerson(Person person);
    public abstract Person getPersonById(int personId);
    public abstract void updatePersonLastnameById(int personId, String newLastname);
    public abstract void deletePersonById(int personId);
    public abstract void deletePersonRoleById(int personId, int roleId);
}
