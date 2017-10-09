package com.leo.asynctasktutorial;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] integers;
    int clicks = 0;
    private ProgressBar mIdicatorBar;
    private TextView mStatusView;
    private TextView mClicksView;
    private Button mProgressBtn;
    private Button mClicksBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIdicatorBar = (ProgressBar) findViewById(R.id.indicator);
        mStatusView = (TextView) findViewById(R.id.statusView);
        mClicksView = (TextView) findViewById(R.id.clicksView);
        mClicksBtn = (Button) findViewById(R.id.clicksBtn);
        mProgressBtn = (Button) findViewById(R.id.progressBtn);

        integers = new int[100];
        for (int i = 0; i < 100; i++){
            integers[i] = i + 1;
        }

        mProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ProgressTask().execute();
            }
        });

        mClicksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicks++;
                mClicksView.setText("Clicks: " + clicks);
            }
        });

    }

    public class ProgressTask extends AsyncTask<Void, Integer, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < integers.length; i++){
                publishProgress(i);
                SystemClock.sleep(500);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mIdicatorBar.setProgress(values[0] + 1);
            mStatusView.setText("Статус" + String.valueOf(values[0] + 1));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(MainActivity.this, "Задача завершена", Toast.LENGTH_SHORT).show();
        }
    }
}
