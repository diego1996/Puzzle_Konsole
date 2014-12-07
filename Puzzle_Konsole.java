/*
  # Writed by @Diego_Asencio - diego1996
  # E-Mail diego.asencio@unillanos.edu.co
  # Puzzle_Konsole v1.0
  # Language JAVA
 */
package puzzle_konsole;

import java.util.Random;
import java.util.Scanner;

public class Puzzle_Konsole {
    
    private static  int Board[][]= new int [4][4];
    private static int copyBoard[][]= new int [4][4];
    private int numbersBoard[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    Random rnd=new Random();
    
    public static void main(String[] args) {
        Puzzle_Konsole i = new Puzzle_Konsole();
        Scanner leer = new Scanner(System.in);
        i.randomBoard();
        i.winBoard();
        while(true) {
            i.printBoard();
            int d_aux;
            int f=i.detectZero('f');
            int c=i.detectZero('c');
            System.out.println("[+] MOVER \n [W] Abajo hacia Arriba \n [S] Arriba hacia Abajo \n [A] Derecha hacia Izquierda \n [D] Izquierda hacia Derecha \n Salir [q/Q] ");
            String opm = leer.next();
            switch(opm) {
                case "w": case "W":
                    if((f+1<4)) {
                        d_aux = Board[f+1][c];
                        Board[f+1][c] = Board[f][c];
                        Board[f][c] = d_aux;
                    }else {
                        System.out.println("Invalido");
                    }                    
                break;
                case "s": case "S":
                    if(f-1>-1) {
                        d_aux = Board[f-1][c];
                        Board[f-1][c] = Board[f][c];
                        Board[f][c] = d_aux;
                    }else {
                        System.out.println("Invalido");
                    }
                break;
                case "a": case "A":
                    if(c+1<4) {
                        d_aux = Board[f][c+1];
                        Board[f][c+1] = Board[f][c];
                        Board[f][c] = d_aux;
                    }else {
                        System.out.println("Invalido");
                    }
                break;
                case "d": case "D":
                    if(c-1>-1) {
                        d_aux = Board[f][c-1];
                        Board[f][c-1] = Board[f][c];
                        Board[f][c] = d_aux;
                    }else {
                        System.out.println("Invalido");
                    }
                break;
                case "q": case "Q":
                    System.exit(-1);
                break;
                default: 
                    System.out.println("[-] " + opm + " No Es Una Opcion Valida...");
                break;
            }
            
            if(Winner()) {
                System.out.println("Has Ganado!!!");
                System.exit(0);
            }
        }
    }
  
    public static void winBoard() {
        int c=15;
        for(int i=0;i<Board.length;i++) {
            for(int j=0;j<Board.length;j++) {
                copyBoard[i][j] = c;
                c--;
            }
        }
    }
    
    public static boolean Winner() {
        int c=0;
        for(int i=0;i<Board.length;i++) {
            for(int j=0;j<Board.length;j++) {
                if(copyBoard[i][j] == Board[i][j]) c++;
            }
        }
        if(c == 16) return true;
        else return false;
    }
       
    private int detectZero(char par) {
        for(int i=0;i<Board.length;i++) {
            for(int j=0;j<Board.length;j++) {
                if(Board[i][j] == 0) { 
                    if(par=='f') return i; 
                    else return j;
                }
            }
        }
        return 0;
    }

    private void printBoard() {
        for(int i=0;i<Board.length;i++) {
            for(int j=0;j<Board.length;j++) {
                System.out.printf("%s\t", Board[i][j]);
            }   System.out.println("\n");
        }
    }

    private void randomBoard() {
        int aux,max=(Board.length*Board.length);
        for(int i=0;i<Board.length;i++) {
            for(int j=0;j<Board.length;j++) {
                aux = rnd.nextInt(max); 
                Board[i][j] = numbersBoard[aux];
                numbersBoard[aux]=numbersBoard[max-1];
                max--;
            }
        }
    }
    
}
