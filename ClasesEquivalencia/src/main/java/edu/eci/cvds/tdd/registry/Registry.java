package edu.eci.cvds.tdd.registry;
 
import java.util.ArrayList;
 
public class Registry {
    private ArrayList<Person> people;
 
    public Registry(){
        people = new ArrayList<>();
    }
 
    public RegisterResult registerVoter(Person p) {
        Person persona = p;
        if (persona.getAge() <= 0 || persona.getAge() > 110) {
            return RegisterResult.INVALID_AGE;
        } else if (!persona.isAlive()) {
            return RegisterResult.DEAD;
        } else if (registerVote(persona) == RegisterResult.DUPLICATED) {
            return RegisterResult.DUPLICATED;
        } else if (persona.getAge() < 21) {
            return RegisterResult.UNDERAGE;
        } else {
            return RegisterResult.VALID;
        }
    }
 
    public RegisterResult registerVote(Person p) {
        boolean duplicate = false;
        int idPerson = p.getId();
        for (Person person : people) {
            if (person.getId() == idPerson) {
                duplicate = true;
                break; // Break the loop once a duplicate is found
            }
        }
        if (duplicate) {
            return RegisterResult.DUPLICATED;
        } else {
            people.add(p);
            return RegisterResult.VALID;
        }
    }
}