package com.nurhossen.bdjosbnurassignment.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nurhossen.bdjosbnurassignment.R;
import com.nurhossen.bdjosbnurassignment.service.model.Datum;

import java.util.List;

class AdapterView extends RecyclerView.Adapter<AdapterView.CustomView> {

    private List<Datum> datalist;
    private Context context;

    public AdapterView(List<Datum> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.itemview, parent,false);

        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        holder.tv_jobtitle.setText(datalist.get(position).getJobTitle().toString());
        holder.tv_companyname.setText(datalist.get(position).getRecruitingCompanySProfile());
        Glide.with(context).load(datalist.get(position).getLogo()).into(holder.logoimage);

        if(!datalist.get(position).getMinSalary().isEmpty() && !datalist.get(position).getMaxSalary().isEmpty()){
            holder.tv_salary.setText(datalist.get(position).getMinSalary()  +" To "+ datalist.get(position).getMaxSalary()+"TK" );
        }

       else if(!datalist.get(position).getMinSalary().isEmpty() && datalist.get(position).getMaxSalary().isEmpty()){
            holder.tv_salary.setText(datalist.get(position).getMinSalary() + " TK");
        }
        else if(datalist.get(position).getMinSalary().isEmpty() && !datalist.get(position).getMaxSalary().isEmpty()){
            holder.tv_salary.setText(datalist.get(position).getMaxSalary() + " TK");
        }else if(datalist.get(position).getMinSalary().isEmpty() && datalist.get(position).getMaxSalary().isEmpty()) {
            holder.tv_salary.setText("Negotiable");
        }

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class CustomView extends RecyclerView.ViewHolder {
        TextView tv_jobtitle,tv_companyname, tv_salary,tv_expreancemin, tv_expreancemax, tv_deadline, tv_applyinstruction;
        ImageView logoimage;
        public CustomView(@NonNull View itemView) {
            super(itemView);

            tv_jobtitle=itemView.findViewById(R.id.jobtitleid);
            tv_companyname=itemView.findViewById(R.id.companynameid);
            tv_salary=itemView.findViewById(R.id.salaryid);

            tv_deadline=itemView.findViewById(R.id.deadlineid);
            tv_applyinstruction=itemView.findViewById(R.id.emailid);
            logoimage = itemView.findViewById(R.id.img_logoid);
        }
    }
}