package test.bwie.com.myeventbus_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

public class Main2Activity extends AppCompatActivity {

    private Button btn_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_first = (Button) findViewById(R.id.btn_first);
        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //eventbus通过post把值传到第三个activity
                EventBus.getDefault().postSticky(new Bean("sldfjlsj"));
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
                //把值传到第一个activity
                EventBus.getDefault().post(new Bean("lksfkjdfjfkjfadsdfkdasfo"));
            }
        });

    }
}
