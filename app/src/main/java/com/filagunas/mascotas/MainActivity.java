package com.filagunas.mascotas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.filagunas.mascotas.adapter.MascotaAdaptador;
import com.filagunas.mascotas.pojo.Mascota;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    Button top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creacion de Toolbar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(miActionBar);
        top =(Button) findViewById(R.id.favoritos);
        //llamada al RecyclerView
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        botoncamera();
        inicializarAdaptador();

    }

    public MascotaAdaptador adaptador;

    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.p1, "fido", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p2, "puppy", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p3, "shira", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p4, "aquiles", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p5, "duque", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p6, "naila", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p7, "shina", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p8, "hanna", "perro", 0));


    }
    //Carga de menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_actions, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu) {

            Toast.makeText(this,"presiono la opcion 1:", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.menu1) {

            Toast.makeText(this,"presiono la opcion 2:", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.favoritos) {

            Intent intent=new Intent(this, Top5.class);
            intent.putExtra("listatop", mascotas);
            Toast.makeText(MainActivity.this,"presiono la opcion favoritos:", Toast.LENGTH_LONG).show();

            startActivity(intent);
            return true;


        }

        return  super.onOptionsItemSelected(item);


    }
    public void botoncamera() {
        FloatingActionButton camera = (FloatingActionButton) findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, getResources().getString(R.string.camera), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.camera), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR", "Click en Snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }

}

