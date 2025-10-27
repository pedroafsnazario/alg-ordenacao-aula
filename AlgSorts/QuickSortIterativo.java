import java.util.Arrays;
import java.util.Stack;

public class QuickSortIterativo {

    static int trocas = 0;
    static int interacoes = 0;

    public static void quickSort(int[] vetor) {
        Stack<int[]> pilha = new Stack<>();

        // empilha o intervalo inicial
        pilha.push(new int[]{0, vetor.length - 1});

        // enquanto houver subvetores na pilha
        while (!pilha.isEmpty()) {
            interacoes++;
            int[] intervalo = pilha.pop();
            int inicio = intervalo[0];
            int fim = intervalo[1];

            if (inicio < fim) {
                int pivo = separar(vetor, inicio, fim);

                // empilha as duas partes geradas pela partição
                pilha.push(new int[]{inicio, pivo - 1});
                pilha.push(new int[]{pivo + 1, fim});
            }
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
                int aux = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = aux;
                trocas++;
                i++;
                f--;
            }
        }

        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        trocas++;

        return f;
    }

    public static void main(String[] args) {
        int[] vetor = {3,2,8,1,5};

        quickSort(vetor);

        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));
        System.out.println("Trocas feitas: " + trocas);
        System.out.println("Interações feitas: " + interacoes);
    }
}
