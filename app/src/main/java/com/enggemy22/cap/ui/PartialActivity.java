package com.enggemy22.cap.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.enggemy22.cap.R;
import com.enggemy22.cap.models.University;
import com.enggemy22.cap.splash.SplashActivity;
import com.enggemy22.cap.splash.fianlSpalsh;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static com.enggemy22.cap.ui.HomeActivity.KEY_ACTRANGE;
import static com.enggemy22.cap.ui.HomeActivity.KEY_GPA;
import static com.enggemy22.cap.ui.HomeActivity.KEY_SATRANGE;

public class PartialActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListner {
    private RecyclerView recyclerView;
    private FirebaseFirestore mFirestore;
    private Task<QuerySnapshot> mQuery;
    private List<University> mlist;
    private String gpa;
    private String Actrange;
    private String satrange;
    private String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partial);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mlist = new ArrayList<>();
        mFirestore = FirebaseFirestore.getInstance();
        Intent intent = getIntent();
        gpa = intent.getStringExtra(KEY_GPA);
        Actrange = intent.getStringExtra(KEY_ACTRANGE);
        satrange = intent.getStringExtra(KEY_SATRANGE);
        Log.e("mohamed", gpa);
        Log.e("mostafa", Actrange);
        Log.e("momo", satrange);
        getData();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void getData() {
        mlist = new ArrayList<>();
        mQuery = mFirestore.collection("universities/")
                .get().addOnSuccessListener(queryDocumentSnapshots -> {
                    for (DocumentSnapshot snapshot : queryDocumentSnapshots) {
                        University university = snapshot.toObject(University.class);
                        if(Float.parseFloat(university.getGpa()) <= Float.parseFloat(gpa)
                                && isInRange(university.getSat_score_range_max() , university.getSat_score_range_min() ,
                                university.getEst_score_range_max() , university.getEst_score_range_min())) {
                            mlist.add(university);
                            Log.d("mohamed", "getData: ADDED");
                        }
                    }
                    ItemAdapter adapter = new ItemAdapter(mlist, PartialActivity.this, PartialActivity.this);
                    recyclerView.setAdapter(adapter);
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(PartialActivity.this);
                        builder.setTitle("Oh Sorry .....!")
                                .setMessage("tour data is not matching on database")
                                .setNegativeButton("canceil", (dialogInterface, i) -> {
                                    startActivity(new Intent(PartialActivity.this,SplashActivity.class));
                                })
                                .setPositiveButton("yes", (dialogInterface, i) -> {
                                    startActivity(new Intent(PartialActivity.this,HomeActivity.class));
                                });
                        builder.show();
                    }
                });
    }

    @Override
    public void onItemClick(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(PartialActivity.this);
        builder.setTitle("Attention")
                .setMessage(" thank you your data is saved in data base  and we will contact with you")
                .setNegativeButton("canceil", (dialogInterface, i) -> {
                    Toast.makeText(this, " ok go to edit your data", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PartialActivity.this,HomeActivity.class));
                })
                .setPositiveButton("yes", (dialogInterface, i) -> {
                    startActivity(new Intent(PartialActivity.this, fianlSpalsh.class));
                });
        builder.show();

    }
    private boolean isInRange(int sat_max , int sat_min , int est_max , int est_min){
        return sat_max >= Float.parseFloat(satrange) && sat_min <= Float.parseFloat(satrange)
                && est_max >= Float.parseFloat(Actrange) && est_min <= Float.parseFloat(Actrange);
    }
}
