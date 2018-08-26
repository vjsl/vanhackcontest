package vjsl.cin.ufpe.br.wafercontest.helper;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.Timer;

import vjsl.cin.ufpe.br.wafercontest.adapter.CountryListAdapter;
import vjsl.cin.ufpe.br.wafercontest.adapter.CountryViewHolder;

public class RecyclerCountryTouchHelper extends ItemTouchHelper.SimpleCallback {

    private CountryListAdapter adapter;

    private RecyclerItemTouchHelperListener listener;

    public RecyclerCountryTouchHelper(int dragDirs, int swipeDirs, RecyclerItemTouchHelperListener listener, CountryListAdapter adapter) {
        super(dragDirs, swipeDirs);
        this.listener = listener;
        this.adapter = adapter;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        if(viewHolder != null){
            final View foregroundView = ((CountryViewHolder) viewHolder).vForeground;
            getDefaultUIUtil().onSelected(foregroundView);
        }
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        final View foregroundView = ((CountryViewHolder) viewHolder).vForeground;
        getDefaultUIUtil().clearView(foregroundView);
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull final RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        final View foregroundView = ((CountryViewHolder) viewHolder).vForeground;
        getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        final View foregroundView = ((CountryViewHolder) viewHolder).vForeground;
        getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        listener.onSwiped(viewHolder, direction, viewHolder.getAdapterPosition());
    }



}
