package com.TestingCode;
class testing {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    static int fibonacci(int upTo) {
        if (upTo < 2){
            System.out.println(0);
            return 0;
    }
        else {
            System.out.println(upTo);
            return ((upTo - 1) + (upTo - 2));

        }
    }
}