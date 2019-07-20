/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Train;

/**
 *
 * @author User
 */
public interface Animal {
    public void printSound();
    
    default void printName()
    {
        System.out.println(this.getClass().getSimpleName());
    }
}
