package com.damon.peliculasinformacion.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.Model.Tv.TvRecomendationsResults;
import com.damon.peliculasinformacion.Model.Tv.TvResponseResults;
import com.damon.peliculasinformacion.R;
import com.damon.peliculasinformacion.TvDetailActivity;
import com.damon.peliculasinformacion.ViewHolder.SearchViewHolder;

import java.util.List;

public class TvRecomendationAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Activity activity;
    private List<TvRecomendationsResults> tvResponseResultsList;

    public TvRecomendationAdapter(Activity activity, List<TvRecomendationsResults> tvResponseResultsList) {
        this.activity = activity;
        this.tvResponseResultsList = tvResponseResultsList;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.search_layout_items,parent,false);
        return  new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        TvRecomendationsResults tvResponseResults = tvResponseResultsList.get(position);
        holder.setPosterImageView(activity, tvResponseResults.getBackdrop_path());
        String title = tvResponseResults.getName();
        int id = tvResponseResults.getId();

        if (title !=null){
            holder.posterTitle.setVisibility(View.VISIBLE);
            holder.posterTitle.setText(title);
        }else {
            holder.posterTitle.setVisibility(View.GONE);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, TvDetailActivity.class);
                intent.putExtra("id",String.valueOf(id));
                activity.startActivity(intent);

                // create som animationto open
                activity.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_letf);

             //   Toast.makeText(activity, String.valueOf(id), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return tvResponseResultsList.size();
    }
}
