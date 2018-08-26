package vjsl.cin.ufpe.br.wafercontest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import vjsl.cin.ufpe.br.wafercontest.adapter.CountryListAdapter;
import vjsl.cin.ufpe.br.wafercontest.adapter.CountryViewHolder;
import vjsl.cin.ufpe.br.wafercontest.helper.HttpService;
import vjsl.cin.ufpe.br.wafercontest.helper.RecyclerCountryTouchHelper;
import vjsl.cin.ufpe.br.wafercontest.helper.RecyclerItemTouchHelperListener;
import vjsl.cin.ufpe.br.wafercontest.helper.SwipeHelper;
import vjsl.cin.ufpe.br.wafercontest.model.Country;

public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelperListener {

    private RecyclerView recyclerView;
    private List<Country> countryList;
    private CountryListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        try {
            countryList = new ArrayList<>(Arrays.asList(new HttpService().execute().get()));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adapter = new CountryListAdapter(this, countryList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Uncomment the next 2 lines and comment SwipeHelper lines to turn only swipe action active.
        //ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerCountryTouchHelper(0, ItemTouchHelper.LEFT, this, adapter);
        //new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

/**/
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_delete);
        SwipeHelper swipeHelper = new SwipeHelper(this, recyclerView, adapter) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(bitmap,
                        "Delete",
                        0,
                        Color.parseColor("#854cc6"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                adapter.removeCountry(pos);

                            }
                        }
                ));


            }
        };

    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int adapterPosition) {
        if(viewHolder instanceof CountryViewHolder){
            adapter.removeCountry(viewHolder.getAdapterPosition());
        }
    }
}
