package com.edelhost.isaac.mybooks;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;


// Clase extendida de AppCompatActivity que será la actividad de los detalles del libro

public class BookDetailActivity extends AppCompatActivity {


    // Añadimos el Layout a la Actividad con su toolbar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);


        // Muestra el botón para volver a la BookListActivity en la barra de acciones.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        // Códogo generado por Android Studio, enlaza la información del libro
        // de la BookListActivity y la traspasa al BookDetailActivity para que muestre
        // la información correspondiente del elemento clicado

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(BookDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(BookDetailFragment.ARG_ITEM_ID));
            BookDetailFragment fragment = new BookDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.book_detail_container, fragment)
                    .commit();
        }
    }
}
