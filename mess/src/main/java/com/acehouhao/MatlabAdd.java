package com.acehouhao;

import add.Matlab2Java;
import com.mathworks.toolbox.javabuilder.MWException;

/**
 * Created by Hao HOU on 2018/3/1.
 */
public class MatlabAdd {
    public static void main(String[] args) throws MWException {
        Matlab2Java matlab2Java = new Matlab2Java();

        Object[] outputs = matlab2Java.add(1, 2, 3);

        System.out.println(outputs[0]);


    }
}
