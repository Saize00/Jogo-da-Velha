import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] tabuleiro = {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        };

        Object[] jogador1 = {"Willyan", 0};
        Object[] jogador2 = {"Jogador 2", 0};

        String jogador = "X";
        int jogadas = 0;
        boolean venceu = false;

        while (jogadas < 9 && !venceu) {

            System.out.println();

            for (int i = 0; i < 3; i++) {
                System.out.println(
                        tabuleiro[i][0] + " | " +
                                tabuleiro[i][1] + " | " +
                                tabuleiro[i][2]
                );

                if (i < 2) {
                    System.out.println("--+---+--");
                }
            }

            System.out.println("\nJogador " + jogador);

            System.out.print("Digite a linha (1-3): ");
            int linha = sc.nextInt() - 1;

            System.out.print("Digite a coluna (1-3): ");
            int coluna = sc.nextInt() - 1;

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
                System.out.println("Posição inválida!");
                continue;
            }

            if (!tabuleiro[linha][coluna].equals(" ")) {
                System.out.println("Essa posição já está ocupada!");
                continue;
            }

            tabuleiro[linha][coluna] = jogador;
            jogadas++;

            for (int i = 0; i < 3; i++) {
                if (tabuleiro[i][0].equals(jogador) &&
                        tabuleiro[i][1].equals(jogador) &&
                        tabuleiro[i][2].equals(jogador)) {

                    venceu = true;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (tabuleiro[0][i].equals(jogador) &&
                        tabuleiro[1][i].equals(jogador) &&
                        tabuleiro[2][i].equals(jogador)) {

                    venceu = true;
                }
            }

            if (tabuleiro[0][0].equals(jogador) &&
                    tabuleiro[1][1].equals(jogador) &&
                    tabuleiro[2][2].equals(jogador)) {

                venceu = true;
            }

            if (tabuleiro[0][2].equals(jogador) &&
                    tabuleiro[1][1].equals(jogador) &&
                    tabuleiro[2][0].equals(jogador)) {

                venceu = true;
            }

            if (venceu) {

                if (jogador.equals("X")) {
                    jogador1[1] = (Integer) jogador1[1] + 1;
                    System.out.println("\nJogador X venceu!");
                } else {
                    jogador2[1] = (Integer) jogador2[1] + 1;
                    System.out.println("\nJogador O venceu!");
                }

            } else {

                if (jogador.equals("X")) {
                    jogador = "O";
                } else {
                    jogador = "X";
                }
            }
        }

        System.out.println("\nTabuleiro final:");

        for (int i = 0; i < 3; i++) {
            System.out.println(
                    tabuleiro[i][0] + " | " +
                            tabuleiro[i][1] + " | " +
                            tabuleiro[i][2]
            );

            if (i < 2) {
                System.out.println("--+---+--");
            }
        }

        if (!venceu) {
            System.out.println("\nEmpate!");
        }

        System.out.println("\nPontuação:");
        System.out.println(jogador1[0] + ": " + jogador1[1]);
        System.out.println(jogador2[0] + ": " + jogador2[1]);

        sc.close();
    }
}

