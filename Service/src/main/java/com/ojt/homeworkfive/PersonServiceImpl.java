package com.ojt.homeworkfive;

public class PersonServiceImpl implements PersonService{

	@Override
	public void createPerson(Person person){
		new PersonDAOImpl().addPerson(person);
	}

	@Override
    public Person getPersonById(int personId){
    	return new PersonDAOImpl().fetchPerson(personId);
    }

    @Override
    public void updatePersonLastnameById(int personId, String newLastname){
    	new PersonDAOImpl().updatePersonLastnameById(personId, newLastname);
    }

    @Override
    public void deletePersonById(int personId){
    	new PersonDAOImpl().deletePersonById(personId);
    }

}