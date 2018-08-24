package vjsl.cin.ufpe.br.wafercontest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vjsl.cin.ufpe.br.wafercontest.R;
import vjsl.cin.ufpe.br.wafercontest.model.Country;

public class CountryListAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private Context context;
    private List<Country> countryList;

    public CountryListAdapter(Context context, List<Country> countryList){
        this.context = context;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View countryView = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);
        return new CountryViewHolder(countryView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.countryName.setText(country.getName());
        holder.countryLanguage.setText("Language: " + country.getLanguages()[0].getName());
        holder.countryCurrency.setText("Currency: " + country.getCurrencies()[0].getName());

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public void removeCountry(int position){
        countryList.remove(position);
        notifyItemRemoved(position);
    }
}
