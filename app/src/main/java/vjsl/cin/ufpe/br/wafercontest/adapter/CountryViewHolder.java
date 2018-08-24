package vjsl.cin.ufpe.br.wafercontest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import vjsl.cin.ufpe.br.wafercontest.R;

public class CountryViewHolder extends RecyclerView.ViewHolder {

    public TextView countryName;
    public TextView countryLanguage;
    public TextView countryCurrency;
    public ImageView flags;
    public RelativeLayout vBackground;
    public RelativeLayout vForeground;

    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);
        countryName = itemView.findViewById(R.id.country_name);
        countryLanguage = itemView.findViewById(R.id.country_language);
        countryCurrency = itemView.findViewById(R.id.country_currency);
        //flags = itemView.findViewById(R.id.flag);
        vBackground = itemView.findViewById(R.id.view_background);
        vForeground = itemView.findViewById(R.id.view_foreground);

    }
}
