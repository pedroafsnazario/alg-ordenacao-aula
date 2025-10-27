import java.util.Arrays;

public class InsertionSortRecursivo {

    static int trocas = 0;
    static int interacoes = 0;

    static void insertionSortRecursivo(int[] vetor, int n) {
        // Caso base: vetor de tamanho 1 já está ordenado
        if (n <= 1) {
            return;
        }

        // Ordena os primeiros n-1 elementos
        insertionSortRecursivo(vetor, n - 1);
        interacoes++;

        // Insere o último elemento (vetor[n-1]) na posição correta
        int ultimo = vetor[n - 1];
        int j = n - 2;

        // Move os elementos maiores para frente
        while (j >= 0 && vetor[j] > ultimo) {
            vetor[j + 1] = vetor[j];
            j--;
            trocas++;
        }

        vetor[j + 1] = ultimo;
    }

    public static void main(String[] args) {
        int[] vetor = {3,2,8,1,5};

        insertionSortRecursivo(vetor, vetor.length);

        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));
        System.out.println("Trocas feitas: " + trocas);
        System.out.println("Interações feitas: " + interacoes);
    }
}
