package com.example.panel;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;



public class ReceiveActivity extends MyBaseActivity implements OnClickListener,
ISketchPadCallback {

	private Button cleanBtn;
	private Button sendBtn;
	private Button orangeBtn;
	private Button purpleBtn;
	private Button blueBtn;
	private Button blackBtn;
	private Button whiteBtn;
	private Button delAllBtn;
	private FrameLayout line;
	private Bitmap testBitmap;
	 private SketchPadView m_sketchPad = null;
	private RelativeLayout mainlayout;
	private Button colorBtn;
	private Button saveBtn;
	private Button changeBtn;
	/**
	 * 最初颜色 zqy
	 */
	public static int color = Color.BLUE;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.getWindow().setFlags(Constants.FLAG_HOMEKEY_DISPATCHED,
				Constants.FLAG_HOMEKEY_DISPATCHED);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.receive);
		findView();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}


	/**
	 * 找到控件
	 * 
	 * @author hefeng
	 * @version 创建时间：2013-10-11 上午10:59:59
	 */
	private void findView() {
		mainlayout = (RelativeLayout) findViewById(R.id.mainlayout);
		colorBtn = (Button) findViewById(R.id.colorBtn);
		cleanBtn = (Button) findViewById(R.id.cleanBtn);
		orangeBtn = (Button) findViewById(R.id.orageBtn);
		purpleBtn = (Button) findViewById(R.id.purpleBtn);
		blueBtn = (Button) findViewById(R.id.blueBtn);
		blackBtn = (Button) findViewById(R.id.blackBtn);
		whiteBtn = (Button) findViewById(R.id.whiteBtn);
		saveBtn = (Button) findViewById(R.id.saveBtn);
		changeBtn = (Button) findViewById(R.id.changeBtn);
		colorBtn.setOnClickListener(this);
		changeBtn.setOnClickListener(this);
		saveBtn.setOnClickListener(this);
		orangeBtn.setOnClickListener(this);
		purpleBtn.setOnClickListener(this);
		blueBtn.setOnClickListener(this);
		blackBtn.setOnClickListener(this);
		whiteBtn.setOnClickListener(this);
		cleanBtn.setOnClickListener(this);
		delAllBtn =(Button) findViewById(R.id.cleanAllBtn);
		delAllBtn.setOnClickListener(this);
		line = (FrameLayout) findViewById(R.id.line);
		m_sketchPad = (SketchPadView) findViewById(R.id.sketchpad);
		m_sketchPad.setCallback(ReceiveActivity.this);
		Bitmap bitmap = null;
		try {
			bitmap = BitmapFactory.decodeStream(getAssets().open(
					"paper.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initPaint(bitmap);
	}

	@Override
	public void onClick(View v) {
		ColorPickerDialog colorDialog;
		switch (v.getId()) {
		// 橙色
		case R.id.orageBtn:
//			view.isDel = false;
//			view.setColor(Color.parseColor("#ff7400"));
			 m_sketchPad.setStrokeType(SketchPadView.STROKE_PEN);
	        m_sketchPad.setStrokeColor(Color.parseColor("#ff7400"));
			break;
		// 紫色
		case R.id.purpleBtn:
//			view.isDel = false;
//			view.setColor(Color.parseColor("#cd0074"));
			 m_sketchPad.setStrokeType(SketchPadView.STROKE_PEN);
			 m_sketchPad.setStrokeColor(Color.parseColor("#cd0074"));
			break;
		// 蓝色
		case R.id.blueBtn:
//			view.isDel = false;
//			view.setColor(Color.parseColor("#4671d5"));
			 m_sketchPad.setStrokeType(SketchPadView.STROKE_PEN);
			 m_sketchPad.setStrokeColor(Color.parseColor("#4671d5"));
			break;
		// 黑色
		case R.id.blackBtn:
//			view.isDel = false;
//			view.setColor(Color.parseColor("#000000"));
			 m_sketchPad.setStrokeType(SketchPadView.STROKE_PEN);
			m_sketchPad.setStrokeColor(Color.parseColor("#000000"));
			break;
		// 白色
		case R.id.whiteBtn:
//			view.isDel = false;
//			view.setColor(Color.parseColor("#ffffff"));
			 m_sketchPad.setStrokeType(SketchPadView.STROKE_PEN);
			m_sketchPad.setStrokeColor(Color.parseColor("#ffffff"));
			break;
		// 打开色板 选择颜色
		case R.id.colorBtn:
			colorDialog = new ColorPickerDialog(ReceiveActivity.this,
					R.style.dialog, color,
					new ColorPickerDialog.OnColorChangedListener() {
						@Override
						public void colorChanged(int color) {
							m_sketchPad.setStrokeColor(color);
						}
					});
			colorDialog.setCanceledOnTouchOutside(true);// 设置点击Dialog外部任意区域关闭Dialo
			colorDialog.show();

			break;
		// 橡皮擦(擦出)
		case R.id.cleanBtn:
			//
//			view.isDel = true;
			m_sketchPad.setStrokeType(SketchPadView.STROKE_ERASER);
			// 全擦出
			// view.clean();

			break;
		case R.id.saveBtn:
			m_sketchPad.setEnabled(false);
			Bitmap bmBitmap = m_sketchPad.getCanvasSnapshot();
			BitmapUtil.saveBitmapToSdCard(bmBitmap, "/mnt/sdcard/aa.jpg");
			m_sketchPad.cleanDrawingCache();
			showToast("已保存，/mnt/sdcard/aa.jpg");
			break;
			
		case R.id.cleanAllBtn:
//			 view.clean();
		    m_sketchPad.clearAllStrokes();
			break;
		case R.id.changeBtn:
			  Bitmap bitmap = null;
				try {
					bitmap = BitmapFactory.decodeStream(getAssets().open("Tulips.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			Constants.bitmap = bitmap;
			m_sketchPad.setBkBitmap(Constants.bitmap);
			break;
		}
	}


	/**
	 * 初始化画笔
	 * 
	 * @author hh
	 * 
	 */
	public void initPaint(Bitmap bitmap) {
			m_sketchPad = new SketchPadView(ReceiveActivity.this, null);
			m_sketchPad.setCallback(ReceiveActivity.this);
			line.removeAllViews();
			line.addView(m_sketchPad);
			m_sketchPad.setBkBitmap(bitmap);
	}


	/**
	 * toast
	 * 
	 * @author hefeng
	 * @version 创建时间：2013-10-17 下午3:01:31
	 * @param str
	 */
	public void showToast(String str) {
		Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
		BitmapUtil.setFree();
	}




	@Override
	protected void initViews() {

	}

	@Override
	protected void initEvents() {

	}


    public String getStrokeFilePath()
    {
        File sdcarddir = android.os.Environment.getExternalStorageDirectory();
        String strDir = sdcarddir.getPath() + "/DCIM/sketchpad/";
        String strFileName = getStrokeFileName();
        File file = new File(strDir);
        if (!file.exists())
        {
            file.mkdirs();
        }
        
        String strFilePath = strDir + strFileName;
        
        return strFilePath;
    }
    public String getStrokeFileName()
    {
        String strFileName = "";
        
        Calendar rightNow = Calendar.getInstance();
        int year = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONDAY);
        int date = rightNow.get(Calendar.DATE);
        int hour = rightNow.get(Calendar.HOUR);
        int minute = rightNow.get(Calendar.MINUTE);
        int second = rightNow.get(Calendar.SECOND);
        
        strFileName = String.format("%02d%02d%02d%02d%02d%02d.png", year, month, date, hour, minute, second);
        return strFileName;
    }
@Override
public void onTouchDown(SketchPadView obj, MotionEvent event) {
	// TODO Auto-generated method stub
	
}

@Override
public void onTouchUp(SketchPadView obj, MotionEvent event) {
	// TODO Auto-generated method stub
	
}

@Override
public void onDestroy(SketchPadView obj) {
	// TODO Auto-generated method stub
	
}
}
