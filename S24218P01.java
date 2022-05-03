public
class S24218P01 {
    public static void main(String[] args) {
        long black1 = 0,
                black2 = 0,
                white1 = 0,
                white2 = 0;
        int counter = 0, co = 0;

        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (counter < 6) {
                    black1 = (((((black1 << 3) + 0b100) << 3) + i) << 3) + ((j * 2) + 1);
                } else {
                    black2 = (((((black2 << 3) + 0b100) << 3) + i) << 3) + ((j * 2) + 1);
                }
                counter++;
                co++;
                System.out.println(Long.toBinaryString(black1) + "\n" + Long.toBinaryString(black2) + "\n" + co);

            }
        }
        counter = 0;
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (counter < 6) {
                    white1 = (((((white1 << 3) + 0b100) << 3) + 8 % i) << 3) + ((j * 2) + 1);
                } else {
                    white2 = (((((white2 << 3) + 0b100) << 3) + 8 % i) << 3) + ((j * 2) + 1);
                }
                counter++;
                co++;
                System.out.println(Long.toBinaryString(white1) + "\n" + Long.toBinaryString(white2) + "\n" + co);

            }
        }
        System.out.println(Long.toBinaryString(black1) + "\n" + Long.toBinaryString(black2) + "\n" + co);
        System.out.println(Long.toBinaryString(white1) + "\n" + Long.toBinaryString(white2) + "\n" + co);


        System.out.println(Integer.toBinaryString((0b100 << 3) + 1));
        long b1 = black1, b2 = black2, w1 = white1, w2 = white2;
        /*
        String board = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board += (i + j) % 2 == 0 ? '\u2B1B' + " " : '\u2B1C' + " ";
            }
            board += "\n";
        }
        System.out.println(board);
        */
        int x = 0, y = 0, s1, s2, s3;

        b1 = black1;
        b2 = black2;
        w1 = white1;
        w2 = white2;
        while (b1 != 0) {

            for (int i = 0; i < 6; i++) {
                x = (int) (b1 % 8);
                b1 = (long) (b1/8);
                y = (int) (b1 % 8);
               b1 = (long) (b1/8);
                s1 = (int) (b1 % 2);
                b1 = (long) (b1/2);
                s2 = (int) (b1 % 2);
                b1 = (long) (b1/2);
                s3 = (int) (b1 % 2);
                b1 = (long) (b1/2);
                System.out.println("x:"+x+" y:"+y);

            } System.out.println(b1);
        }
/*
            for (int i = 8; i > 0; i--) {
                for (int j = 1; j <= 8; j++) {
                    if (y == i && x == j) {
                        if (s3 == 1) {
                            if (s2 == 1) {
                                System.out.println('\u256B');

                            } else {
                                System.out.println('\u256F');
                            }

                        }
                    } else {
                        System.out.print((i + j )% 2 == 1 ? '\u2B1B' : '\u2B1C');

                    }
                }
                System.out.print('\n');
            }
*/


    }


}

