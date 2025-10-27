import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        int[] iVetor = {3,2,8,1,5};
        int[] bVetor = {3,2,8,1,5};
        int[] sVetor = {3,2,8,1,5};
        int[] cVetor = {3,2,8,1,5};
        int[] qVetor = {3,2,8,1,5};


        Ordenacao isort = new Ordenacao(iVetor);
        Ordenacao bsort = new Ordenacao(bVetor);
        Ordenacao ssort = new Ordenacao(sVetor);
        Ordenacao csort = new Ordenacao(cVetor);
        

        //Consideracoes O Insertion geralmente ~e considerado melhor que o selection e o bubble sort, para pequenos vetores e.ou vetores quase ordenados ele se sobressai
        //O Insertion sort é mais rapido na pratica, pois tem menos trocas e comparacoes, o unico problema dele e na atualizacao dos vetores mas de resto ele é bem rapido
        

        System.out.println("\n\nInsertion Sort:");
        isort.insertionSort(iVetor, 5);
        
        System.out.println("\n\nBubble Sort:");
        bsort.bubbleSort(5, bVetor);
        
        System.out.println("\n\nSelection Sort:");
        ssort.selectionSort(5, sVetor);
        
        System.out.println("\n\nCocktail Sort:");
        csort.cocktailSort(5, cVetor);

        
        
    }
}

class Ordenacao {

    int[] vetor;
   

    public Ordenacao(int[] vetor) {
        this.vetor = vetor;
        

    }

    void insertionSort(int[] vetor, int tamanho){
        int chave, j;
        int trocas = 0;
        int interacao = 0;

        for(int i = 1; i < tamanho; i++){
            interacao++;
            chave = vetor[i];
            j = i - 1;
            while(j >=0 && vetor[j] > chave){
                trocas++;
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = chave;
        }

        System.out.println("Vetor Ordenado: " + Arrays.toString(vetor) + " Trocas feitas: " +  trocas + " Interações feitas: " + interacao );
    }
    
    public void bubbleSort(int tamanho, int[] vetor) {
        int temp = 0;
        int trocas = 0;
        int interacoes = 0;


        //primeiro for para etapas
        //Adicionar uma condicao de parada
        for(int i = 0; i<tamanho; i++) {
            int trocou = 0;
            interacoes++;

            for(int j = 1; j<tamanho - i; j++) {
                //Se a posição anterior for maior que a atual..
                if (vetor[j - 1] > vetor[j]) {
                    //realize troca elementos
                    temp = vetor[j - 1];
                    vetor[j - 1] = vetor[j];
                    vetor[j] = temp;
                    trocas++;
                    trocou ++;
                }

            }

            if (trocou == 0){
                System.out.println("Nao houve mais trocas de posicoes, ou seja, o vetor está ordenado");
                break;
            }
        }

        System.out.println("Vetor Ordenado: " + Arrays.toString(vetor) + " trocas feitas: " + trocas + ", Interacoes feitas: " + interacoes);
    }

    public void selectionSort(int tamanho, int[] vetor){
        int trocas = 0;
        int interacoes = 0;
        for(int i=0; i < tamanho - 1; i++){
            interacoes++;
            int minIndex = i;
            for(int j= i + 1; j < tamanho; j++){
                if(vetor[j] < vetor[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = vetor[i];
                vetor[i] = vetor[minIndex];
                vetor[minIndex] = temp;
                trocas++;
            }
        }

        System.out.println("Vetor Ordenado: " + Arrays.toString(vetor) + " trocas feitas: " + trocas + ", Interacoes feitas: " + interacoes);
    }

    public void cocktailSort(int tamanho, int[] vetor) {
        boolean trocou = true;
        int inicio = 0;
        int fim = tamanho - 1;
        int temp;
        int trocas = 0;
        int interacoes = 0;

        while(trocou) {
            trocou = false;

            //passagem da esquerda para  direita
            for(int i = inicio; i < fim; i++){
                interacoes++;
                if(vetor[i] > vetor [i + 1]){
                    temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    trocou = true;
                    trocas++;
                }

            }

            if (!trocou) {
                break;
            }

            trocou = false;
            fim-- ;

            for(int i = fim; i > inicio; i--){
                interacoes++;
                if(vetor[i] < vetor[i - 1]){
                    temp = vetor[i];
                    vetor[i] = vetor[i - 1];
                    vetor[i - 1] = temp;
                    trocou = true;
                    trocas++;
                }
            }

            inicio++;

        }
        System.out.println("Vetor Ordenado: " + Arrays.toString(vetor) + " trocas feitas: " + trocas + ", Interacoes feitas: " + interacoes);
    }



    //bubble sort
    //bubble sort +
    //os 3 sorts do tde
    //quantas interacoes e trocas..
    //
}

