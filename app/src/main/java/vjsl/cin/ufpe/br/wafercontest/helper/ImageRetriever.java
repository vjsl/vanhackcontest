package vjsl.cin.ufpe.br.wafercontest.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;


public class ImageRetriever extends AsyncTask<String, Void, Drawable> {

    private ImageView imageView;
    private String link;

    public ImageRetriever(String link) {
        this.link = link;
        System.out.println(link);
    }

    protected Drawable doInBackground(String... urls) {
        //String urldisplay = urls[0];
        Drawable mIcon11 = null;
        try {
            InputStream in = new java.net.URL(link).openStream();
            mIcon11 = Drawable.createFromStream(in, "flag");
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }
}