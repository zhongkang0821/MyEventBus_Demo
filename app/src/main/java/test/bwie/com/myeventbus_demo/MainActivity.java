package test.bwie.com.myeventbus_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private Button tiaobtn;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        tiaobtn = (Button) findViewById(R.id.tiaobtn);
        name = (TextView) findViewById(R.id.name);
        //注册eventbus
        EventBus.getDefault().register(this);
        tiaobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(m);
            }
        });
    }

    //
    @Subscribe
    public void onEventMainThread(Bean event){
        String msg = "onEventMainThread收到了消息"+event.getName();
        Log.d("harvic",msg);
        //把传过来的值设置给textview
        name.setText(msg);
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //关闭注册
        EventBus.getDefault().unregister(this);
    }
}
