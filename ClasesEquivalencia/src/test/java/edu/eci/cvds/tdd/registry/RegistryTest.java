package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person();
        person.setAge(60);
        person.setAlive(true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    
    @Test
    public void validateInvalidAge(){
       Person person = new Person();
       person.setAge(-1);
       person.setAlive(true);
       RegisterResult result = registry.registerVoter(person);
       Assert.assertEquals(RegisterResult.INVALID_AGE, result);
   }

   @Test
    public void validateValidAge(){
       Person person = new Person();
       person.setAge(50);
       person.setAlive(true);
       RegisterResult result = registry.registerVoter(person);
       Assert.assertEquals(RegisterResult.VALID, result);
   }

   @Test
    public void validateDead(){
       Person person = new Person();
       person.setAge(50);
       person.setAlive(false);
       RegisterResult result = registry.registerVoter(person);
       Assert.assertEquals(RegisterResult.DEAD, result);
   }

   @Test
    public void validateUnderage(){
       Person person = new Person();
       person.setAge(18);
       person.setAlive(true);
       RegisterResult result = registry.registerVoter(person);
       Assert.assertEquals(RegisterResult.UNDERAGE, result);
   }

   @Test
    public void validateDuplicate(){
       Person personOne = new Person();
       personOne.setId(123);
       personOne.setAlive(true);
       personOne.setAge(21);
       registry.registerVoter(personOne);
       Person personTwo = new Person();
       personTwo.setId(123);
       personTwo.setAlive(true);
       personTwo.setAge(24);
       RegisterResult result = registry.registerVoter(personTwo);
       Assert.assertEquals(RegisterResult.DUPLICATED, result);
   }
}
