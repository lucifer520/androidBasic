package manges.android.l003usingservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener, ServiceConnection {

	private Button btnStartService, btnStopService,btnBindService,btnUnBindService,btnGetCurrentNum;
	private Intent serviceIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();

	}
	
	public void init(){
		btnStartService = (Button) findViewById(R.id.btnStartService);
		btnStopService = (Button) findViewById(R.id.btnStopService);
		btnBindService = (Button) findViewById(R.id.btnBindService);
		btnUnBindService = (Button) findViewById(R.id.btnUnBindService);
		btnGetCurrentNum = (Button) findViewById(R.id.btnGetCurrentNum);
		btnStartService.setOnClickListener(this);
		btnStopService.setOnClickListener(this);
		btnBindService.setOnClickListener(this);
		btnUnBindService.setOnClickListener(this);
		btnGetCurrentNum.setOnClickListener(this);
		serviceIntent=new Intent(this,EchoService.class);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btnStartService:
				startService(serviceIntent); //开启服务
				break;
			case R.id.btnStopService:
				stopService(serviceIntent);//停止服务
				break;
			case R.id.btnBindService:
				bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
				break;
			case R.id.btnUnBindService:
				unbindService(this);
				break;	
			case R.id.btnGetCurrentNum:
				if(echoService!=null)
				System.out.println("当前值："+echoService.getNumber());
				break;	
			default:
		}

	}
	private EchoService echoService=null;
	@Override
	public void onServiceConnected(ComponentName componentName, IBinder binder) {//binder即返回的echoService
		System.out.println("OnServiceBindConnected");
		//Service服务系统来创建，自己不可以new来创建
		echoService=((EchoService.EchoServiceBinder)binder).getService();
		
	}

	@Override
	public void onServiceDisconnected(ComponentName arg0) {
		echoService=null;
		System.out.println("OnServiceUnBindDisConnected");
		
	}

}
