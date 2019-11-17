/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Country;

import java.util.ArrayList;

/**
 *
 * @author indu
 */
public class PersonDirectory {
     private ArrayList<Person> personList;
     
     public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public Person addPerson() {
        Person person = new Person();
        personList.add(person);
        return person;
    }

    //Removing an Employee from the Directory
    public void removePerson(Person person) {
        personList.remove(person);
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    
}
