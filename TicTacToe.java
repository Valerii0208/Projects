import java.lang.reflect.Array;
import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] gameField = {{' ', '|', ' ', '|', ' '},
                {'—', '+', '—', '+', '—'},
                {' ', '|', ' ', '|', ' '},
                {'—', '+', '—', '+', '—'},
                {' ', '|', ' ', '|', ' '}};
        printField(gameField);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");
            int playerPos = scanner.nextInt();
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("Position taken! Enter a correct Position");
                playerPos = scanner.nextInt();
            }
            String result = winnerCheck();
            System.out.println(playerPos);
            placePiece(gameField, playerPos, "Player");
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random random = new Random();
            int cpuPos = random.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = random.nextInt(9) + 1;
            }
            placePiece(gameField, cpuPos, "CPU");
            printField(gameField);
            result = winnerCheck();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            System.out.println(result);
        }
    }

    public static void printField(char[][] gameField) {
        for (char[] row : gameField) {
            for (char columns : row) {
                System.out.print(columns);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameField, int pos, String user) {
        char symbol = ' ';
        if (user.equals("Player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("CPU")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }
        switch (pos) {
            case 1:
                gameField[0][0] = symbol;
                break;
            case 2:
                gameField[0][2] = symbol;
                break;
            case 3:
                gameField[0][4] = symbol;
                break;
            case 4:
                gameField[2][0] = symbol;
                break;
            case 5:
                gameField[2][2] = symbol;
                break;
            case 6:
                gameField[2][4] = symbol;
                break;
            case 7:
                gameField[4][0] = symbol;
                break;
            case 8:
                gameField[4][2] = symbol;
                break;
            case 9:
                gameField[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String winnerCheck() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List list : winning) {
            if (playerPositions.containsAll(list)) {
                return "Congratulations you won!";
            } else if (cpuPositions.containsAll(list)) {
                return "CPU wins! Sorry :(";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "CAT";
            }
        }
        return "";
    }
}
