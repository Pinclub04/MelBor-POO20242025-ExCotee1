package SQpackage;

import java.util.Optional;
 /*
    *  Crée une classe Stack qui hérite de SQStructure
    Cette classe permet de gérer une pile (LIFO)
    La pile est extensible et rétractable (en fonction du nombre d'entiers dans le tableau)
    */
public class Queue extends SQStructure {
    protected int front; // tête de  file
    protected int rear;  // queue de file

   
    public Queue() {
        this.front = 0;
        this.rear = 0;
    }
    /*permet d'ajouter un entier dans la queue
        * Param : valeur , type : int
        */ 
    @Override
    public void Push(int valeur) {
        // si le tableau est rempli on l'étend
        if (count == tableau.length) {
            redimensionner(tableau.length + 10);
        }

        // ajout élément à en queue de liste  du tableau et mettre à jour l'index de rear de manière circulaire 
        tableau[rear] = valeur;
        rear = (rear + 1) % tableau.length;
        count++;
    }
    // permet de retirer un nombre du tableau et renvoit sa valeur
    @Override
    public Optional<Integer> Pop() {
        if (count == 0) {
            System.out.println("La file est vide");
            return Optional.empty();
        }

        // récuperation  élément à en tête de file du tableau et mise à jour l'index de front 
        int valeur = tableau[front];
        front = (front + 1) % tableau.length;
        count--;

        
        if (count < tableau.length - 10) {
            redimensionner(Math.max(tableau.length - 5, 10)); // S'assure que la taille minimale est 10
        }

        return Optional.of(valeur);
    }

    // Updated redimensionner method for circular queue
    @Override
    protected void redimensionner(int nouvelleTaille) {
        int[] nouveauTableau = new int[nouvelleTaille];
        for (int i = 0; i < count; i++) {
            // Copy elements in the current order starting from 'front'
            nouveauTableau[i] = tableau[(front + i) % tableau.length];
        }
        tableau = nouveauTableau;
        front = 0;
        rear = count;
    }

    public void AfficherElements() {
        System.out.print("Éléments dans la file : ");
        for (int i = 0; i < count; i++) {
            System.out.print(tableau[(front + i) % tableau.length] + (i < count - 1 ? ", " : ""));
        }
        System.out.println();
    }

    @Override
    // renitialise le tableau  
    public void Clear() {
        front = 0;
        rear = 0;
        count = 0;
        tableau = new int[10];
        System.out.println("La structure a été vidée.");
    }
}
