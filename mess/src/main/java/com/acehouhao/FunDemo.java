package com.acehouhao;

import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import fundemo.EgSum;

/**
 * Created by Hao HOU on 2018/1/21.
 */
public class FunDemo {
    public static void main(String[] args) {
        EgSum egSum = null;
        try {
            egSum = new EgSum();
            Object[] s = egSum.eg_sum(1, 20);
            MWNumericArray output = null;
            output = (MWNumericArray)s[0];
            int sum = output.getInt(1);
            System.out.println(sum);
        } catch (MWException e) {
            e.printStackTrace();
        }  finally {
            // 释放本地资源
            if (egSum != null)
                egSum.dispose();
        }
    }
}
