package com.damon.peliculasinformacion.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.Model.Tv.TvCreditsCrew;
import com.damon.peliculasinformacion.PersonDetailActivity;
import com.damon.peliculasinformacion.R;
import com.damon.peliculasinformacion.ViewHolder.TvSeasonsViewHolder;

import java.util.List;

public class TvCredistCrewAdapter extends RecyclerView.Adapter<TvSeasonsViewHolder> {

    private Activity activity ;
    private List<TvCreditsCrew> tvCreditsCrewList;

    public TvCredistCrewAdapter(Activity activity, List<TvCreditsCrew> tvCreditsCastList) {
        this.activity = activity;
        this.tvCreditsCrewList = tvCreditsCastList;
    }

    @NonNull
    @Override
    public TvSeasonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_seasons,parent,false);
        return new TvSeasonsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvSeasonsViewHolder holder, int position) {

        TvCreditsCrew creditsCast = tvCreditsCrewList.get(position);
        holder.setSeasonView(activity,creditsCast.getProfile_path());
        holder.season_name.setText("Departamento: "+creditsCast.getDepartment());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PersonDetailActivity.class);
                intent.putExtra("id",String.valueOf(creditsCast.getId()));

                activity.startActivity(intent);

                // create som animationto open
                activity.overridePendingTransition(R.anim.slide_in_letf,R.anim.slide_out_right);

            }
        });
    }

    @Override
    public int getItemCount() {
        return tvCreditsCrewList.size();
    }
}
