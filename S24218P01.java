public
class S24218P01 {
    public static void main(String[] args) {
        long black1 = 0,
                black2 = 0,
                white1 = 0,
                white2 = 0;
        int counter = 0, co = 0;

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 5; j++) {
                if (counter < 6) {
                    black1 = (((((black1 << 3) + 0b100) << 3) + i - 1) << 3) + (((2 * j) - (i % 2)) - 1);
                } else {
                    black2 = (((((black2 << 3) + 0b100) << 3) + i - 1) << 3) + (((2 * j) - (i % 2)) - 1);
                }
                counter++;
                co++;
                System.out.println(Long.toBinaryString(black1) + "\n" + Long.toBinaryString(black2) + "\n" + co);
                System.out.println();

            }
        }
        long b1 = black1, b2 = black2;
        int x = 0, y = 0;
        for (int i = 0; i < 6; i++) {
            x = (int) (b1 % 8) + 1;
            b1 = b1 >> 3;
            y = (int) (b1 % 8) + 1;
            b1 = b1 >> 3;
            b1 = b1 >> 3;
            System.out.println("x:" + x + " y:" + y);
        }
        for (int i = 0; i < 6; i++) {
            x = (int) (b2 % 8) + 1;
            b2 = b2 >> 3;
            y = (int) (b2 % 8) + 1;
            b2 = b2 >> 3;
            b2 = b2 >> 3;
            System.out.println("x:" + x + " y:" + y);
        }
        boolean turn = false;

        for (int i = 7; i > -1; i--) {
            for (int j = 0; j < 8; j++) {



                        b1 = black1;      //important thing to reset value
                        for (int k = 0; k < 6; k++) {
                            x = (int) (b1 % 8) + 1;
                            b1 = b1 >> 3;
                            y = (int) (b1 % 8) + 1;
                            b1 = b1 >> 3;
                            b1 = b1 >> 3;

                            if ((x == j+1) && (y == i+1)) {     //check if there is a pon
                                System.out.print('\u2659'+ " ");
                                turn = true;
                            }
                        }



                        b2 = black2;      //important thing to reset value
                        for (int k = 0; k < 6; k++) {
                            x = (int) (b2 % 8) + 1;
                            b2 = b2 >> 3;
                            y = (int) (b2 % 8) + 1;
                            b2 = b2 >> 3;
                            b2 = b2 >> 3;

                            if ((x == j+1) && (y == i+1)) {     //check if there is a pon
                                System.out.print('\u2659'+ " ");
                                turn = true;
                            }
                        }




                        if (!turn) System.out.print((i + j) % 2 == 0 ? '\u2B1C' + " " : '\u2B1B' + " ");
                        turn=false;

            }
            System.out.println();
        }

    }
}

