package com.example.midulsterfootballleague;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private List<League> leagues = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<League> leagues, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("Division 1");
    }

    public void printTable(final DataStatus dataStatus){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                leagues.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode :dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    League league = keyNode.getValue(League.class);
                    leagues.add(league);
                }
                dataStatus.DataIsLoaded(leagues, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
