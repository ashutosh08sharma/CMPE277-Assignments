    package test.com.serviceapp;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

    /**
 * Created by Ashutosh on 10/2/2016.
 */
public class DownloadService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        String[] url = (String[]) intent.getExtras().get("urls");
        System.out.println("URL"+ url);
        new DoBackgroundTask().execute(url);
        return START_STICKY;
    }


    private class DoBackgroundTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            int count;
            try {
                for (int i = 0; i < params.length; i++) {
                    URL url = new URL(params[i]);
                    URLConnection connection = url.openConnection();
                    connection.connect();
                    int len = connection.getContentLength();
                    InputStream input = new BufferedInputStream(
                            url.openStream(), 8192);
                    System.out.println("Data::" +params[i]);
                    OutputStream output = new FileOutputStream(
                            "/sdcard/Ashutosh" + i + ".pdf");

                    byte data[] = new byte[1024];
                    long sum = 0;
                    while((count = input.read(data)) != -1) {
                        sum += count;
                        output.write(data, 0, count);
                    }

                    output.flush();

                    output.close();
                    input.close();
                }
            } catch (Exception e) {
                Log.e("ERROR: ", e.getMessage());
            }
            String result = "5";

            return result ;
        }

    }
        protected void onProgressUpdate(Integer... progress) {
            Toast.makeText(getBaseContext(),
                    " All files are downloaded",
                    Toast.LENGTH_LONG).show();
        }

        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(),
                    " All"+ result+ " files are Downloaded" ,
                    Toast.LENGTH_LONG).show();
            stopSelf();
        }

        @Override
        public void onDestroy()
        {
            super.onDestroy();
            Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
        }

}
