import java.util.Scanner;

public class dv {
    public static void main(String[] args) {
        long black1 = 0, black2 = 0, white1 = 0, white2 = 0;
        int counter = 0;
        Scanner scannerChar = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 5; j++) {
                if (counter < 6) {
                    black1 = (((((black1 << 3) + 0b100) << 3) + i - 1) << 3) + (((2 * j) - (i % 2)) - 1);
                    white1 = (((((white1 << 3) + 0b101) << 3) + i + 4) << 3) + ((2 * j) - ((i+1) % 2))-1;
                } else {
                    black2 = (((((black2 << 3) + 0b100) << 3) + i - 1) << 3) + (((2 * j) - (i % 2)) - 1);
                    white2 = (((((white2 << 3) + 0b101) << 3) + i + 4) << 3) +((2 * j) - ((i+1) % 2))-1;
                }
                counter++;


            }
        }
        System.out.println(Long.toBinaryString(black1));
        System.out.println(Long.toBinaryString(black2));
        System.out.println(Long.toBinaryString(white1));
        System.out.println(Long.toBinaryString(white2));


        int x, y, s1, s2, s3, CountTurn = 0, ChooseLong;
        long difBuffer = 0, buffer = 0;
        boolean gameEnd = false, printed = false;
int Counter;


        while (!gameEnd) {

            //board print

            for (int i = 7; i > -1; i--) {
                System.out.print((char) (65 + i) + " |");
                for (int j = 0; j < 8; j++) {
                    Counter = 0;
                    for (int k = 1; k < 5; k++) {
                        switch (k) {

                            case 1 -> difBuffer = black1;
                            case 2 -> difBuffer = black2;
                            case 3 -> difBuffer = white1;
                            case 4 -> difBuffer = white2;
                        }
                        for (int var = 0; var < 6; var++) {

                            x = (int) (difBuffer % 8);
                            difBuffer = difBuffer >> 3;
                            y = (int) (difBuffer % 8);
                            difBuffer = difBuffer >> 3;

                            s1 = (int) (difBuffer % 2);
                            difBuffer = difBuffer >> 1;
                            s2 = (int) (difBuffer % 2);
                            difBuffer = difBuffer >> 1;
                            s3 = (int) (difBuffer % 2);
                            difBuffer = difBuffer >> 1;

                            if ((x == j) && (y == i)) {

                                if (s3 == 1) {

                                    switch (k) {
                                        case 1, 2 -> System.out.print(s2 == 1 ? '\u265B' + " " : '\u2659' + " ");
                                        case 3, 4 -> System.out.print(s2 == 1 ? '\u2655' + " " : '\u265F' + " ");
                                    }
                                }
                            } else {
                                Counter++;
                            }
                        }
                        if (Counter == 24) System.out.print((i + j) % 2 == 0 ? '\u2B1C' + " " : '\u2B1B' + " ");
                    }

                }


                System.out.print("| " + (char) (65 + i));
                System.out.println();
            }

            //selection
            int x1 = 0, y1 = 0;
            boolean isChosen = false, isDamka = false;
            char charSc = 0;
            int intSc = 0;
            CountTurn++;
            System.out.println(CountTurn % 2 == 1 ? "white's turn" : "black's turn");
            while (!isChosen) {
                if (!isChosen) {
                    System.out.println("choose your checker");
                    charSc = scannerChar.next().charAt(0);//char scanner
                    intSc = scannerInt.nextInt();
                }
                if (charSc < 65 || charSc > 72 || intSc < 1 || intSc > 8) {
                    System.out.println("Wrong parameter: choose your checker");
                    charSc = scannerChar.next().charAt(0);//char scanner
                    intSc = scannerInt.nextInt();
                }
                System.out.println("test");
                for (int k = 1; k < 5; k++) {
                    switch (k) {

                        case 1 -> difBuffer = black1;
                        case 2 -> difBuffer = black2;
                        case 3 -> difBuffer = white1;
                        case 4 -> difBuffer = white2;
                    }
                    for (int var = 0; var < 6; var++) {

                        x = (int) (difBuffer % 8);
                        difBuffer = difBuffer >> 3;
                        y = (int) (difBuffer % 8);
                        difBuffer = difBuffer >> 3;

                        s1 = (int) (difBuffer % 2);
                        difBuffer = difBuffer >> 1;
                        s2 = (int) (difBuffer % 2);
                        difBuffer = difBuffer >> 1;
                        s3 = (int) (difBuffer % 2);
                        difBuffer = difBuffer >> 1;

                        if ((s3 == 1) && ((x + 1) == intSc) && ((y + 1) == ((int) charSc - 64))) {

                            if (s1 == CountTurn % 2) {


                                isDamka = s2 == 1;
                                x1 = intSc - 1;
                                y1 = ((int) charSc - 64) - 1;
                                isChosen = true;
                                System.out.println("intsc:"+intSc+" charsc"+charSc+" x:"+x+"y:"+y+"s3:"+s3+"x1:"+x1+"y1:"+y1);

                            } else {
                                System.out.println("wrong color");
                            }
                        }

                    }

                }

            //movement

            //rewriting


        }
    }
}}