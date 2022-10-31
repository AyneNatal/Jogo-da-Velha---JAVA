import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Campo[][] tabuleiro = new Campo[3][3];
        Scanner scan = new Scanner(System.in);
        char simboloAtual = 'X'; //todo implementar um random aqui
        String vitoria = "";
        boolean gameON = true;

        iniciarJogo(tabuleiro);

        while (gameON) {
            desenhaJogo(tabuleiro);
            vitoria = verificarVitoria(tabuleiro);
            if (!vitoria.equals("")) {
                System.out.printf("Jogador %s venceu!%n", vitoria);
                break;
            }

            try {
                if (verificarJogada(tabuleiro, jogar(scan, simboloAtual), simboloAtual)) {
                    if (simboloAtual == 'X') { //troca o jogador se a jogada for válida
                        simboloAtual = 'O';
                    } else {
                        simboloAtual = 'X';
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro");
            }

            limparTela();

//            System.out.println("__FIM DO JOGO__");
        }
    }

    public static void iniciarJogo (Campo[][] jogo) {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                jogo[linha][coluna] = new Campo();
            }
        }
    }

    public static void desenhaJogo (Campo[][] tabuleiro) {
        System.out.println("     0    1     2");
        System.out.printf("0   %c  |  %c  | %c %n", tabuleiro[0][0].getSimbolo(), tabuleiro[0][1].getSimbolo(), tabuleiro[0][2].getSimbolo());
        System.out.println("   ----------------");
        System.out.printf("1   %c  |  %c  | %c %n", tabuleiro[1][0].getSimbolo(), tabuleiro[1][1].getSimbolo(), tabuleiro[1][2].getSimbolo());
        System.out.println("   ----------------");
        System.out.printf("2   %c  |  %c  | %c %n", tabuleiro[2][0].getSimbolo(), tabuleiro[2][1].getSimbolo(), tabuleiro[2][2].getSimbolo());
    }

    public static void limparTela () { //pula 200 linhas só pra "limpar" (da vista) a tela
        for (int i = 0; i < 200; i++) {
            System.out.println();
        }
    }

    public static int[] jogar (Scanner scan, char simboloAtual) {
        int[] jogada = new int[2];
        System.out.printf("%s %c%n", "Quem Joga: ", simboloAtual);

        System.out.printf("Informe a linha: ");
        jogada[0] = scan.nextInt();

        System.out.printf("Informe a coluna: ");
        jogada[1] = scan.nextInt();

        return jogada;
    }

    public static boolean verificarJogada (Campo[][] jogo, int[] localDaJogada, char simboloAtual) {
        if (jogo[localDaJogada[0]][localDaJogada[1]].getSimbolo() == ' ') {
            jogo[localDaJogada[0]][localDaJogada[1]].setSimbolo(simboloAtual);
            return true;
        } else {
            return false;
        }
    }

    public static String verificarVitoria (Campo[][] jogo) {
        return "";
        //todo implementar esse metodo (desafio)
    }

    //todo: implementar um met pra qnd o tab for td preenchido e ninguem venceu pra encerrar o jogo
}
