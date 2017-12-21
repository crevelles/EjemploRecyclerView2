package com.example.cristobal.ejemplorecyclerview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    RecyclerView miRecyclerView;
    LinearLayoutManager miLayoutManager;
    Adaptador miAdaptador;
    Datos datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miRecyclerView = (RecyclerView) findViewById(R.id.idRecyclerView);
        miRecyclerView.setHasFixedSize(true);
        miLayoutManager = new LinearLayoutManager(this);
        miRecyclerView.setLayoutManager(miLayoutManager);
        datos = new Datos();
        miAdaptador = new Adaptador(datos.getLista());

        miAdaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Seleccionada la opción " + miRecyclerView.indexOfChild(v) + " tipo animal: "
                        + ((Adaptador.MiViewHolder)miRecyclerView.getChildViewHolder(v)).getTextoSup().getText();
                Toast.makeText(MainActivity.this, msg,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Item item = datos.getLista().get(miRecyclerView.indexOfChild(v));
                intent.putExtra("item", item);
                startActivity(intent);
            }
        });
        miRecyclerView.setAdapter(miAdaptador);


    }


}
