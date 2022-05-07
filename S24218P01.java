import java.util.Scanner;

public
class S24218P01 {
    public static void main(String[] args) {
        long black1 = 0,
                black2 = 0,
                white1 = 0,
                white2 = 0;
        int counter = 0, co = 0;
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
                co++;
                System.out.println(Long.toBinaryString(black1) + "\n" + Long.toBinaryString(black2) + "\n" + co);
                System.out.println();

            }
        }
        /////////////////////////////////////////////////////////////////////////
        long b1 = black1, b2 = black2, w1 = white1, w2 = white2;
        int x = 0, y = 0;
        int s1, s2, s3, CountTurn = 0;
        boolean turn = false;
        boolean gameEnd = false;
        while (!gameEnd) {


            for (int i = 7; i > -1; i--) {
                for (int j = 0; j < 8; j++) {


                    b1 = black1;      //important thing to reset value  //////!!!!! add check if checker isn't beaten
                    for (int k = 0; k < 6; k++) {
                        x = (int) (b1 % 8);
                        b1 = b1 >> 3;
                        y = (int) (b1 % 8);
                        b1 = b1 >> 3;

                        s1 = (int) (b1 % 2);
                        b1 = b1 >> 1;
                        s2 = (int) (b1 % 2);
                        b1 = b1 >> 1;
                        s3 = (int) (b1 % 2);
                        b1 = b1 >> 1;


                        if ((s3 == 1) && (x == j) && (y == i)) {     //check if there is a pon
                            System.out.print('\u2659' + " ");
                            turn = true;
                        }
                    }


                    b2 = black2;      //important thing to reset value
                    for (int k = 0; k < 6; k++) {
                        x = (int) (b2 % 8);
                        b2 = b2 >> 3;
                        y = (int) (b2 % 8);
                        b2 = b2 >> 3;

                        s1 = (int) (b2 % 2);
                        b2 = b2 >> 1;
                        s2 = (int) (b2 % 2);
                        b2 = b2 >> 1;
                        s3 = (int) (b2 % 2);
                        b2 = b2 >> 1;

                        if ((s3 == 1) && (x == j) && (y == i)) {     //check if there is a pon
                            System.out.print('\u2659' + " ");
                            turn = true;
                        }
                    }


                    w1 = white1;      //important thing to reset value
                    for (int k = 0; k < 6; k++) {
                        x = (int) (w1 % 8);
                        w1 = w1 >> 3;
                        y = (int) (w1 % 8);
                        w1 = w1 >> 3;

                        s1 = (int) (w1 % 2);
                        w1 = w1 >> 1;
                        s2 = (int) (w1 % 2);
                        w1 = w1 >> 1;
                        s3 = (int) (w1 % 2);
                        w1 = w1 >> 1;

                        if ((s3 == 1) && (x == j) && (y == i)) {     //check if there is a pon
                            System.out.print('\u265F' + " ");
                            turn = true;
                        }
                    }


                    w2 = white2;      //important thing to reset value
                    for (int k = 0; k < 6; k++) {
                        x = (int) (w2 % 8);
                        w2 = w2 >> 3;
                        y = (int) (w2 % 8);
                        w2 = w2 >> 3;

                        s1 = (int) (w2 % 2);
                        w2 = w2 >> 1;
                        s2 = (int) (w2 % 2);
                        w2 = w2 >> 1;
                        s3 = (int) (w2 % 2);
                        w2 = w2 >> 1;


                        if ((s3 == 1) && (x == j) && (y == i)) {     //check if there is a pon
                            System.out.print('\u265F' + " ");
                            turn = true;
                        }


                    }


                    if (!turn) System.out.print((i + j) % 2 == 0 ? '\u2B1C' + " " : '\u2B1B' + " ");
                    turn = false;

                }
                System.out.println();
            }
            int x1 = 0, y1 = 0;
            boolean isChosen = false, isDamka = false;
            char charSc = 0;
            int intSc = 0;

            CountTurn++;

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

                b1 = black1;      //important thing to reset value  //////!!!!! add check if checker isn't beaten
                for (int k = 0; k < 6; k++) {
                    x = (int) (b1 % 8);
                    b1 = b1 >> 3;
                    y = (int) (b1 % 8);
                    b1 = b1 >> 3;

                    s1 = (int) (b1 % 2);
                    b1 = b1 >> 1;
                    s2 = (int) (b1 % 2);
                    b1 = b1 >> 1;
                    s3 = (int) (b1 % 2);
                    b1 = b1 >> 1;


                    if ((s3 == 1) && (x+1 == intSc) && (y+1 == ((int) charSc - 64))) {
                        if (s1 == CountTurn % 2) {


                            isDamka =s2==1;
                            x1 = intSc-1;
                            y1 = ((int) charSc - 64)-1;
                            isChosen = true;


                        }else {
                            System.out.println("wrong color 1");
                        }
                    }
                }


                b2 = black2;      //important thing to reset value
                for (int k = 0; k < 6; k++) {
                    x = (int) (b2 % 8);
                    b2 = b2 >> 3;
                    y = (int) (b2 % 8);
                    b2 = b2 >> 3;

                    s1 = (int) (b2 % 2);
                    b2 = b2 >> 1;
                    s2 = (int) (b2 % 2);
                    b2 = b2 >> 1;
                    s3 = (int) (b2 % 2);
                    b2 = b2 >> 1;


                    if ((s3 == 1) && (x+1 == intSc) && (y+1 == ((int) charSc - 64))) {
                        if (s1 == CountTurn % 2) {


                            isDamka =s2==1;
                            x1 = intSc-1;
                            y1 = ((int) charSc - 64)-1;
                            isChosen = true;


                        }else {
                            System.out.println("wrong color 2");
                        }
                    }
                }


                w1 = white1;      //important thing to reset value
                for (int k = 0; k < 6; k++) {
                    x = (int) (w1 % 8);
                    w1 = w1 >> 3;
                    y = (int) (w1 % 8);
                    w1 = w1 >> 3;

                    s1 = (int) (w1 % 2);
                    w1 = w1 >> 1;
                    s2 = (int) (w1 % 2);
                    w1 = w1 >> 1;
                    s3 = (int) (w1 % 2);
                    w1 = w1 >> 1;


                    if ((s3 == 1) && (x+1 == intSc) && (y+1 == ((int) charSc - 64))) {
                        if (s1 == CountTurn % 2) {


                            isDamka =s2==1;
                            x1 = intSc-1;
                            y1 = ((int) charSc - 64)-1;
                            isChosen = true;


                        }else {
                            System.out.println("wrong color 3");
                            System.out.println(s1 +" = "+CountTurn % 2);
                        }
                    }
                }


                w2 = white2;      //important thing to reset value
                for (int k = 0; k < 6; k++) {
                    x = (int) (w2 % 8);
                    w2 = w2 >> 3;
                    y = (int) (w2 % 8);
                    w2 = w2 >> 3;

                    s1 = (int) (w2 % 2);
                    w2 = w2 >> 1;
                    s2 = (int) (w2 % 2);
                    w2 = w2 >> 1;
                    s3 = (int) (w2 % 2);
                    w2 = w2 >> 1;


                    if ((s3 == 1) && (x+1 == intSc) && (y+1 == ((int) charSc - 64))) {
                        if (s1 == CountTurn % 2) {


                            isDamka =s2==1;
                            x1 = intSc-1;
                            y1 = ((int) charSc - 64)-1;
                            isChosen = true;


                        }else {
                            System.out.println("wrong color 4");
                        }
                    }


                }
                if (!isChosen) System.out.println("wrong field");


            }

            int MoveNotMade = 1;
            int x2 = x1, y2 = y1;
                                                        while (MoveNotMade != 0) {
                                                            if (!isDamka) {
                                                                System.out.println("make a move:");//max 3 for checker
                                                                charSc = scannerChar.next().charAt(0);//char scanner
                                                                intSc = scannerInt.nextInt();
                                                                y2 = ((int) charSc - 64)-1;
                                                                x2 = intSc-1;

                                                                if ((x1 == (x2+1)||(x1 == (x2-1)))&& ((CountTurn%2 == 1 && y2 + 1 == y1) || (CountTurn%2 == 0 && y2 - 1 == y1))) {
                                                                    MoveNotMade = 0;
                                                                    b1 = black1;      //important thing to reset value  //////!!!!! add check if checker isn't beaten
                                                                    for (int k = 0; k < 6; k++) {
                                                                        x = (int) (b1 % 8);
                                                                        b1 = b1 >> 3;
                                                                        y = (int) (b1 % 8);
                                                                        b1 = b1 >> 3;

                                                                        s1 = (int) (b1 % 2);
                                                                        b1 = b1 >> 1;
                                                                        s2 = (int) (b1 % 2);
                                                                        b1 = b1 >> 1;
                                                                        s3 = (int) (b1 % 2);
                                                                        b1 = b1 >> 1;


                                                                        if (x == x2 && y == y2) {     //check if there is a pon
                                                                            System.out.println("wrong move: path blocked");
                                                                            MoveNotMade++;
                                                                        }
                                                                    }


                                                                    b2 = black2;      //important thing to reset value
                                                                    for (int k = 0; k < 6; k++) {
                                                                        x = (int) (b2 % 8);
                                                                        b2 = b2 >> 3;
                                                                        y = (int) (b2 % 8);
                                                                        b2 = b2 >> 3;

                                                                        s1 = (int) (b2 % 2);
                                                                        b2 = b2 >> 1;
                                                                        s2 = (int) (b2 % 2);
                                                                        b2 = b2 >> 1;
                                                                        s3 = (int) (b2 % 2);
                                                                        b2 = b2 >> 1;

                                                                        if (x == x2 && y == y2) {     //check if there is a pon
                                                                            System.out.println("wrong move: path blocked");
                                                                            MoveNotMade++;
                                                                        }
                                                                    }


                                                                    w1 = white1;      //important thing to reset value
                                                                    for (int k = 0; k < 6; k++) {
                                                                        x = (int) (w1 % 8);
                                                                        w1 = w1 >> 3;
                                                                        y = (int) (w1 % 8);
                                                                        w1 = w1 >> 3;

                                                                        s1 = (int) (w1 % 2);
                                                                        w1 = w1 >> 1;
                                                                        s2 = (int) (w1 % 2);
                                                                        w1 = w1 >> 1;
                                                                        s3 = (int) (w1 % 2);
                                                                        w1 = w1 >> 1;

                                                                        if (x == x2 && y == y2) {     //check if there is a pon
                                                                            System.out.println("wrong move: path blocked");
                                                                            MoveNotMade++;
                                                                        }
                                                                    }


                                                                    w2 = white2;      //important thing to reset value
                                                                    for (int k = 0; k < 6; k++) {
                                                                        x = (int) (w2 % 8);
                                                                        w2 = w2 >> 3;
                                                                        y = (int) (w2 % 8);
                                                                        w2 = w2 >> 3;

                                                                        s1 = (int) (w2 % 2);
                                                                        w2 = w2 >> 1;
                                                                        s2 = (int) (w2 % 2);
                                                                        w2 = w2 >> 1;
                                                                        s3 = (int) (w2 % 2);
                                                                        w2 = w2 >> 1;


                                                                        if (x == x2 && y == y2) {     //check if there is a pon
                                                                            System.out.println("wrong move: path blocked");
                                                                            MoveNotMade++;
                                                                        }

                                                                    }

                                                                } else if (((x1 == x2 - 2) || (x1 == x2 + 2)) && ((CountTurn%2 == 1 && y2 + 2 == y1) || (CountTurn%2 == 0 && y2 - 2 == y1))) {
                                                                    int xSR = x2 - x1 < 0 ? x2 - 1 : x2 + 1, ySR = CountTurn%2 == 1 ? y2 + 1 : y2 - 1;
                                                                    boolean isPusta = true;
                                                                    for (int i = 0; i < 2; i++) {


                                                                        MoveNotMade = 0;
                                                                        b1 = black1;      //important thing to reset value  //////!!!!! add check if checker isn't beaten
                                                                        for (int k = 0; k < 6; k++) {
                                                                            x = (int) (b1 % 8);
                                                                            b1 = b1 >> 3;
                                                                            y = (int) (b1 % 8);
                                                                            b1 = b1 >> 3;

                                                                            s1 = (int) (b1 % 2);
                                                                            b1 = b1 >> 1;
                                                                            s2 = (int) (b1 % 2);
                                                                            b1 = b1 >> 1;
                                                                            s3 = (int) (b1 % 2);
                                                                            b1 = b1 >> 1;

                                                                            switch (i) {
                                                                                case 0 -> {

                                                                                    if (x2 == x && y2 == y) {
                                                                                        isPusta = false;
                                                                                    }

                                                                                }
                                                                                case 1 -> {

                                                                                    if (x == xSR && y == ySR && s1 != CountTurn%2 && isPusta) {
                                                                                        //change to beaten stan


                                                                                    }

                                                                                }
                                                                            }
                                                                                                                                                    /*if () {     //check if there is a pon
                                                                                                                                                        System.out.println("wrong move: can't be beaten");
                                                                                                                                                        MoveNotMade++;
                                                                                                                                                    }*/
                                                                        }


                                                                        b2 = black2;      //important thing to reset value
                                                                        for (int k = 0; k < 6; k++) {
                                                                            x = (int) (b2 % 8);
                                                                            b2 = b2 >> 3;
                                                                            y = (int) (b2 % 8);
                                                                            b2 = b2 >> 3;

                                                                            s1 = (int) (b2 % 2);
                                                                            b2 = b2 >> 1;
                                                                            s2 = (int) (b2 % 2);
                                                                            b2 = b2 >> 1;
                                                                            s3 = (int) (b2 % 2);
                                                                            b2 = b2 >> 1;

                                                                            if (x == x1 && (y1 + 1) == y && y != 7) {     //check if there is a pon
                                                                                System.out.println("wrong move: path blocked");
                                                                                MoveNotMade++;
                                                                            }
                                                                        }


                                                                        w1 = white1;      //important thing to reset value
                                                                        for (int k = 0; k < 6; k++) {
                                                                            x = (int) (w1 % 8);
                                                                            w1 = w1 >> 3;
                                                                            y = (int) (w1 % 8);
                                                                            w1 = w1 >> 3;

                                                                            s1 = (int) (w1 % 2);
                                                                            w1 = w1 >> 1;
                                                                            s2 = (int) (w1 % 2);
                                                                            w1 = w1 >> 1;
                                                                            s3 = (int) (w1 % 2);
                                                                            w1 = w1 >> 1;

                                                                            if (x == x1 && (y1 + 1) == y && y != 7) {     //check if there is a pon
                                                                                System.out.println("wrong move: path blocked");
                                                                                MoveNotMade++;
                                                                            }
                                                                        }


                                                                        w2 = white2;      //important thing to reset value
                                                                        for (int k = 0; k < 6; k++) {
                                                                            x = (int) (w2 % 8);
                                                                            w2 = w2 >> 3;
                                                                            y = (int) (w2 % 8);
                                                                            w2 = w2 >> 3;

                                                                            s1 = (int) (w2 % 2);
                                                                            w2 = w2 >> 1;
                                                                            s2 = (int) (w2 % 2);
                                                                            w2 = w2 >> 1;
                                                                            s3 = (int) (w2 % 2);
                                                                            w2 = w2 >> 1;


                                                                            if (x == x1 && (y1 + 1) == y && y != 7) {     //check if there is a pon
                                                                                System.out.println("wrong move: path blocked");
                                                                                MoveNotMade++;
                                                                            }

                                                                        }


                                                                    }


                                                                }


                                                            } else {
                                                                System.out.println("make a move:");//max 3 for checker
                                                                charSc = scannerChar.next().charAt(0);//char scanner
                                                                intSc = scannerInt.nextInt();
                                                                //paste appr 50-120 //check cords provided //get arguments: colorIsCorret,
                                                                //...


                                                            }

                                                        }
