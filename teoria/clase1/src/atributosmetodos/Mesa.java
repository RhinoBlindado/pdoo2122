/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atributosmetodos;

/**
 *
 * @author valentino
 */
public class Mesa 
{
    // Height in meters
    private float altura;
    
    // Two constructors:
    // - One with parameters
    Mesa (float attr_altura)
    {
        this.altura = attr_altura;
    }
    
    // - One without.
    Mesa ()
    {
        this.altura = 1;
    }
    
    // Get the height value..
    public float getHeight()
    {
        return this.altura;
    }
}
