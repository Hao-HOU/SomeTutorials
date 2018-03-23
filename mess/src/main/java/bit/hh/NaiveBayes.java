package bit.hh;

import java.util.*;

/**
 * Created by Hao HOU on 2018/3/22.
 */
public class NaiveBayes {
    public static void main(String[] args) {
        List<NBSample> nbSamples = new ArrayList<>();
        nbSamples.add(new NBSample(1, "S", -1));
        nbSamples.add(new NBSample(1, "M", -1));
        nbSamples.add(new NBSample(1, "M", 1));
        nbSamples.add(new NBSample(1, "S", 1));
        nbSamples.add(new NBSample(1, "S", -1));
        nbSamples.add(new NBSample(2, "S", -1));
        nbSamples.add(new NBSample(2, "M", -1));
        nbSamples.add(new NBSample(2, "M", 1));
        nbSamples.add(new NBSample(2, "L", 1));
        nbSamples.add(new NBSample(2, "L", 1));
        nbSamples.add(new NBSample(3, "L", 1));
        nbSamples.add(new NBSample(3, "M", 1));
        nbSamples.add(new NBSample(3, "M", 1));
        nbSamples.add(new NBSample(3, "L", 1));
        nbSamples.add(new NBSample(3, "L", -1));

        int n = nbSamples.size();
        Set<Integer> a1 = new HashSet<>();
        Set<String> a2 = new HashSet<>();
        Set<Integer> c = new HashSet<>();

        for (NBSample nbSample : nbSamples) {
            a1.add(nbSample.getX1());
            a2.add(nbSample.getX2());
            c.add(nbSample.getY());
        }

        int[] cs = new int[c.size()];
        Iterator<Integer> iterator = c.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            cs[i++] = iterator.next();
        }

        int[] a1s = new int[a1.size()];
        Iterator<Integer> iterator1 = a1.iterator();
        i = 0;
        while (iterator1.hasNext()) {
            a1s[i++] = iterator1.next();
        }

        String[] a2s = new String[a2.size()];
        Iterator<String> iterator2 = a2.iterator();
        i = 0;
        while (iterator2.hasNext()) {
            a2s[i++] = iterator2.next();
        }

        int[][] a1scount = new int[cs.length][a1s.length];
        int[][] a2scount = new int[cs.length][a2s.length];
        int[] cscount = new int[cs.length];

        for (int j = 0; j < cs.length; j++ ) {
            for (NBSample sample : nbSamples) {
                if (sample.getY() == cs[j]) {
                    cscount[j]++;
                }
            }
        }
        for (int j = 0; j < cs.length; j++) {
            for (int k = 0; k <a1s.length; k++) {
                for (NBSample sample : nbSamples) {
                    if (sample.getY() == cs[j]) {
                        if (sample.getX1() == a1s[k]) {
                            a1scount[j][k]++;
                        }
                    }
                }
            }
        }
        for (int j = 0; j < cs.length; j++) {
            for (int k = 0; k <a2s.length; k++) {
                for (NBSample sample : nbSamples) {
                    if (sample.getY() == cs[j]) {
                        if (sample.getX2().equals(a2s[k])) {
                            a2scount[j][k]++;
                        }
                    }
                }
            }
        }

        double[] csp = new double[cs.length];
        for (int j = 0; j < cs.length; j++ ) {
            csp[j] = cscount[j] / (double)n;
            System.out.println(csp[j]);
        }


        int prex1 = 2;
        String prex2 = "S";

        double[] pres = new double[c.size()];
        for (int j = 0; j < pres.length; j++) {

            pres[j] = csp[j] * (a1scount[j][getXstIndex(prex1, a1s)] / (double)cscount[j])
                    * (a2scount[j][getXsecIndex(prex2, a2s)] / (double)cscount[j]);

            System.out.println(cs[j] + "的概率：" + pres[j]);
        }



    }

    private static int getXstIndex(int input, int[] a1s) {
        for (int i = 0; i < a1s.length; i++) {
            if (input == a1s[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int getXsecIndex(String input, String[] a2s) {
        for (int i = 0; i < a2s.length; i++) {
            if (input.equals(a2s[i])) {
                return i;
            }
        }

        return -1;
    }
}
