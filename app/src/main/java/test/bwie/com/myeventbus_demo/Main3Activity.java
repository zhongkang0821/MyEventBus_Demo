package test.bwie.com.myeventbus_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Main3Activity extends AppCompatActivity {

    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv3= (TextView) findViewById(R.id.tv3);
        //注册
        EventBus.getDefault().register(this);

    }

    @Subscribe(sticky = true)//注解
    public void onEventMainThread(Bean event){
        String msg = "onEventMainThread收到了消息"+event.getName();
        Log.d("Main3lllllllll",msg);
        //把传过来的值设置给textview
        tv3.setText(msg);
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册
        EventBus.getDefault().unregister(this);
    }
}
