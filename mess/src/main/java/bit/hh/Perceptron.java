package bit.hh;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hao HOU on 2018/3/22.
 */
public class Perceptron {
    public static void main(String[] args) {
        Sample s1 = new Sample(3, 3, 1);
        Sample s2 = new Sample(4, 3, 1);
        Sample s3 = new Sample(1, 1, -1);

        List<Sample> samples = new ArrayList<>();
        samples.add(s1);
        samples.add(s2);
        samples.add(s3);

        double w1 = 0;
        double w2 = 0;
        double b = 0;
        double step = 0.5;

        boolean flag = false;
        while (!flag) {
            for (Sample sample : samples) {
                if (sample.getY() * (w1 * sample.getX1() + w2 * sample.getX2() + b) <= 0) {
                    w1 = w1 + step * sample.getY() * sample.getX1();
                    w2 = w2 + step * sample.getY() * sample.getX2();
                    b = b + step * sample.getY();

                    System.out.println("w1 = " + w1 + ", w2 = " + w2 + ", b = " + b);

                    flag = true;
                    break;
                }
            }
            if (flag) {
                flag = false;
            } else {
                flag = true;
            }
        }

    }
}
