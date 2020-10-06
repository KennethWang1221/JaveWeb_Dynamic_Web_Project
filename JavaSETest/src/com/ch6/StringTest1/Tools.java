package com.ch6.StringTest1;

import java.util.Random;

public class Tools {
    public void c(char[] c) {
        Random random=new Random();
        for(int i=0;i<10;i++) {
            int n1=random.nextInt(4);
            int n2=random.nextInt(4);

            char temp =c[n1];
            c[n1] =c[2];
            c[2] = temp;
        }
    }
}
