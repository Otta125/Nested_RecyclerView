package kim.nested.recyclerview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kim.nested.recyclerview.Models.ChildModel;
import kim.nested.recyclerview.Models.ParentModel;
import kim.nested.recyclerview.R;

public class ParentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ParentModel> parentModelArrayList;
    public Context cxt;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category;
        public RecyclerView childRecyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.Movie_category);
            childRecyclerView = itemView.findViewById(R.id.Child_RV);
        }
    }
    public static class MyViewHolder2 extends RecyclerView.ViewHolder {
        public TextView category;
       // public RecyclerView childRecyclerView;

        public MyViewHolder2(View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.imageView);
           // childRecyclerView = itemView.findViewById(R.id.Child_RV);
        }
    }
    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
       // return position % 2 * 2;
        if (position==0){
            return 0;
        }else {
            return 2;
        }
    }
    public ParentRecyclerViewAdapter(ArrayList<ParentModel> exampleList, Context context) {
        this.parentModelArrayList = exampleList;
        this.cxt = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scecond_holder, parent, false);
                return new MyViewHolder2(view);
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_recyclerview_items, parent, false);
                return new MyViewHolder(view);

        }
        return null;
   /*     View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_recyclerview_items, parent, false);
        return new MyViewHolder(view);*/
    }



    @Override
    public int getItemCount() {
        return parentModelArrayList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (position == 0) {
            ParentModel currentItem = parentModelArrayList.get(position);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(cxt, LinearLayoutManager.HORIZONTAL, false);
            ((MyViewHolder) holder).childRecyclerView.setLayoutManager(layoutManager);
            ((MyViewHolder) holder).childRecyclerView.setHasFixedSize(true);

            ((MyViewHolder) holder).category.setText(currentItem.movieCategory());
            ArrayList<ChildModel> arrayList = new ArrayList<>();

            // added the first child row
            if (parentModelArrayList.get(position).movieCategory().equals("Category1")) {
                arrayList.add(new ChildModel(R.drawable.themartian,"Movie Name"));
                arrayList.add(new ChildModel(R.drawable.moana,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.mov2,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.blackp,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.moviedubbedinhindi2,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.hollywood1,"Movie Name"));
            }

            // added in second child row
            if (parentModelArrayList.get(position).movieCategory().equals("Category2")) {
                arrayList.add(new ChildModel(R.drawable.moviedubbedinhindi2,"Movie Name"));
                arrayList.add(new ChildModel(R.drawable.moviedubbedinhindi3,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.moviedubbedinhindi1,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.moviedubbedinhindi4,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.moviedubbedinhindi5,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.moviedubbedinhindi6,"Movie Name"));
            }

            // added in third child row
            if (parentModelArrayList.get(position).movieCategory().equals("Category3")) {
                arrayList.add(new ChildModel(R.drawable.hollywood6,"Movie Name"));
                arrayList.add(new ChildModel(R.drawable.hollywood5,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.hollywood4,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.hollywood3,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.hollywood2,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.hollywood1,"Movie Name"));
            }

            // added in fourth child row
            if (parentModelArrayList.get(position).movieCategory().equals("Category4")) {
                arrayList.add(new ChildModel(R.drawable.bestofoscar6,"Movie Name"));
                arrayList.add(new ChildModel(R.drawable.bestofoscar5,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.bestofoscar4,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.bestofoscar3,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.bestofoscar2,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.bestofoscar1,"Movie Name"));
            }

            // added in fifth child row
            if (parentModelArrayList.get(position).movieCategory().equals("Category5")) {
                arrayList.add(new ChildModel( R.drawable.moviedubbedinhindi4,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.hollywood2,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.bestofoscar4,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.mov2,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.hollywood1,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.bestofoscar1,"Movie Name"));
            }

            // added in sixth child row
            if (parentModelArrayList.get(position).movieCategory().equals("Category6")) {
                arrayList.add(new ChildModel(R.drawable.hollywood5,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.blackp,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.bestofoscar4,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.moviedubbedinhindi6,"Movie Name"));
                arrayList.add(new ChildModel( R.drawable.hollywood1,"Movie Name"));
                arrayList.add(new ChildModel(R.drawable.bestofoscar6,"Movie Name"));
            }

            ChildRecyclerViewAdapter childRecyclerViewAdapter = new ChildRecyclerViewAdapter(arrayList,((MyViewHolder) holder).childRecyclerView.getContext());
            ((MyViewHolder) holder).childRecyclerView.setAdapter(childRecyclerViewAdapter);

        } else {
            ((MyViewHolder2) holder).category.setText("HAAAAAAA");
        }

    }
}