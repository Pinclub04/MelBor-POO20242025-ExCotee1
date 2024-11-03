package SQpackage;

import java.util.Optional;

 /*
 *Crée une classe Queue qui hérite de SQStructure
Cette classe permet de gérer une file (FIFO)
La file est extensible et rétractable (en fonction du nombre d'entiers dans le tableau)
*/
public class Stack extends SQStructure {
    /*permet d'ajouter un entier dans la pile
        * Param : valeur , type : int
        */ 
    @Override
    public void Push(int valeur) {
        
        if (count == tableau.length) {
            redimensionner(tableau.length + 10); // Agrandir de 10 si la pile est pleine
        }
        tableau[count] = valeur;
        count++;
    }
    //permet de retirer un nombre du tableau et renvoit sa valeur ,renvoie rien si le tableau est vide
    @Override
    public Optional<Integer> Pop() {
        if (count == 0) {
            System.out.println("La pile est vide");
            return Optional.empty();
        }
        int valeur = tableau[--count];
        // redimension du tableau en fonction du nombre d'éléments
        if (count < tableau.length - 10) {
            redimensionner(Math.max(tableau.length - 5, 10)); // S'assure que la taille minimale est 10
            
        }
        return Optional.of(valeur);
    }
    
}



    