///change place
            long buffer = 0;
            b1 = black1;      //important thing to reset value  //////!!!!! add check if checker isn't beaten
            for (int k = 0; k < 6; k++) {
                x = (int) (b1 % 8);
                b1 = b1 >> 3;
                y = (int) (b1 % 8);
                b1 = b1 >> 3;

                s1 = (int) (b1 % 2);
                b1 = b1 >> 1;
                s2 = (int) (b1 % 2);
                b1 = b1 >> 1;
                s3 = (int) (b1 % 2);
                b1 = b1 >> 1;


                if ((s3 == 1) && (x == x1) && (y == y1)) {     //check if there is a pon

                    buffer =  ((((((( (buffer<<1)+s3 << 1) + s2) << 1) + s1) << 3) + y2) << 3) + x2;
                    System.out.println("b1 checker");
                } else {
                    buffer = ((((((( (buffer<<1)+s3 << 1) + s2) << 1) + s1) << 3) + y) << 3) + x;
                }



            }
            black1=buffer;

            buffer = 0;

            b2 = black2;      //important thing to reset value
            for (int k = 0; k < 6; k++) {
                x = (int) (b2 % 8);
                b2 = b2 >> 3;
                y = (int) (b2 % 8);
                b2 = b2 >> 3;

                s1 = (int) (b2 % 2);
                b2 = b2 >> 1;
                s2 = (int) (b2 % 2);
                b2 = b2 >> 1;
                s3 = (int) (b2 % 2);
                b2 = b2 >> 1;

                if ((s3 == 1) && (x == x1) && (y == y1)) {     //check if there is a pon

                    buffer =  ((((((( (buffer<<1)+s3 << 1) + s2) << 1) + s1) << 3) + y2) << 3) + x2;
                    System.out.println("b2 checker");
                } else {
                    buffer = ((((((( (buffer<<1)+s3 << 1) + s2) << 1) + s1) << 3) + y) << 3) + x;
                }

            }black2=buffer;

            buffer = 0;

            w1 = white1;      //important thing to reset value
            for (int k = 0; k < 6; k++) {
                x = (int) (w1 % 8);
                w1 = w1 >> 3;
                y = (int) (w1 % 8);
                w1 = w1 >> 3;

                s1 = (int) (w1 % 2);
                w1 = w1 >> 1;
                s2 = (int) (w1 % 2);
                w1 = w1 >> 1;
                s3 = (int) (w1 % 2);
                w1 = w1 >> 1;

                if ((s3 == 1) && (x == x1) && (y == y1)) {     //check if there is a pon

                    buffer =  ((((((( (buffer<<1)+s3 << 1) + s2) << 1) + s1) << 3) + y2) << 3) + x2;
                    System.out.println("w1 checker");
                } else {
                    buffer = ((((((( (buffer<<1)+s3 << 1) + s2) << 1) + s1) << 3) + y) << 3) + x;
                }

            }white1=buffer;

            buffer = 0;

            w2 = white2;      //important thing to reset value
            for (int k = 0; k < 6; k++) {
                x = (int) (w2 % 8);
                w2 = w2 >> 3;
                y = (int) (w2 % 8);
                w2 = w2 >> 3;

                s1 = (int) (w2 % 2);
                w2 = w2 >> 1;
                s2 = (int) (w2 % 2);
                w2 = w2 >> 1;
                s3 = (int) (w2 % 2);
                w2 = w2 >> 1;


                if ((s3 == 1) && (x == x1) && (y == y1)) {     //check if there is a pon

                    buffer =  ((((((( (buffer<<1)+s3 << 1) + s2) << 1) + s1) << 3) + y2) << 3) + x2;
                    System.out.println("w2 checker");
                } else {
                    buffer = ((((((( (buffer<<1)+s3 << 1) + s2) << 1) + s1) << 3) + y) << 3) + x;
                }


            }white2=buffer;
            // find x1y1 and change to intsc chrac


        }
    }
}

