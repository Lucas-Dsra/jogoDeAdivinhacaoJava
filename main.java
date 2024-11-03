import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        //Abertura da leitura do teclado para receber entradas.
        Scanner sc = new Scanner(System.in);

        //Explicação inicial do jogo para o usuário
        System.out.println("Bem-vindo ao nosso Jogo, \nVou Explicar algumas regras para melhor compreensão, vamos lá? \nVocê precisa realizar a escolha de dois números, após isso o o jogo vai escolher um número entre os dois números, e você vai ter que adivinhar qual o número \n \nVamos lá?");

        //Instanciação dos números
        int numeroA  = 0;
        int numeroB = 0;

        //Laço de repetição para evitar que o tratamento de exceções encerre o programa, na entrada do primeiro número
        boolean sucesso = false;
        while (!sucesso){
            System.out.println("Escolha o primeiro Número? Digite e aberte enter");
            //tratamento de exceções
            try {
                numeroA = sc.nextInt();
                sucesso = true;
            }catch (java.util.InputMismatchException e) {
                System.out.println("entrada não é um inteiro");
                sc.next();
            }
        }

        //Laço de repetição para evitar que o tratamento de exceção encerre o programa, na entrada do segundo número
        sucesso = false;
        while (!sucesso){
            System.out.println("Escolha o segundo Número? Digite e aberte enter");
            //tratamento de exceções
            try {
                numeroB = sc.nextInt();
                sucesso = true;
            }catch (java.util.InputMismatchException e) {
                System.out.println("entrada não é um inteiro");
                sc.next();
            }
        }

        //instanciação das variáveis para utilização no if else
        int max = 0;
        int min = 0;

        //Controle para garantir que no calculo do número aleatório sempre seja possível saber qual é o valor maior ou menor.
        if(numeroA > numeroB){
            max = numeroA;
            min = numeroB;
        }else if(numeroB > numeroA){
            max = numeroB;
            min = numeroA;

        }

        //Instaciação da Class Radom
        Random random = new Random();

        //Pegando um número aleatório
        int numeroAleatorio = random.nextInt((max - min) + 1) + min;

        //instanciação para utilização no laço while
        int decisicao = 0;
        int tentativas = 0;

        //while com a decisão para encerrar o programa
        while (decisicao != 2){

            //instanciação para utilização no laço while
            sucesso = false;
            int palpite = 0;
            //Laço de repetição para evitar que o tratamento de exceção encerre o programa, na entrada do palpite
            while (!sucesso){
                //tratamento de exceções
                try {
                    System.out.println("Qual o número aleatório?");
                    palpite = sc.nextInt();
                    sucesso = true;
                }catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada não é um numero inteiro");
                    sc.next();
                }
            }

            //If para ajudar o usuário com dicas e confirmação para caso ele acerte, também incremento da variável tentativa para contar a tentativa de quando o usuário acerta o número.
            if (palpite == numeroAleatorio){
                System.out.println("Correto, o número aleatório é " + numeroAleatorio);
                tentativas++;
                System.out.println("Quantidade de tentativas até o acerto: " + tentativas);
                break;
            } else if (palpite > numeroAleatorio) {
                System.out.println("Palpite maior que no que o numero aleatório, lembre o numero está entre " + max + " e " + min);
            } else if (palpite < numeroAleatorio) {
                System.out.println("Palpite menor que no que o numero aleatório lembre o numero está entre " + max + " e " + min);
            }

            //While com tratamento de exceções para caso o usuário digite alguma opção invalida para encerrar ou tentar novamente.
            sucesso = false;
            while (!sucesso){
                try {
                    System.out.println("Deseja tentar novamente? Digite 1 para Sim e 2 para não");
                    decisicao = sc.nextInt();
                    if (decisicao != 1 && decisicao != 2){
                        System.out.println("Opção invalida");
                    }else {
                        sucesso = true;
                    }
                }catch (java.util.InputMismatchException e) {
                    System.out.println("entrada não é um inteiro");
                    sc.next();
                }

            }

            tentativas++;
        }

        System.out.println("Jogo encerrado, quantidade de tentativas utilizadas: " + tentativas);

        //Fechamento da leitura do teclado
        sc.close();
    }
}

