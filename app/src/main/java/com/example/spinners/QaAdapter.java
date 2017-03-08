package com.example.spinners;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spinners.model.QaItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QaAdapter extends RecyclerView.Adapter<QaAdapter.ViewHolder> {

    private List<QaItem> mItems;
    private Context mContext;
    private View itemView;

    public QaAdapter(Context context, List<QaItem> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public QaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        switch(viewType) {
            case R.layout.item_row:
                itemView = inflater.inflate(R.layout.item_row, parent, false);
                break;
            case R.layout.button_row:
                itemView = inflater.inflate(R.layout.button_row, parent, false);
        }

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QaAdapter.ViewHolder holder, int position) {
        if (position == mItems.size()) {
            holder.button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Answers submitted successfully", Toast.LENGTH_LONG).show();
                }

            });
        }
        else {
            final QaItem item = mItems.get(position);

            holder.tvName.setText(item.getQuestion());

            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    mContext, android.R.layout.simple_spinner_item, item.getOptions());
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            holder.spinner.setAdapter(adapter);
            holder.spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selected = parent.getItemAtPosition(position).toString();
                    StringBuilder result = new StringBuilder();
                    result.append(position)
                            .append(" ")
                            .append(id)
                            .append(" ")
                            .append(item.getId())
                            .append(" ").append(selected);
                    Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position == mItems.size()) ? R.layout.button_row : R.layout.item_row;
    }

    @Override
    public int getItemCount() { return mItems.size() + 1; }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public Spinner spinner;
        public Button button;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.textView1);
            spinner = (Spinner) itemView.findViewById(R.id.spinner1);
            button = (Button) itemView.findViewById(R.id.submit_button);
        }
    }
}