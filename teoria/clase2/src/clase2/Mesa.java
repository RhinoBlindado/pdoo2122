package clase2;

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
    
    // Modifier of height
    public boolean setHeight(float p_altura)
    {
        if(p_altura > 0)
        {
            this.altura = p_altura;
            return true;
        }
        return false;
    }
}
