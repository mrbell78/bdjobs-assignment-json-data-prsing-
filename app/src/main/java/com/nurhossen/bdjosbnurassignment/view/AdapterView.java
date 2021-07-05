package com.nurhossen.bdjosbnurassignment.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.text.Html;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nurhossen.bdjosbnurassignment.R;
import com.nurhossen.bdjosbnurassignment.service.model.Datum;

import java.util.List;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

import static android.content.ContentValues.TAG;

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


        String orvalue = Html.fromHtml(datalist.get(position).getJobDetails().getApplyInstruction()).toString();





        Log.d(TAG, "onBindViewHolder: instruction "+orvalue);

        holder.tv_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(holder.expandable.getVisibility()== View.GONE){
                   holder.tv_see.setText("See Less");
                   TransitionManager.beginDelayedTransition(holder.cardView,new AutoTransition());
                   holder.expandable.setVisibility(View.VISIBLE);
               }else{
                   holder.tv_see.setText("See Details");
                   TransitionManager.beginDelayedTransition(holder.cardView,new AutoTransition());
                   holder.expandable.setVisibility(View.GONE);
               }

            }
        });

        if(datalist.get(position).getIsFeatured()==true){
            final int sdk = android.os.Build.VERSION.SDK_INT;
            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                holder.tv_companyname.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.heightlit_item) );
                holder.tv_deadline.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.heightlit_item) );
                holder.tv_salary.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.heightlit_item) );
                holder.tv_expreance.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.heightlit_item) );

            } else {
                holder.tv_companyname.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.heightlit_item) );
                holder.tv_deadline.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.heightlit_item) );
                holder.tv_salary.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.heightlit_item) );
                holder.tv_expreance.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.heightlit_item) );
            }

        }

        holder.tv_jobtitle.setText(datalist.get(position).getJobTitle().toString());
        holder.tv_companyname.setText(datalist.get(position).getRecruitingCompanySProfile());
        Glide.with(context).load(datalist.get(position).getLogo()).into(holder.logoimage);
        if(datalist.get(position).getMinExperience()!=null && datalist.get(position).getMaxExperience()!=null){
            holder.tv_expreance.setText("Min "+ datalist.get(position).getMinExperience() + " years to max "+datalist.get(position).getMaxExperience() + " years Required ");
        }else if(datalist.get(position).getMinExperience()==null && datalist.get(position).getMaxExperience()!=null){
            holder.tv_expreance.setText(" max "+datalist.get(position).getMaxExperience() + " years Required ");
        }

        else if(datalist.get(position).getMinExperience()!=null && datalist.get(position).getMaxExperience()==null){
            holder.tv_expreance.setText(" min "+datalist.get(position).getMinExperience() + " years Required ");
        }else if(datalist.get(position).getMinExperience()==null && datalist.get(position).getMaxExperience()==null){
            holder.tv_expreance.setText("NA");
        }





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


        //String[] separated = orvalue.split(":");

        holder.tv_applyinstruction.setText(orvalue);

    }

    /*private void blurbackground(CustomView holder) {
        float radius = 21f;

        View decorView = ((Activity) context).getWindow().getDecorView();
        //ViewGroup you want to start blur from. Choose root as close to BlurView in hierarchy as possible.
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        //Set drawable to draw in the beginning of each blurred frame (Optional).
        //Can be used in case your layout has a lot of transparent space and your content
        //gets kinda lost after after blur is applied.
        Drawable windowBackground = decorView.getBackground();

        holder.blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(context))
                .setBlurRadius(radius)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(true);
    }*/

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class CustomView extends RecyclerView.ViewHolder {
        TextView tv_jobtitle,tv_companyname, tv_salary,tv_expreancemin, tv_expreancemax, tv_deadline, tv_applyinstruction,tv_see,tv_expreance;
        RelativeLayout expandable;
        CardView cardView;
        LinearLayout lnlyoutid;
        ImageView logoimage;
        View mview;
        public CustomView(@NonNull View itemView) {
            super(itemView);
            mview = itemView;
            tv_jobtitle=itemView.findViewById(R.id.jobtitleid);
            tv_companyname=itemView.findViewById(R.id.companynameid);
            tv_salary=itemView.findViewById(R.id.salaryid);
           // blurView=itemView.findViewById(R.id.blurView);
            tv_deadline=itemView.findViewById(R.id.deadlineid);
            tv_applyinstruction=itemView.findViewById(R.id.emailid);
            logoimage = itemView.findViewById(R.id.img_logoid);
            expandable=itemView.findViewById(R.id.expandable);
            tv_see=itemView.findViewById(R.id.seeid);
            cardView=itemView.findViewById(R.id.cardviewid);
            tv_expreance=itemView.findViewById(R.id.minex);
            lnlyoutid=itemView.findViewById(R.id.lnlyoutid);


        }


    }
}