package com.example.okul.handlerkullanimi;


import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends ActionBarActivity {
    TextView txt;
    Handler handle = null;
    Runnable runnable = null;
    int zaman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.textView);
        zaman = 10;
        handle = new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                txt.setText(String.valueOf(zaman));
                if (zaman != 0) {

                    zaman--;
                    
                } else {
                    handle.removeCallbacks(runnable);
                    Toast.makeText(MainActivity.this, "zaman doldu!",
                            Toast.LENGTH_SHORT).show();

                }
                handle.postDelayed(runnable, 1000);
            }
        };
        //runnable.run();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "hello world", Toast.LENGTH_SHORT).show();

            }
        }, 5000);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
