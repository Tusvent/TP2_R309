package com.rt.tp2_r309;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText titreFilm;
    private  ArrayList<String> list = new ArrayList<String>();
    private ArrayAdapter<String> myAdapter;
    private ListView listTitre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAdapter = new ArrayAdapter<String>(
                this, // Le contexte
                android.R.layout.simple_list_item_1, //Le layout de la liste
        list); // Le tableau de données, créé au dessus

        listTitre = (ListView) findViewById(R.id.listeFilm);
        listTitre.setAdapter(myAdapter);


        listTitre.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> p, View v, int pos, long id) {
                Toast.makeText(getApplicationContext(), "Item à la position " + pos + " cliqué", Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void addFilm(View v) {
        String titre;
        titreFilm = (EditText) findViewById(R.id.titreFilm);
        titre = titreFilm.getText().toString();
        if (titre.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Veuillez entrer un titre de film", Toast.LENGTH_SHORT).show();
        }
        else {
            list.add(titre);
            myAdapter.notifyDataSetChanged();
        }
    }
}

