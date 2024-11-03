package SQpackage;
import java.util.Optional;
public abstract class SQStructure {
    
    protected int[] tableau;
    protected int count; // nombre d'éléments dans le tableau

     
    protected SQStructure() {
        this.tableau = new int[10]; // Taille initiale du tableau
        this.count = 0;
     }    

    // Méthodes abstraites à implémenter dans les sous-classes
    public abstract void Push(int valeur);
    public abstract Optional<Integer> Pop();
    
    // Méthodes concrètes communes aux sous-classes
    // permet de connaitre le nombre d'élément dans le tableau
    public int Count() {
        return count;
    }
    // permet de connaître la taille du tableau
    public int Size() {
        return tableau.length;
    }
    public void AfficherElements() {
        System.out.print("Éléments dans la pile : ");
        for (int i = 0; i < count; i++) {
            System.out.print(tableau[i] + (i < count - 1 ? ", " : ""));
        }
        System.out.println(); 
    }
    protected void redimensionner(int nouvelleTaille) {
        int[] nouveauTableau = new int[nouvelleTaille];
        System.arraycopy(tableau, 0, nouveauTableau, 0, count);
        tableau = nouveauTableau;
    }
    // permet de vider le tableau
    public void Clear() {
        // Réinitialise le compteur d'éléments
        count = 0;

        // réinitialise le tableau 
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = 0;
        }

        System.out.println("La structure a été vidée.");
    }

}
