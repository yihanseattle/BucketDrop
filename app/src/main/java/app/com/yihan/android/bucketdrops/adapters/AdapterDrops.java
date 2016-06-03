package app.com.yihan.android.bucketdrops.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import app.com.yihan.android.bucketdrops.R;

/**
 * Created by HanYi on 6/2/16.
 */
public class AdapterDrops extends RecyclerView.Adapter<AdapterDrops.DropHolder> {

    private LayoutInflater mInflater;
    private ArrayList<String> mItems;

    public AdapterDrops(Context context) {
        mInflater = LayoutInflater.from(context);
        mItems = generateValues();
    }

    public static ArrayList<String> generateValues() {
        ArrayList<String> dummyValues = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            dummyValues.add("Item " + i);
        }

        return dummyValues;
    }

    @Override
    public DropHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.row_drop, parent, false);
        DropHolder holder = new DropHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(DropHolder holder, int position) {
        holder.mTextWhat.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class DropHolder extends RecyclerView.ViewHolder {

        TextView mTextWhat;

        public DropHolder(View itemView) {
            super(itemView);
            mTextWhat = (TextView) itemView.findViewById(R.id.tv_what);

        }
    }

}
