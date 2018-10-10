package com.edelhost.isaac.mybooks;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.edelhost.isaac.mybooks.dummy.BookItem;


// Fragment que contendrá los datos del detalle de los libros y será colocada en la actividad
// BookDetailActivity

public class BookDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";

    private BookItem.DummyItem mItem;

    //recuperamos la información de los diferentes campos del libro que hemos seleccionado
    //Incluyendo el Título de la Barra superior

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {

            mItem = BookItem.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.titulo);
            }
        }
    }

    // Insertamos la información recuperada de cada campo, en el View correspondiente

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.book_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.tv_titulo)).setText(mItem.titulo);
            ((TextView) rootView.findViewById(R.id.tv_autor)).setText(mItem.autor);
            ((TextView) rootView.findViewById(R.id.tv_fecha)).setText(mItem.fecha);
            ((TextView) rootView.findViewById(R.id.tv_desc)).setText(mItem.descripcion);
            ((ImageView)rootView.findViewById(R.id.iv_portada)).setImageResource(mItem.imagen);
        }

        return rootView;
    }

}
