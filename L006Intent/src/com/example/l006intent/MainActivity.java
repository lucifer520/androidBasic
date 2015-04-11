package com.example.l006intent;

import java.io.File;

import org.apache.http.client.entity.UrlEncodedFormEntity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btnButton;
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnButton = (Button) findViewById(R.id.btn);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btnButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent();
				//intent.setComponent(new ComponentName("com.example.l006intent","com.example.l006intent.OxActivity"));
				//需要配置AndroidMainifext.xml文件
				Intent intent = new Intent("com.example.l006intent.intent.action.MY_ACTIVITY");
				startActivity(intent);
			}
		});
		
		
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				File file = new File(Constants.BMOB_PICTURE_PATH);
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setDataAndType(Uri.fromFile(file), "image/*");
				startActivity(intent);
			}
		});
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				File file = new File(Constants.BMOB_PICTURE_PATH);
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setDataAndType(Uri.fromFile(file), "image/*");
				startActivity(intent);
			}
		});
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("tel:10086"));
				startActivity(intent);
			}
		});
		btn4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Intent intent = new Intent(Intent.ACTION_VIEW);
				//intent.setData(Uri.parse("http://www.baidu.com"));
				//startActivity(intent);
				//或者
				Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
				startActivity(intent);
			}
		});
	}

}
