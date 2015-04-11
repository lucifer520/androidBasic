package mangues.android.l004usingboardcastreceiver;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnSendBoardCast, btnRegBC, btnUnRegBC;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnSendBoardCast = (Button) findViewById(R.id.btnSendBroadCast);
		btnRegBC = (Button) findViewById(R.id.btnSendBroadCast);
		btnUnRegBC = (Button) findViewById(R.id.btnSendBroadCast);
		btnSendBoardCast.setOnClickListener(this);
		btnRegBC.setOnClickListener(this);
		btnUnRegBC.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSendBroadCast:
			// 静态xml注册方式，常驻内存，不会随app生命周期结束而结束
			//Intent intent=new
			//Intent(MainActivity.this,MyBoardCastReceiver.class);
			/**
			 * <receiver android:name=".MyReceiver"> 
			 * <intent-filter> 
			 * <action android:name="android.intent.action.MY_BROADCAST"/> 
			 * <category android:name="android.intent.category.DEFAULT" />
			 * </intent-filter> 
			 * </receiver> 
			 * 配置了以上信息之后，只要是
			 * android.intent.action.MY_BROADCAST 这个地址的广播，MyReceiver都能够接收的到。
			 * 注意，这种方式的注册是常驻型的， 也就是说当应用关闭后，如果有广播信息传来， MyReceiver也会被系统调用而自动运行。
			 */
			// 动态注册方式
			// 这种注册方式与静态注册相反，不是常驻型的，也就是说广播会跟随程序的生命周期。
			Intent intent = new Intent(MyBoardCastReceiver.ACTION);
			intent.putExtra("cast", "MainActivity");
			sendBroadcast(intent);
			break;
		case R.id.btnRegBC:
			regBoardCast();
			break;
		case R.id.btnUnRegBC:
			unRegBoardCast();
			break;
		default:
			break;
		}

	}

	private final MyBoardCastReceiver myBCR = new MyBoardCastReceiver();

	/*
	 * @author Mangues
	 */
	public void regBoardCast() {
		IntentFilter filter = new IntentFilter();
		filter.addAction(MyBoardCastReceiver.ACTION);
		registerReceiver(myBCR, filter);
	}

	/*
	 * @author Mangues
	 */
	public void unRegBoardCast() {
		unregisterReceiver(myBCR);
	}
}
