package vn.manroid.customthreadhandler;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    static Handler handler;
    AtomicBoolean atomicBoolean = null;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       handler = new Handler(){
           @Override
           public void handleMessage(Message msg) {
               super.handleMessage(msg);
               Process process = (Process) msg.obj;
               Log.d("test",process.getName());

           }
       };


        Fragment newFragment = new BlankFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contentPanel, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }



    public void onClickHandler(View view) {
//        atomicBoolean = new AtomicBoolean(false);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(100);
//                if (atomicBoolean.get()){
//                    Message message = handler.obtainMessage();
//                    message.obj = new Process("Thread test");
//                    handler.sendMessage(message);
//                }
//            }
//        });
//        atomicBoolean.set(true);
//        thread.start();

    }
}