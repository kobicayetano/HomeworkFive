package com.ojt.homeworkfive;
import java.util.List;
import java.util.ArrayList;

public class App {

    public static void main( String[] args ){
        PersonService personService = new PersonServiceImpl();
        RoleService roleService = new RoleServiceImpl();

        //Create Person objects
        Person person1 = new Person("John", "Snow");
        Person person2 = new Person("Matt", "Jones");
        Person person3 = new Person("Seth", "Roberts");

        //Create contact information for Person objects
        ContactInformation contactInformation1 = new ContactInformation ("09267071733", person1);
        ContactInformation contactInformation2 = new ContactInformation ("09994590144", person1);
        ContactInformation contactInformation3 = new ContactInformation ("09173521150", person2);
        ContactInformation contactInformation4 = new ContactInformation ("09338681150", person3);   

        //Create role objects
        Role role1 = new Role("Administrator");
        Role role2 = new Role("User");

        //Include contact information to a Person object
        person1.getContactInfoList().add(contactInformation1);
        person1.getContactInfoList().add(contactInformation2);
        person2.getContactInfoList().add(contactInformation3);
        person3.getContactInfoList().add(contactInformation4);

        //Include role to a Person object
        person1.getRoleSet().add(role2);
        person2.getRoleSet().add(role1);
        person2.getRoleSet().add(role2);
        person3.getRoleSet().add(role1);
        person3.getRoleSet().add(role2);

        //Persist roles
        createRole(roleService, role1);
        createRole(roleService, role2);

        //Persist persons
        createPerson(personService, person1);
        createPerson(personService, person2);
        createPerson(personService, person3);
        

        //Read from db
        getPersonById(personService, 1);

        //Update a person entry
        updatePersonById(personService, 1, "Hawkin");

        //Verify if update was done
        getPersonById(personService, 1);
 
        
        //Delete a person's role
        deletePersonRoleById(personService, 2, 1);

        //Delete a person entry
        deletePersonById(personService, 2);
        //Verify if update was done
        getPersonById(personService, 2);

        //Read from db
        getRoleById(roleService, 1);

        //Change Role "Administrator" to "Admin"
        updateRoleById(roleService, 1, "Admin");
        //Verify if update was done
        getRoleById(roleService, 1);

        //Delete role entry
        deleteRoleById(roleService, 2);
        //Verify if update was done
        getRoleById(roleService, 2);


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

    public static void deletePersonRoleById(PersonService personService, int personId,int roleId){
        personService.deletePersonRoleById(personId, roleId);
    }

    //helper classes for Role
    public static void createRole(RoleService roleService, Role role){
        roleService.createRole(role);
    }

    public static void updateRoleById(RoleService roleService, int roleId, String newTitle){
        roleService.updateRoleTitleById(roleId, newTitle);
    }

    public static void deleteRoleById(RoleService roleService, int roleId){
        roleService.deleteRoleById(roleId);
    }

    public static void getRoleById(RoleService roleService, int roleId){
        Role role = roleService.getRoleById(roleId);
        System.out.println(role);
    }
    
}
