package com.acehouhao;

import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;
import matlabcontrol.extensions.MatlabNumericArray;
import matlabcontrol.extensions.MatlabTypeConverter;

/**
 * Created by Hao HOU on 2018/1/21.
 */
public class MatlabControlDemo {
    public static void main(String[] args) throws MatlabInvocationException, MatlabConnectionException {
        MatlabProxyFactory factory = new MatlabProxyFactory();
        MatlabProxy proxy = factory.getProxy();
//        proxy.eval("disp('hello world')");
//        proxy.disconnect();
        // 创建一个 4x3x2 的三维随机数组
        proxy.eval("array = randn(4,3,2)");

// 在Matlab的命令窗口中输出打印
        proxy.eval("disp(['entry: ' num2str(array(3, 2, 1))])");

// 从Matlab中取得array的值
        MatlabTypeConverter processor = new MatlabTypeConverter(proxy);
        MatlabNumericArray array = processor.getNumericArray("array");

// 在JAVA中打印值
        System.out.println("entry: " + array.getRealValue(2, 1, 0));

// 将matlab中的这个三维数组（array）转换成java中的三维数组样式
        double[][][] javaArray = array.getRealArray3D();
        System.out.println("entry: " + javaArray[2][1][0]);

// 断开与matlab的连接
        proxy.disconnect();
    }
}
