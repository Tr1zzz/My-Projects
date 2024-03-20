import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

        private User user;
        private Computer computer;
        private int userScore;
        private int computerScore;
        private int numberOfGames;

        private enum Move {
            ROCK, PAPER, SCISSORS;


            public int compareMoves(Move otherMove) {
                // Remis
               if (this == otherMove)
                    return 0;

                switch (this) {
                    case ROCK:
                        return (otherMove == SCISSORS ? 1 : -1);
                    case PAPER:
                        return (otherMove == ROCK ? 1 : -1);
                    case SCISSORS:
                        return (otherMove == PAPER ? 1 : -1);
                }



                return 0;
            }
        }

        private class User {
            private Scanner inputScanner;

            public User() {
                inputScanner = new Scanner(System.in);
            }

            public Move getMove() {
                // Wyślemy prośbę o wejście
                System.out.print("ROCK, PAPER or SCISSORS? ");

                // Przeczytaj dane wprowadzone przez użytkownika
                String userInput = inputScanner.nextLine();
                userInput = userInput.toUpperCase();
                char firstLetter = userInput.charAt(0);
                if (firstLetter == 'R' || firstLetter == 'P' || firstLetter == 'S') {
                    // Wprowadzone dane są prawidłowe
                    switch (firstLetter) {
                        case 'R':
                            return Move.ROCK;
                        case 'P':
                            return Move.PAPER;
                        case 'S':
                            return Move.SCISSORS;
                    }
                }

                // Wprowadzone dane są nieprawidłowe. Wyświetlmy ponownie żądanie wprowadzenia danych.
                return getMove();
            }

            public boolean playAgain() {
                System.out.print("Do you want to play again? YES/NO ");
                String userInput = inputScanner.nextLine();
                userInput = userInput.toUpperCase();
                return userInput.charAt(0) == 'Y';
            }
        }

        private class Computer {
            public Move getMove() {
                Move[] moves = Move.values();
                Random random = new Random();
                int index = random.nextInt(moves.length);
                return moves[index];
            }
        }

        public Main() {
            user = new User();
            computer = new Computer();
            userScore = 0;
            computerScore = 0;
            numberOfGames = 0;
        }

        public void startGame() {
            System.out.println("ROCK, PAPER, SCISSORS!");

            // Pobieranie ruchów
            Move userMove = user.getMove();
            Move computerMove = computer.getMove();
            System.out.println("\nYour move " + userMove + ".");
            System.out.println("Computer`s move " + computerMove + ".\n");

            // Porównanie ruchów i określenie zwycięzcy
            int compareMoves = userMove.compareMoves(computerMove);
            switch (compareMoves) {
                case 0: // Remis
                    System.out.println("Tie!");
                    break;
                case 1: // Gracz wygrał
                    System.out.println(userMove + " beats " + computerMove + ". You win!");
                    userScore++;
                    break;
                case -1: // Wygrał komputer
                    System.out.println(computerMove + " beats " + userMove + ". You lose :(");
                    computerScore++;
                    break;
            }
            numberOfGames++;

            // Poproś użytkownika o ponowne zagranie
            if (user.playAgain()) {
                System.out.println();
                startGame();
            } else {
                printGameStats();
            }
        }

        /**
         * Dane wyjściowe statystyki. Remisy liczą się jako połowa wygranej
         * przy obliczaniu procentu wygranych.
         */
        private void printGameStats() {
            int wins = userScore;
            int losses = computerScore;
            int ties = numberOfGames - userScore - computerScore;
            double percentageWon = (wins + ((double) ties) / 2) / numberOfGames;

            // Wyjście linii (górna)
            System.out.print("+");
            printDashes(68);
            System.out.println("+");

            // Wyświetlanie nagłówków tabel
            System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |  %14s  |\n",
                    "WINS", "LOSSES", "TIES", "GAMES PLAYED", "PERCENTAGE WON");

            // Wyjście linii
            System.out.print("|");
            printDashes(10);
            System.out.print("+");
            printDashes(10);
            System.out.print("+");
            printDashes(10);
            System.out.print("+");
            printDashes(16);
            System.out.print("+");
            printDashes(18);
            System.out.println("|");

            // Wartość wyjściowa
            System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |  %13.2f%%  |\n",
                    wins, losses, ties, numberOfGames, percentageWon * 100);

            // Wyjście linii (dolna)
            System.out.print("+");
            printDashes(68);
            System.out.println("+");
            creatFile("file.txt");
        }

        private void printDashes(int numberOfDashes) {
            for (int i = 0; i < numberOfDashes; i++) {
                System.out.print("-");
            }
        }
    private void creatFile( String file) {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;
        double percentageWon = (wins + ((double) ties) / 2) / numberOfGames;

        String l = String.format("|  %6s  |  %6s  |  %6s  |  %12s  |  %14s  |\n",
                "WINS", "LOSSES", "TIES", "GAMES PLAYED", "PERCENTAGE WON");
        String dashes = "+--------------------------------------------------------------------+";
        String s = String.format("|  %6d  |  %6d  |  %6d  |  %12d  |  %13.2f%%  |\n",
                wins, losses, ties, numberOfGames, percentageWon * 100);

        File file1 = new File("Results.txt");
        try {
            FileWriter myWriter = new FileWriter("Results.txt");
            myWriter.write(dashes + "\n"+l+dashes+"\n"+s+dashes);

            myWriter.close();
            System.out.println("Successfully wrote to the file. Check it out!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }
        public static void main(String[] args) {
            Main game = new Main();
            game.startGame();

        }


    }
