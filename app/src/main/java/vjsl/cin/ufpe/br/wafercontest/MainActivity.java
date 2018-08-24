package vjsl.cin.ufpe.br.wafercontest;

import android.graphics.Color;
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

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerCountryTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

/*
        SwipeHelper swipeHelper = new SwipeHelper(this, recyclerView, adapter) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Delete",
                        0,
                        Color.parseColor("#FF3C30"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                adapter.removeCountry(pos);

                            }
                        }
                ));


            }
        };
        */

    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int adapterPosition) {
        if(viewHolder instanceof CountryViewHolder){
            String name = countryList.get(viewHolder.getAdapterPosition()).getName();

            final Country deletedCountry = countryList.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();
            adapter.removeCountry(viewHolder.getAdapterPosition());
        }
    }
}
