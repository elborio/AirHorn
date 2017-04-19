package nl.melbasolutions.airhorn;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button but1, but2, but3, but4, but5, but6;

    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        player = MediaPlayer.create(this, R.raw.sound1);

        setupButtons();

    }

    private void setupButtons() {

        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);
        but3 = (Button) findViewById(R.id.but3);
        but4 = (Button) findViewById(R.id.but4);
        but5 = (Button) findViewById(R.id.but5);
        but6 = (Button) findViewById(R.id.but6);

        but1.setOnTouchListener(new MyOnTouchListener(R.raw.sound1));
        but2.setOnTouchListener(new MyOnTouchListener(R.raw.sound2));
        but3.setOnTouchListener(new MyOnTouchListener(R.raw.sound3));
        but4.setOnTouchListener(new MyOnTouchListener(R.raw.sound4));
        but5.setOnTouchListener(new MyOnTouchListener(R.raw.sound5));
        but6.setOnTouchListener(new MyOnTouchListener(R.raw.sound6));
    }



    private void playSound(int id) {

        MediaPlayer p;
        p = MediaPlayer.create(this, id);
        p.start();
        p.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }

    private class MyOnTouchListener implements View.OnTouchListener {

        int id;

        public MyOnTouchListener(int id) {
            this.id = id;
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                playSound(this.id);
            }
            return false;
        }
    }


}
