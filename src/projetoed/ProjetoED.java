package projetoed;

import java.util.Scanner;

public class ProjetoED {

    public static void main(String[] args) {
        String word;
        String[][] dic = {{"Professor", "Teacher"}, {"Dentista", "Dentist"}, {"Açougueiro", "Butcher"}, {"Advogado", "Lawyer"}, {"Cantor", "Singer"}};
        String[][] dicIngl = cloneInverso(dic);
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite 1 para visualizar o dicionario em português ou 2 para visualizar o dicionario em inglês: ");
        int result = scan.nextInt();
        while (result != 1 && result != 2) {
            System.out.println("Por favor, digite uma opção correta: ");
            result = scan.nextInt();
        }
        if (result == 1) {
            ordernar(dic);
            printar(dic);
            busca(dic);

        } else {
            ordernar(dicIngl);
            printar(dicIngl);
        }

    }

    public static void printar(String[][] dic) {
        for (int i = 0; i < dic.length; i++) {
            for (int j = 0; j < dic[0].length; j++) {
                System.out.printf("%s ", dic[i][j]);

            }
            System.out.println("\n");
        }
    }

    public static void ordernar(String[][] dic) {
        String[] auxVet = {" ", " "};
        for (int i = 0; i < dic.length - 1; i++) {
            for (int c = i + 1; c < dic.length; c++) {
                if (dic[i][0].compareTo(dic[c][0]) > 0) {
                    auxVet[0] = dic[i][0];
                    auxVet[1] = dic[i][1];
                    dic[i][0] = dic[c][0];
                    dic[i][1] = dic[c][1];
                    dic[c][0] = auxVet[0];
                    dic[c][1] = auxVet[1];
                }
            }
        }

    }

    public static String[][] cloneInverso(String[][] dic) {
        String[][] clone = new String[dic.length][dic[0].length];
        for (int i = 0; i < dic.length; i++) {
            for (int k = 0, j = dic[0].length - 1; j <= dic[0].length && j >= 0; k++, j--) {
                clone[i][k] = dic[i][j];
            }
        }
        return clone;
    }

    public static void busca(String[][] dic) {
        String aux[] = {" ", " "};
        boolean achou = false;
        int inicio = 0;
        int meio = 0;
        int fim = dic.length - 1;
        System.out.print("Digite uma palavra para saber a sua tradução: ");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        for (int i = 0; i < dic.length - 1; i++) {
            for (int c = i + 1; c < dic.length; c++) {
                if (dic[i][0].compareTo(dic[c][0]) > 0) {
                    aux[0] = dic[i][0];
                    aux[1] = dic[i][1];
                    dic[i][0] = dic[c][0];
                    dic[i][1] = dic[c][1];
                    dic[c][0] = aux[0];
                    dic[c][1] = aux[1];
                }
            }
        }
        while (inicio <= fim) {
            meio = (int) ((inicio + fim) / 2);
            if (aux[meio].equalsIgnoreCase(word)) {
                achou = true;
                //System.out.println(aux[meio]+" Tradução: "+aux[meio+1]);
                break;
            } else if (aux[meio].compareTo(word) > 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        if (achou == true) {
            System.out.println(word + " Tradução: " + aux[meio + 1]);
        } else {
            System.out.println("Palavra fora do dicionario...");
        }
    }

    public static void buscaBinaria() {
        boolean achou = false;
        int num = 4;
        int[] vet = {1, 2, 3, 4, 5, 6};
        int inicio = 0;
        int meio;
        int fim = vet.length - 1;
        while (inicio <= fim) {
            meio = (int) (inicio + fim) / 2;
            if (vet[meio] == num) {
                //System.out.println("Achei o número!");
                achou = true;
                break;
            } else if (meio < num) {
                inicio = meio + 1;

            } else {
                fim = meio - 1;
            }

        }
        if (achou == true) {
            System.out.println("Achei o número: " + num);
        } else {
            System.out.println("Não achou...");
        }

    }
}
