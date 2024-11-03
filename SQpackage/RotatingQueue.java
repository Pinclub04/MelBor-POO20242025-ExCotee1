package SQpackage;

import java.util.Optional;
/*
    * Crée une classe RotatingQueue qui hérite de Queue
    Cette classe permet de gérer une file (FIFO) tout en jouant avec une rotation dans la file
    */
public class RotatingQueue extends Queue {
    

    // Constructeur
    public RotatingQueue() {
        super();
    }
    /*permet d'ajouter un entier dans la queue
        * Param : valeur , type : int
        */ 
    @Override
    public void Push(int valeur) {
        // Vérifie si la file est pleine
        if (count == tableau.length) {
            redimensionner(tableau.length + 10); // Agrandir de 10 si la file est pleine
            tableau[rear] = valeur;
            rear = (rear + 1);
            count++;
        }

        // Vérifie si l'indice rear est à la fin du tableau et si le tableau est plein mais qu'il y a de la place au début
        if (rear == tableau.length && front > 0) {
            // Ajoute la valeur au début de la file
            front--; // Déplace le front vers l'arrière pour faire de la place
            tableau[front] = valeur; // Ajoute la valeur à la position front
            count++;
            
        } else {
            // Ajoute la valeur à la position rear
            tableau[rear] = valeur;
            rear = (rear + 1);
            count++;
        }

        
    }
    //permet de retirer un nombre du tableau et renvoit sa valeur
    @Override
    public Optional<Integer> Pop() {
        // Vérifie si la file est vide
        if (count == 0) {
            System.out.println("La file est vide");
            return Optional.empty(); // Renvoie un Optional vide
        }
        
        // Récupère la valeur à la position front et incrémente front
        int valeur = tableau[front];
        front = (front + 1);
        count--; // Décrémente le nombre d'éléments

        // Réduire la taille si le nombre d'éléments est inférieur à la taille - 10
        if (count < tableau.length - 10) {
            redimensionner(Math.max(tableau.length - 5, 10)); // S'assure que la taille minimale est 10
        }
        return Optional.of(valeur); // Renvoie la valeur retirée dans un Optional
    }
    
    
}
