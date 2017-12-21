package com.example.cristobal.ejemplorecyclerview;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView nombreAnimal;
    TextView textoAnimal;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombreAnimal = findViewById(R.id.idTXTNombre);
        textoAnimal = findViewById(R.id.idTXTexto);
        imagen = findViewById(R.id.idImsgen);

        Item item = getIntent().getParcelableExtra("item");
        imagen.setImageResource(item.getIdImagen());
        nombreAnimal.setText(item.getTextoSuperior());
        textoAnimal.setText(item.getTextoInferior());


    }
}
