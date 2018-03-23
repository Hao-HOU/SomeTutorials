package com.acehouhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Hao HOU on 2017/9/28.
 */
public class Obtuse {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Double[] points = new Double[n];
        for (int i = 0; i < n; i++) {
            points[i] = Double.parseDouble(bufferedReader.readLine());
        }

        System.out.println(n);


        bufferedReader.close();
    }
}
