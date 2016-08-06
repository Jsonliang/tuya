package com.example.panel;

import android.view.MotionEvent;


public interface ISketchPadCallback
{
    public void onTouchDown(SketchPadView obj, MotionEvent event);
    public void onTouchUp(SketchPadView obj, MotionEvent event);
    public void onDestroy(SketchPadView obj);
}
