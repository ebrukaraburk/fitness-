package com.example.fitnessuygulamasi;

import static android.media.CamcorderProfile.get;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.io.ObjectInputStream;
import java.util.ArrayList;

public class FitnessEkraniActivity extends AppCompatActivity {
    RecyclerView benimrecycle;
    ArrayList<Yemekler> yemeklers;
    MyrecycAdaptor myadaptor;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_ekrani);
        benimrecycle =findViewById(R.id.rcyclemyrecycle);
        yemeklers = new ArrayList<>();
        myadaptor = new MyrecycAdaptor(yemeklers);
        benimrecycle.setAdapter(myadaptor);
        benimrecycle.setLayoutManager(new LinearLayoutManager(this));
        myadaptor.notifyDataSetChanged();
        db = FirebaseFirestore.getInstance();

        diziolustur();

        fetchYemekler();
        CollectionReference yemeklerCollection = db.collection("yemekler");
        Yemekler yemek3 = new Yemekler(3,"Mısır","96 cal/100gr");
        Yemekler yemek4 = new Yemekler(4,"Bezelye","84 cal/100gr");
        Yemekler yemek5 = new Yemekler(5,"Patates","76 cal/100gr");
        Yemekler yemek6 = new Yemekler(6,"Pırasa","52 cal/100gr");
        Yemekler yemek7 = new Yemekler(7,"Pancar","43 cal/100gr");
        Yemekler yemek8 = new Yemekler(8,"Havuç","42 cal/100gr");
        Yemekler yemek9 = new Yemekler(9,"Kereviz","40 cal/100gr");
        Yemekler yemek10 = new Yemekler(10,"Fasulye","32 cal/100gr");
        Yemekler yemek11 = new Yemekler(11,"Mantar","28 cal/100gr");
        Yemekler yemek12 = new Yemekler(12,"Karnabahar","27 cal/100gr");
        Yemekler yemek13 = new Yemekler(13,"Ispanak","26 cal/100gr");
        Yemekler yemek14 = new Yemekler(14,"Lahana","24 cal/100gr");
        Yemekler yemek15 = new Yemekler(15,"Biber","22 cal/100gr");

        yemeklerCollection.add(yemek3);
        yemeklerCollection.add(yemek4);
        yemeklerCollection.add(yemek5);
        yemeklerCollection.add(yemek6);
        yemeklerCollection.add(yemek7);
        yemeklerCollection.add(yemek8);
        yemeklerCollection.add(yemek9);
        yemeklerCollection.add(yemek10);
        yemeklerCollection.add(yemek11);
        yemeklerCollection.add(yemek12);
        yemeklerCollection.add(yemek13);
        yemeklerCollection.add(yemek14);
        yemeklerCollection.add(yemek15);


    }

    private void diziolustur() {

    }

    private void fetchYemekler(){

        db.collection("yemekler")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        yemeklers.clear();

                        for (QueryDocumentSnapshot document : task.getResult()) {

                            int logo = ((Long) document.get("logo")).intValue();
                            String yemekadi = (String) document.get("yemekadi");
                            String kalori = (String) document.get("kalori");

                            Yemekler yemek = new Yemekler(logo, yemekadi, kalori);
                            yemeklers.add(yemek);
                        }

                        myadaptor.notifyDataSetChanged();
                    } else {
                    }
                });
    }



    }