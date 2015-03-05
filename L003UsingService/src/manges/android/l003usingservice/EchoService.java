package manges.android.l003usingservice;

import java.util.Timer;
import java.util.TimerTask;

import android.R.integer;
import android.app.PendingIntent.CanceledException;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.text.format.Time;

public class EchoService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		System.out.println("onBind");
		return echoServiceBinder;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		startTime();
		System.out.println("onCreate");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		stopTime();
		System.out.println("onDestory");
	}
	
	//定义内容类继承Binder
    public class EchoServiceBinder extends Binder{
        //返回本地服务
    	EchoService getService(){
            return EchoService.this;
        }
    }
    
    private int number=0;
    
    
    public int getNumber() {
		return number;
	}
    
    private Timer timer;
    private TimerTask timerTask;

    public void startTime(){
    	if(timer==null){
    		timer=new Timer();
    		timerTask=new TimerTask() {
				@Override
				public void run() {
					number++;
					System.out.println(number);
				}
			};
			timer.schedule(timerTask, 1000,1000);//启动
    	}
    }
    
    public void stopTime(){
    	if(timer!=null){
    		timerTask.cancel();
    		timer.cancel();
    		timer=null;
    		timerTask=null;
    	}
    }
   


	private final EchoServiceBinder echoServiceBinder =new EchoServiceBinder();
    
}
