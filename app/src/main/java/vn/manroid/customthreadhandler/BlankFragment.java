package vn.manroid.customthreadhandler;


import android.app.Fragment;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicBoolean;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private AtomicBoolean atomicBoolean;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        Button button = view.findViewById(R.id.btn_test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atomicBoolean = new AtomicBoolean(false);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(100);
                        if (atomicBoolean.get()){
                            Message message = MainActivity.handler.obtainMessage();
                            message.obj = new Process("Thread test  33");
                            MainActivity.handler.sendMessage(message);
                        }
                    }
                });
                atomicBoolean.set(true);
                thread.start();
            }
        });

        return view;
    }

}
