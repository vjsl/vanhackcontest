package vjsl.cin.ufpe.br.wafercontest.helper;

import android.support.v7.widget.RecyclerView;

public interface RecyclerItemTouchHelperListener {
    void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int adapterPosition);
}
