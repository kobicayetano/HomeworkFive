package com.ojt.homeworkfive;
import java.util.List;
import java.util.ArrayList;

public class App {

    static List<Person> personList = new ArrayList<>();
    static List<Role> roleList = new ArrayList<>();

    public static void main( String[] args ){
        PersonService personService = new PersonServiceImpl();
        RoleService roleService = new RoleServiceImpl();
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

        createRole(roleService, roleList.get(0));
        createRole(roleService, roleList.get(1));

    }


    //helper classes for Person
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


    //helper classes for Role
    public static void createRole(RoleService roleService, Role role){
        roleService.createRole(role);
    }


    public static void createPeopleProfile(){

        //Create Person objects
        Person person1 = new Person("John", "Snow");
        Person person2 = new Person("Matt", "Jones");
        Person person3 = new Person("Seth", "Roberts");

        //Create contact information for Person objects
        ContactInformation contactInformation1 = new ContactInformation ("09267071733", person1);
        ContactInformation contactInformation2 = new ContactInformation ("09994590144", person1);
        ContactInformation contactInformation3 = new ContactInformation ("09173521150", person2);
        
        //Include contact information to a Person object
        person1.getContactInfoList().add(contactInformation1);
        person1.getContactInfoList().add(contactInformation2);
        person2.getContactInfoList().add(contactInformation3);

        //Add Person objects to the Person list
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        //Create Role object
        Role role1 = new Role("Administrator");
        Role role2 = new Role("User");
        roleList.add(role1);
        roleList.add(role2);
    }

}
