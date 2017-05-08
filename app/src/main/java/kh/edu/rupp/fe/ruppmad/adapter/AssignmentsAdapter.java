package kh.edu.rupp.fe.ruppmad.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kh.edu.rupp.fe.ruppmad.R;

/**
 * Created by sophal_nc on 5/6/17.
 */

public class AssignmentsAdapter extends RecyclerView.Adapter<AssignmentsAdapter.ViewHolder> {

    Context context;
    List<Assignment> listAssignment;

    public AssignmentsAdapter(Context context,List<Assignment> listAssignment){
        this.context = context;
        this.listAssignment = listAssignment;
    }

    @Override
    public AssignmentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.viewholder_assignment,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AssignmentsAdapter.ViewHolder holder, int position) {

        long timestamp = Long.parseLong(listAssignment.get(position).getDeadline());  // some megic to get the value
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        String date = format.format(new Date(timestamp * 1000));

        holder.txt_title.setText(listAssignment.get(position).getTitle());
        holder.txt_deadline.setText(date.toString());




    }

    @Override
    public int getItemCount() {
        int size = (listAssignment == null)?0:listAssignment.size();
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_title, txt_deadline;
        public ImageView iv_image;
        public ViewHolder(View itemView) {
            super(itemView);

            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            txt_deadline = (TextView) itemView.findViewById(R.id.txt_deadline);
            iv_image = (ImageView) itemView.findViewById(R.id.img_thumbnail);

        }
    }
}
