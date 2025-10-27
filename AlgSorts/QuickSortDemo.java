
import java.util.Arrays;

public class QuickSortDemo {
    // contadores globais (acumulam valores durante toda a execução)
    static int trocas = 0;
    static int interacoes = 0;

    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            interacoes++; // conta cada chamada recursiva (pode considerar como "interação")
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1;
        int f = fim;

        while (i <= f) {
            while (i <= fim && vetor[i] <= pivo) i++;
            while (f > inicio && vetor[f] > pivo) f--;

            if (i < f) {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                trocas++; // conta troca
                i++;
                f--;
            }
        }

        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        trocas++; // conta a troca final (colocar o pivô)
        return f;
    }

    public static void main(String[] args) {
        int[] vetor = {3,2,8,1,5};
        quickSort(vetor, 0, vetor.length - 1);

        // imprime uma única vez ao final da ordenação
        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));
        System.out.println("Trocas feitas: " + trocas);
        System.out.println("Interações feitas: " + interacoes);
    }
}
