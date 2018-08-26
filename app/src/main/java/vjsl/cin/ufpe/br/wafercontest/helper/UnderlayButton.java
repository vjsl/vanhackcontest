package vjsl.cin.ufpe.br.wafercontest.helper;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import vjsl.cin.ufpe.br.wafercontest.helper.SwipeHelper;

public class UnderlayButton {
    private String text;
    private int imageResId;
    private int color;
    private int pos;
    private RectF clickRegion;
    private SwipeHelper.UnderlayButtonClickListener clickListener;
    private Bitmap drawable;

    public UnderlayButton(Bitmap drawable, String text, int imageResId, int color, SwipeHelper.UnderlayButtonClickListener clickListener) {
        this.drawable = drawable;
        this.text = text;
        this.imageResId = imageResId;
        this.color = color;
        this.clickListener = clickListener;
    }

    public boolean onClick(float x, float y){
        if (clickRegion != null && clickRegion.contains(x, y)){
            clickListener.onClick(pos);
            return true;
        }

        return false;
    }

    public void onDraw(Canvas c, RectF rect, int pos){
        Paint p = new Paint();

        // Draw background

        p.setColor(color);

        c.drawRect(rect, p);





        // Draw Text
        p.setColor(Color.WHITE);
        p.setTextSize(40);
        //p.setTextSize(LayoutHelper.getPx(MyApplication.getAppContext(), 12));

        Rect r = new Rect();
        float cHeight = rect.height();
        float cWidth = rect.width();
        p.setTextAlign(Paint.Align.LEFT);
        //p.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        //c.drawText(text, rect.left + x, rect.top + y, p);
        c.drawBitmap(drawable, null, rect, p);


        clickRegion = rect;
        this.pos = pos;
    }
}