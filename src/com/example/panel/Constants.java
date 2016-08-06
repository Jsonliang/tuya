package com.example.panel;

import java.util.ArrayList;


import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;


public class Constants {
	public static ArrayList<String> LIST = null;
	public static ArrayList<Action> actionList = new ArrayList<Action>();
	public static ArrayList<ISketchPadTool> m_undoStack = new ArrayList<ISketchPadTool>();
	public static Bitmap bitmap ;
	public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000;

}
