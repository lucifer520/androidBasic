package mangues.android.l004usingboardcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBoardCastReceiver extends BroadcastReceiver {
	//自己定义的一个消息，广播可以发到这条消息上。有格式要求 包名+.intent.action+消息名称
		public static final String ACTION=
	   "mangues.android.l004usingboardcastreceiver.intent.action.MyBC";
	@Override
	public void onReceive(Context context, Intent intent) {
		  
          System.out.println("onReceiver:"+intent.getStringExtra("cast") );
	}

}
