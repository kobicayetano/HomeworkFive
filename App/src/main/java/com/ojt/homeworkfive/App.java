package com.ojt.homeworkfive;
import java.util.List;
import java.util.ArrayList;

public class App {

    static List<Person> personList = new ArrayList<>();

    public static void main( String[] args ){
        PersonService personService = new PersonServiceImpl();
        //Create multiple Person Object
        createPeopleProfile();
        createPerson(personService, personList.get(0));
        createPerson(personService, personList.get(1));
        createPerson(personService, personList.get(2));

        //getPersonById(personService, 1);
        //getPersonById(personService, 2);
        //getPersonById(personService, 3);

        //updatePersonById(personService, 1, "Yes Papa");
        //getPersonById(personService, 1);

        deletePersonById(personService, 2);
        //getPersonById(personService, 2);
        System.out.print("Hi!");
    }

    private static void deletePersonById(PersonService personService, int personId) {
        personService.deletePersonById(personId);
    }


    private static void updatePersonById(PersonService personService, int personId, String newName) {
        personService.updatePersonLastnameById(personId, newName);
    }

    public static void createPerson(PersonService personService, Person person){
        personService.createPerson(person);
    }

    public static void getPersonById(PersonService personService, int personId){
        Person person = personService.getPersonById(personId);
        System.out.println(person);
    }


    public static void createPeopleProfile(){
        Person person1 = new Person("John", "Snow");
        Person person2 = new Person("Matt", "Jones");
        Person person3 = new Person("Seth", "Roberts");
        ContactInformation contactInformation = new ContactInformation ("09267071733", person1);
        ContactInformation contactInformation1 = new ContactInformation ("09994590144", person1);
        ContactInformation contactInformation2 = new ContactInformation ("09173521150", person2);
       
        person1.getContactInfoList().add(contactInformation);
        person1.getContactInfoList().add(contactInformation1);
        person2.getContactInfoList().add(contactInformation2);

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
    }

}
