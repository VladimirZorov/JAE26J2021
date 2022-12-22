import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pythonLength = 1;
        int rowPython = -1;
        int collPython = -1;
        int foodCount = 0;
        boolean isKilled = false;

        int screenSize = Integer.parseInt(scanner.nextLine());
        String[][] screen = new String[screenSize][screenSize];

        String[] commands = scanner.nextLine().split(", ");

        for (int i = 0; i < screenSize; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < screenSize; j++) {
                if (line[j].equals("s")) {
                    rowPython = i;
                    collPython = j;
                }
                if (line[j].equals("f")) {
                    foodCount++;
                }
            }

            screen[i] = line;
        }


            for (int i = 0; i < commands.length; i++) {
                switch (commands[i]) {
                    case "left":
                        if ((collPython - 1) >= 0) {
                            collPython--;
                        } else {
                            collPython = screenSize - 1;
                        }
                        break;
                    case "right":
                        if ((collPython + 1) < screenSize) {
                            collPython++;
                        } else {
                            collPython = 0;
                        }
                        break;
                    case "up":
                        if ((rowPython - 1) >= 0) {
                            rowPython--;
                        } else {
                            rowPython = screenSize - 1;
                        }
                        break;
                    case "down":
                        if ((rowPython + 1) < screenSize) {
                            rowPython++;
                        } else {
                            rowPython = 0;
                        }
                        break;
                }
                if (screen[rowPython][collPython].equals("e")) {
                    isKilled = true;
                    break;
                } else if (screen[rowPython][collPython].equals("f")) {
                    foodCount--;
                    pythonLength++;
                }
            }


        if (isKilled) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (!isKilled && foodCount ==0) {
            System.out.printf("You win! Final python length is %d", pythonLength);
        } else if (!isKilled && foodCount != 0) {
            System.out.printf("You lose! There is still %d food to be eaten.", foodCount);
        }
    }
}
