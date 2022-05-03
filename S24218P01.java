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
                    white1 = (((((white1 << 3) + 0b100) << 3) + (8-(8 % i)) )<< 3) + ((j * 2) + 1);
                } else {
                    white2 = (((((white2 << 3) + 0b100) << 3) + (8-(8 % i))) << 3) + ((j * 2) + 1);
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
        boolean islocked=false;
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

        for (int i = 8; i > 0; i--) {
            for (int j = 1; j <= 8; j++) {
                int x = 0, y = 0, s1=0, s2=0, s3=0;

                b1 = black1;
                b2 = black2;
                w1 = white1;
                w2 = white2;
                while (b1 != 0) {

                    for (int k = 0; k < 6; k++) {
                        x = (int) (b1 % 8);
                        b1 = b1>>3;
                        y = (int) (b1 % 8);
                        b1 = b1>>3;
                        s1 = (int) (b1 % 2);
                        b1 = b1>>1;
                        s2 = (int) (b1 % 2);
                        b1 = b1>>1;
                        s3 = (int) (b1 % 2);
                        b1 = b1>>1;
                       //System.out.println("x:" + x + " y:" + y);
                        if (y == i && x == j) {
                            if (s3 == 1) {
                                if (s2 == 1) {
                                    System.out.print('\u256B');

                                } else {
                                    System.out.print('\u256F');
                                }
                                islocked=true;
                                break;
                            }

                        }
                    }
                   // System.out.println(b1);

                }

                while (b2 != 0) {

                    for (int k = 0; k < 6; k++) {
                        x = (int) (b2 % 8);
                        b2 = b2>>3;
                        y = (int) (b2 % 8);
                        b2 = b2>>3;
                        s1 = (int) (b2 % 2);
                        b2 = b2>>1;
                        s2 = (int) (b2 % 2);
                        b2 = b2>>1;
                        s3 = (int) (b2 % 2);
                        b2 = b2>>1;
                       // System.out.println("x:" + x + " y:" + y);
                        if (y == i && x == j) {
                            if (s3 == 1) {
                                if (s2 == 1) {
                                    System.out.print('\u256B');

                                } else {
                                    System.out.print('\u256F');
                                }
                                islocked=true;
                                break;
                            }
                        }

                    }
                    //System.out.println(b2);

                }

                while (w1 != 0) {

                    for (int k = 0; k < 6; k++) {
                        x = (int) (w1 % 8);
                        w1 = w1>>3;
                        y = (int) (w1 % 8);
                        w1 = w1>>3;
                        s1 = (int) (w1 % 2);
                        w1 = w1>>1;
                        s2 = (int) (w1 % 2);
                        w1 = w1>>1;
                        s3 = (int) (w1 % 2);
                        w1 = w1>>1;
                       // System.out.println("x:" + x + " y:" + y);
                        if (y == i && x == j) {
                            if (s3 == 1) {
                                if (s2 == 1) {
                                    System.out.print('\u2655');

                                } else {
                                    System.out.print('\u2659');
                                }
                                islocked=true;
                                break;
                            }
                        }
                    }
                   // System.out.println(w1);
                    if (y == i && x == j) {
                        if (s3 == 1) {
                            if (s2 == 1) {
                                System.out.print('\u2655');


                            } else {
                                System.out.print('\u2659');
                            }
                            islocked=true;
                            break;
                        }

                    }

                }

                while (w2 != 0) {

                    for (int k = 0; k < 6; k++) {
                        x = (int) (w2 % 8);
                        w2 = w2>>3;
                        y = (int) (w2 % 8);
                        w2 = w2>>3;
                        s1 = (int) (w2 % 2);
                        w2 = w2>>1;
                        s2 = (int) (w2 % 2);
                        w2 = w2>>1;
                        s3 = (int) (w2 % 2);
                        w2 = w2>>1;
                       // System.out.println("x:" + x + " y:" + y);
                        if (y == i && x == j) {
                            if (s3 == 1) {
                                if (s2 == 1) {
                                    System.out.print('\u2655');


                                } else {
                                    System.out.print('\u2659');
                                }
                                islocked=true;
                                break;
                            }
                        }
                    }
                    //System.out.println(w2);


                }
                if (!islocked){
                    System.out.print((i + j )% 2 == 1 ? '\u2B1B' : '\u2B1C');
                }

            }
            System.out.println();
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

