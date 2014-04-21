package com.kzl.lib.http.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.kzl.lib.http.sample.http.impl.LoginGetTask;
import com.kzl.lib.http.sample.http.impl.LoginPostTask;
import com.kzl.lib.http.sample.http.impl.SyncRequestTask;
import com.kzl.lib.utils.MD5Util;
import com.kzl.lib.utils.ThreadPoolUtil;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoginGetTask(MyActivity.this).send("may123", MD5Util.getMD5Str("may123"));
                new LoginPostTask(MyActivity.this).send("may123", MD5Util.getMD5Str("may123"));
                ThreadPoolUtil.getThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
                        SyncRequestTask.loginGetTask("may123", MD5Util.getMD5Str("may123"));
                        SyncRequestTask.loginPostTask("may123", MD5Util.getMD5Str("may123"));
                    }
                });
            }
        });
    }
}
