package com.example.blade.template;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Blade on 2017/12/20.
 */

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        ActivityCollector.addActivity(this);
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

}
