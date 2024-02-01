package fr.formation;

import fr.formation.services.calcul;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        calcul calc = new calcul();
       
        int resSomme = calc.somme(6, 8);
        System.out.println(resSomme);
      

        
    }


}
