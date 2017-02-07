package test.com.clapapp;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by Ashutosh on 10/5/2016.
 */
public class Music {
    private static MediaPlayer mediaPlayer;
    private static boolean keepMusic;

    public static void playMusic(Context context) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, R.raw.song);
            mediaPlayer.setLooping(true);

            try {
                mediaPlayer.prepare();
            } catch (IllegalStateException e) {
            } catch (IOException e) {
            }
        }

        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }

        keepMusic = false;
    }

    public static void stopMusic() {

        if (!keepMusic) {
            mediaPlayer.pause();
        }
    }
}

