package ambiente.disenio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton play;
    private ImageButton pause;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    private final int PLAY = 0;
    private final int PAUSE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spotify);

        //play = (ImageButton)findViewById(R.id.play);
        pause =  (ImageButton)findViewById(R.id.pause);

        play = (ImageButton)findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //RECURSO
                String url = "http://inkedhosting.net/djlibrary/Inked%20Radio%20Auto%20DJ_/Inked%20Auto%20DJ%202014%20Rock/Arctic%20Monkeys%20-%20Do%20I%20Wanna%20Know.mp3";

                //DEFINIMOS EL CANAL PARA EL STREMEN DE DATOS
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                try {
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepare();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG);
                }
                mediaPlayer.start();
            }
        });
    }
    //Acceder al relative
}
