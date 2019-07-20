/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Train;

import lombok.NoArgsConstructor;

/**
 *
 * @author User
 */
@NoArgsConstructor
public class Dog implements Animal{
    
    private String sound = "Hav";
    
    public void printSound()
    {
        System.out.println(sound);
    }
}
