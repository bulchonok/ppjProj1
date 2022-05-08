import java.util.Scanner;

public class dv {
    public static void main(String[] args) {
                long black1 = 1, black2 = 1, white1 = 1, white2 = 1;
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


                int x = 0, y=0, s1=0, s2=0, s3=0, CountTurn = 0;
                boolean gameEnd = false, printed = false;



        while (!gameEnd) {

            //board print
                    int Counter;
                    long difBuffer = 0, buffer = 0;
                    boolean isBeated = false;
                    int xBeated=0,yBeated=0;

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
            boolean isChosen = false, isQueen = false;
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

                x1 = intSc - 1;
                y1 = ((int) charSc - 64) - 1;

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

                        if ((s3 == 1) && (x == x1) && (y == y1)) {

                            if (s1 == CountTurn % 2) {


                                isQueen = (s2 == 1);
                                isChosen = true;
                                System.out.println("intsc:" + intSc + " charsc:" + charSc + " x:" + x + " y:" + y + " s3:" + s3 + " x1:" + x1 + " y1:" + y1);

                            } else {
                                System.out.println("wrong color");
                            }
                        }

                    }

                }
            }
            //movement
            int MoveNotMade = 1;//for while to work
            int x2 = 0, y2 = 0;
            boolean WhiteMove = CountTurn % 2 == 1;

            while (MoveNotMade != 0) {

                if (!isQueen) {

                    if (MoveNotMade != 0) {
                        System.out.println("make a move:");//max 3 for checker
                        charSc = scannerChar.next().charAt(0);//char scanner
                        intSc = scannerInt.nextInt();
                    }
                    if (charSc < 65 || charSc > 72 || intSc < 1 || intSc > 8) {
                        System.out.println("Wrong move: make a move");
                        charSc = scannerChar.next().charAt(0);//char scanner
                        intSc = scannerInt.nextInt();
                    }

                    y2 = ((int) charSc - 64) - 1;
                    x2 = intSc - 1;
                    MoveNotMade = 0;

                    boolean p1 = (WhiteMove && (y2 - y1 == -1)),
                            p2 = (!WhiteMove && (y2 - y1 == 1)),
                            p3 = ((x2 - x1 == -1) || (x2 - x1 == 1)),
                            p11 = (WhiteMove && (y2 - y1 == -2)),
                            p12 = (!WhiteMove && (y2 - y1 == 2)),
                            p13 = ((x2 - x1 == -2) || (x2 - x1 == 2));

                    if ((p1 || p2) && p3) {

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

                                if (x == x2 && y == y2) {     //check if there is a checker on path
                                    System.out.println("wrong move: path blocked");
                                    MoveNotMade++;
                                }

                            }
                        }

                    } else if ((p11 || p12) && p13) {

                                xBeated = (x2 + x1) / 2;
                                yBeated = (y2 + y1) / 2;
                               int isNotEmpty = 0;


                        for (int i = 0; i < 2; i++) {
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

//
                                    if ((x == x2) && (y == y2)) {
                                        isNotEmpty++;
                                    }
                                    if ((s1 != CountTurn % 2) && ((x == xBeated) && (y == yBeated))) {
                                        isBeated = true;
                                    }
                                }
                            }
                        }
                        if (isNotEmpty == 0 && isBeated) {
                        } else {
                            MoveNotMade++;
                            System.out.println("wrong move: can't beat ");
                            System.out.println("intsc:" + intSc + " charsc" + charSc + " x:" + x + " y:" + y + " s3:" + s3 + " x1:" + x1 + " y1:" + y1+" x2:"+x2+" y2:" +y2+" xBeaten:"+xBeated+" yBeated:"+yBeated);
                        }


                    } else {
                        MoveNotMade++;
                        System.out.println("wrong move");
                    }
                } else {
                    //////if is queen
                    if (MoveNotMade != 0) {
                        System.out.println("make a move:");
                        charSc = scannerChar.next().charAt(0);
                        intSc = scannerInt.nextInt();
                    }
                    if (charSc < 65 || charSc > 72 || intSc < 1 || intSc > 8) {
                        System.out.println("Wrong move: make a move");
                        charSc = scannerChar.next().charAt(0);
                        intSc = scannerInt.nextInt();
                    }

                    //if ()
                }
            }
            //rewriting
            System.out.println("board processing...");
            for (int k = 1; k <5 ; k++) {
            buffer=0b1;
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

                if ((s3 == 1) && (x == x1) && (y == y1)){
                    x=x2;
                    y=y2;
                }
                if (isBeated){
                    if ((x==xBeated)&&(y==yBeated)){
                        s3=0;
                        s2=0;
                        s1=0;
                        x=0;
                        y=0;
                    }
                }
                if ( (s2==0) && ((y==7&&s1==0)||(y==0&&s1==1)) ){
                    s2=1;
                }

                    buffer = (((((((((buffer << 1) + s3) << 1) + s2) << 1) + s1) << 3) + y) << 3) + x;

            }
                System.out.println(Long.toBinaryString(buffer));
            switch (k) {
                case 1 -> black1 = buffer;
                case 2 -> black2 = buffer;
                case 3 -> white1 = buffer;
                case 4 -> white2 = buffer;

            }
        }

    }
}}