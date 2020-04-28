package Holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midulsterfootballleague.Contact;
import com.example.midulsterfootballleague.R;

public class ContactHolder extends RecyclerView.ViewHolder {

    View view;

    public ContactHolder(@NonNull View itemView) {
        super(itemView);

        view = itemView;


    }
    public void setView(Context context , String name){

        TextView nametv = view.findViewById(R.id.user_name);

        nametv.setText(name);
    }
}
