package com.example.panel;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * @author hefeng
 * @version 创建时间：2013-10-28 上午11:09:55
 * 类说明
 */

public class GetScreenDm {
	
	private static DisplayMetrics dm;

    public static int getDisplayMetricsW(Context cx) {
        String str = "";
        DisplayMetrics dm = new DisplayMetrics();
        dm = cx.getApplicationContext().getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        float density = dm.density;
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;
//        str += "The absolute width:" + String.valueOf(screenWidth) + "pixels\n";
//        str += "The absolute heightin:" + String.valueOf(screenHeight)
//                        + "pixels\n";
//        str += "The logical density of the display.:" + String.valueOf(density)
//                        + "\n";
//        str += "X dimension :" + String.valueOf(xdpi) + "pixels per inch\n";
//        str += "Y dimension :" + String.valueOf(ydpi) + "pixels per inch\n";
//        System.out.println(str);
        return screenWidth;
}
    public static int getDisplayMetricsH(Context cx) {
        String str = "";
        DisplayMetrics dm = new DisplayMetrics();
        dm = cx.getApplicationContext().getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        float density = dm.density;
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;
//        str += "The absolute width:" + String.valueOf(screenWidth) + "pixels\n";
//        str += "The absolute heightin:" + String.valueOf(screenHeight)
//                        + "pixels\n";
//        str += "The logical density of the display.:" + String.valueOf(density)
//                        + "\n";
//        str += "X dimension :" + String.valueOf(xdpi) + "pixels per inch\n";
//        str += "Y dimension :" + String.valueOf(ydpi) + "pixels per inch\n";
//        System.out.println(str);
        return screenHeight;
}
}
