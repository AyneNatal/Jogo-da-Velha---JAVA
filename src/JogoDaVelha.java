import java.util.Arrays;
import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Campo[][] tabuleiro = new Campo[3][3];
        Scanner scan = new Scanner(System.in);
        char simboloAtual = 'X'; //todo implementar um random aqui
        boolean gameON = true;

        iniciarJogo(tabuleiro);

        while (gameON) {
            desenhaJogo(tabuleiro);
            if (verificarVitoria(tabuleiro)) {
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

    public static boolean verificarVitoria (Campo[][] jogo) {
        boolean resposta = false;

        if (jogo[0][0].getSimbolo() == 'X' && jogo[0][1].getSimbolo() == 'X' && jogo[0][2].getSimbolo() == 'X' ||
                jogo[1][0].getSimbolo() == 'X' && jogo[1][1].getSimbolo() == 'X' && jogo[1][2].getSimbolo() == 'X' ||
                jogo[2][0].getSimbolo() == 'X' && jogo[2][1].getSimbolo() == 'X' && jogo[2][2].getSimbolo() == 'X' ||
                jogo[0][0].getSimbolo() == 'X' && jogo[1][0].getSimbolo() == 'X' && jogo[2][0].getSimbolo() == 'X' ||
                jogo[0][1].getSimbolo() == 'X' && jogo[1][1].getSimbolo() == 'X' && jogo[2][1].getSimbolo() == 'X' ||
                jogo[0][2].getSimbolo() == 'X' && jogo[1][2].getSimbolo() == 'X' && jogo[2][2].getSimbolo() == 'X' ||
                jogo[0][0].getSimbolo() == 'X' && jogo[1][1].getSimbolo() == 'X' && jogo[2][2].getSimbolo() == 'X' ||
                jogo[0][2].getSimbolo() == 'X' && jogo[1][1].getSimbolo() == 'X' && jogo[2][0].getSimbolo() == 'X'){
            System.out.printf("%n<< Vitória de %c >>%nJogo Encerrado!%n", 'X');
            resposta = true;
        }
        else if (jogo[0][0].getSimbolo() == 'O' && jogo[0][1].getSimbolo() == 'O' && jogo[0][2].getSimbolo() == 'O' ||
                jogo[1][0].getSimbolo() == 'O' && jogo[1][1].getSimbolo() == 'O' && jogo[1][2].getSimbolo() == 'O' ||
                jogo[2][0].getSimbolo() == 'O' && jogo[2][1].getSimbolo() == 'O' && jogo[2][2].getSimbolo() == 'O' ||
                jogo[0][0].getSimbolo() == 'O' && jogo[1][0].getSimbolo() == 'O' && jogo[2][0].getSimbolo() == 'O' ||
                jogo[0][1].getSimbolo() == 'O' && jogo[1][1].getSimbolo() == 'O' && jogo[2][1].getSimbolo() == 'O' ||
                jogo[0][2].getSimbolo() == 'O' && jogo[1][2].getSimbolo() == 'O' && jogo[2][2].getSimbolo() == 'O' ||
                jogo[0][0].getSimbolo() == 'O' && jogo[1][1].getSimbolo() == 'O' && jogo[2][2].getSimbolo() == 'O' ||
                jogo[0][2].getSimbolo() == 'O' && jogo[1][1].getSimbolo() == 'O' && jogo[2][0].getSimbolo() == 'O') {
            System.out.printf("<< Vitória de %c >>%nJogo Encerrado!%n", 'O');
            resposta = true;
        }

        return resposta;
    }
    //todo: implementar um met pra qnd o tab for td preenchido e ninguem venceu pra encerrar o jogo
}
