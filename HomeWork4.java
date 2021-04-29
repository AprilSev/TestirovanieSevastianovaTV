package dz4;

import com.sun.jndi.dns.DnsClient;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;


public class HomeWork4 {
    public static char[][] map;
    public static int mapSizeX;
    public static int mapSizeY;
    public static char human = 'x';
    public static char ai = 'o';
    public static char emptyField = '_';
    public static Scanner scanner = new Scanner(System.in);
    public static void creatMap(){
        mapSizeX = 3;
        mapSizeY = 3;
        map = new char[mapSizeX][mapSizeY];

        for (int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j < mapSizeY; j++) {
                map[i][j] = emptyField;
            }
        }
    }
    public static void showMap() {
        for (int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j < mapSizeY; j++) {
                System.out.print(map[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("________________");
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Enter your turn coordinates:");
        x = scanner.nextInt() - 1;
        y = scanner.nextInt() - 1;
        } while (!isValidCell(x,y) || !isEmptyCell(x,y));
        map[x][y] = human;
    }

    public static void aiTurn(){
        int x;
        int y;

        do {
            x = DnsClient.random.nextInt(mapSizeX);
            y = DnsClient.random.nextInt(mapSizeY);
        } while (!isEmptyCell(x,y));
        System.out.println("AI turn is [" + (x + 1) + " : " + (y + 1) + " ] ");
        map[x][y] = ai;
    }
    
    public static boolean isValidCell(int x, int y) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    public static boolean isEmptyCell(int x, int y) {
        return map[x][y] == emptyField;
    }

    public static boolean isDraw() {
        for (int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j < mapSizeY; j++) {
                if (map[i][j] == emptyField) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isWin(char player) {
        for (int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j < mapSizeY; j++)
                if (map[i][0] == player && map[i][1] == player && map[i][2] == player)
                    return true;
                if (map[0][i] == player && map[1][i] == player && map[2][i] == player)
                    return true;
                if (map[0][0] == player && map[1][1] == player && map[2][2] == player)
                    return true;
                if (map[0][2] == player && map[1][1] == player && map[2][0] == player)
                    return true;
        }
        return false;
    }



    public static void main (String[] args) {
        creatMap();
        showMap();
        while (true) {
            humanTurn();
            showMap();
            if (isWin(human)) {
                System.out.println("Human win");
                break;
            }
            if (isDraw()) {
                System.out.println("IS draw");
                break;
            }
            aiTurn();
            showMap();
            if (isWin(ai)) {
                System.out.println("Ai win");
                break;
            }
            if (isDraw()) {
                System.out.println("IS draw");
                break;
            }
            System.out.println("Game over");
        }
        }

}
