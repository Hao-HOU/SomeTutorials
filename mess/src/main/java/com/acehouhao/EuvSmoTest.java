package com.acehouhao;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;
import euvsmo.EuvSmo;

/**
 * Created by Hao HOU on 2018/3/1.
 */
public class EuvSmoTest {
    public static void main(String[] args) throws MWException {
        EuvSmo euvSmo = new EuvSmo();

        euvSmo.EUV_Pixelated_SMO_MAIN(4, 8, 201, 11,
                0.8, 0.07, 1.424, 1.835, 13.5, 0.24, 0.84, 0.169, 0.25, 4, 0.03, 0.001,
                0.1, 0.1, 0.0005, 1, 100, 0.25, 25);
    }
}
