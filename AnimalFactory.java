/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Train;

import java.lang.reflect.InvocationTargetException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;



/**
 *
 * @author User
 */
public class AnimalFactory {
    private static HashMap<String, Animal> animalsInitialized = new HashMap<String, Animal>();
    
    private static HashMap<String, Class> animalsExists = new HashMap<String, Class>() 
    {
        { 
        put("Dog", Dog.class);
        put("Duck", Duck.class); 
        put("Cat", Cat.class);
        }
    };
 
    private static final Logger logger = LogManager.getLogger(AnimalFactory.class);
    
    public static Animal getAnimal(String animalName)
    {
        if(animalsExists.containsKey(animalName))
        {
            if(animalsInitialized.containsKey(animalName))
            {
                return (Animal) animalsInitialized.get(animalName);
            }
            else
            {
                try
                {
                    Animal missingAnimal = (Animal) animalsExists.get(animalName).getConstructor().newInstance();
                    animalsInitialized.put(animalName, missingAnimal);
                    
                    return missingAnimal;
                }
                 catch(InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException ex)
                {
                    logger.debug("This is debug");
                    return null;
                }
                catch (IllegalArgumentException ex) {
                   
                } catch (InvocationTargetException ex) {
                   
                }
            }
        }
       
//             logger.debug("This is debug");
            return null;
            
            
//        try
//        {
//            if(animalName.equals(Dog.class.getSimpleName()))
//            {
//                return Dog.class.newInstance();
//            }
//            else if(animalName.equals(Duck.class.getSimpleName()))
//            {
//                return Duck.class.newInstance();
//            }
//            else if(animalName.equals(Cat.class.getSimpleName()))
//            {
//                return Cat.class.newInstance();
//            }
//        } 
//        catch(InstantiationException | IllegalAccessException ex)
//        {
//           Logger.getLogger(AnimalFactory.class.getName()).log(Level.SEVERE, null, ex); 
//           return null;
//        }
//            return null;
    }
}
