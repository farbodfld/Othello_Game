import java.util.Scanner;

public class Game_Setup {
    boolean O_turn = true;
    int finisher_counter = 0;
    int counter_O = 2;
    int counter_I = 2;

    String[][] background = new String[9][9];

    public Game_Setup() {
        background[0][0] = " ";
        for (int i = 1; i < 9; i++) {
            background[0][i] = String.valueOf(i);
            background[i][0] = String.valueOf(i);
        }
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                background[i][j] = ".";
            }
        }
        background[4][4] = "I";
        background[5][4] = "O";
        background[4][5] = "O";
        background[5][5] = "I";
    }

    public void ShowArray() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(background[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void whose_turn() {
        if (O_turn) {
            System.out.println("please enter coordinate (first column and then row)");
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int column = sc.nextInt();
            if (background[row + 1][column].equals("I") || background[row - 1][column].equals("I") || background[row][column + 1].equals("I") || background[row][column - 1].equals("I") || background[row + 1][column + 1].equals("I") || background[row - 1][column - 1].equals("I") || background[row - 1][column + 1].equals("I") || background[row + 1][column - 1].equals("I") && background[row][column].equals(".")) {
                background[row][column] = "O";
                if (background[row + 1][column].equals("I")) {
                    background[row + 1][column] = "O";
                    counter_O++;
                    counter_I--;

                } else if (background[row][column + 1].equals("I")) {
                    background[row][column + 1] = "O";
                    counter_O++;
                    counter_I--;

                } else if (background[row + 1][column + 1].equals("I")) {
                    background[row + 1][column + 1] = "O";
                    counter_O++;
                    counter_I--;

                } else if (background[row - 1][column - 1].equals("I")) {
                    background[row - 1][column - 1] = "O";
                    counter_O++;
                    counter_I--;

                } else if (background[row][column - 1].equals("I")) {
                    background[row][column - 1] = "O";
                    counter_O++;
                    counter_I--;

                } else if (background[row - 1][column].equals("I")) {
                    background[row - 1][column] = "O";
                    counter_O++;
                    counter_I--;
                } else if (background[row + 1][column - 1].equals("I") && background[row + 2][column - 2].equals("O")) {
                    background[row + 1][column - 1] = "O";
                    counter_O++;
                    counter_I--;
                } else if (background[row - 1][column + 1].equals("I") && background[row - 2][column + 2].equals("O")) {
                    background[row - 1][column + 1] = "O";
                    counter_O++;
                    counter_I--;
                }
                finisher_counter++;
                ShowArray();
                O_turn = false;
            } else {
                System.out.println("you should set coordinate near by I player");
            }
        } else {
            System.out.println("please enter coordinate (first column and then row)");
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int column = sc.nextInt();
            if (background[row + 1][column].equals("O") || background[row - 1][column].equals("O") || background[row][column + 1].equals("O") || background[row][column - 1].equals("O") || background[row + 1][column + 1].equals("O") || background[row - 1][column - 1].equals("O") && background[row][column].equals(".")) {
                background[row][column] = "I";
                if (background[row + 1][column].equals("O")) {
                    background[row + 1][column] = "I";
                    counter_O--;
                    counter_I++;

                } else if (background[row][column + 1].equals("O")) {
                    background[row][column + 1] = "I";
                    counter_O--;
                    counter_I++;

                } else if (background[row + 1][column + 1].equals("O")) {
                    background[row + 1][column + 1] = "I";
                    counter_O--;
                    counter_I++;

                } else if (background[row - 1][column - 1].equals("O")) {
                    background[row - 1][column - 1] = "I";
                    counter_O--;
                    counter_I++;

                } else if (background[row][column - 1].equals("O")) {
                    background[row][column - 1] = "I";
                    counter_O--;
                    counter_I++;

                } else if (background[row - 1][column].equals("O")) {
                    background[row - 1][column] = "I";
                    counter_O--;
                    counter_I++;
                } else if (background[row + 1][column - 1].equals("O") && background[row + 2][column - 2].equals("I")) {
                    background[row + 1][column - 1] = "I";
                    counter_O--;
                    counter_I++;
                } else if (background[row - 1][column + 1].equals("O") && background[row - 2][column + 2].equals("I")) {
                    background[row - 1][column + 1] = "I";
                    counter_O--;
                    counter_I++;
                }
                finisher_counter++;
                ShowArray();
                O_turn = true;
            } else {
                System.out.println("you should set coordinate near by O player");
            }
        }
    }

    public void Win() {
        if (counter_I > counter_O) {
            System.out.println("I player is winner");
        } else {
            System.out.println("O player is winner");
        }
    }

    public static void main(String[] args) {
        Game_Setup gs = new Game_Setup();
        gs.ShowArray();
        while (true) {
            if (gs.finisher_counter == 64) {
                gs.Win();
                break;
            } else {
                gs.whose_turn();
            }
        }
    }
}