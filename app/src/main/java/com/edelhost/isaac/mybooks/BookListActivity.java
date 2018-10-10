package com.edelhost.isaac.mybooks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.edelhost.isaac.mybooks.dummy.BookItem;
import java.util.List;

// Clase para la Actividad principal de la app MyBooks
public class BookListActivity extends AppCompatActivity {

    //variable para almacenar la info de la posicion del dispositivo (vertical/horizontal)
    private boolean mTwoPane;

    // variables par/impar para definir los diferentes layouts de la lista.
    private static final Integer PAR = 1;
    private static final Integer IMPAR = 2;



    // Asignamos el layout correspondiente en la Actividad con su Barra superior
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());


        // Mostrar el book_detail_container (FrameLayout) si el dispositivo esta en horizontal
        if (findViewById(R.id.book_detail_container) != null) {
            mTwoPane = true;
        }

        // Mostrar el book_list (RecyclerView)
        View recyclerView = findViewById(R.id.book_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }


    // Código de configuración y funcionalidad del RecyclerView, por ej. que sea clicable, etc..
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, BookItem.ITEMS, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final BookListActivity mParentActivity;
        private final List<BookItem.DummyItem> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookItem.DummyItem item = (BookItem.DummyItem) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(BookDetailFragment.ARG_ITEM_ID, item.id);
                    BookDetailFragment fragment = new BookDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.book_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, BookDetailActivity.class);
                    intent.putExtra(BookDetailFragment.ARG_ITEM_ID, item.id);

                    context.startActivity(intent);
                }
            }
        };


        // Adapter necesario para el RecyclerView
        SimpleItemRecyclerViewAdapter(BookListActivity parent,
                                      List<BookItem.DummyItem> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }


        // Código para asignar cada posición del array de libros a par o impar
        @Override
        public int getItemViewType(int position) {
            if (position % 2 == 0) {
                return PAR;
            } else {
                return IMPAR;
            }
        }


        // Asignamos un layout u otro en el caso de que su posición sea par o impar
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View root = null;

            if (viewType == PAR) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.book_list_content, parent, false);
                return new ViewHolder(view);
            } else {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.book_list_content_impar, parent, false);
                return new ViewHolder(view);
            }
        }

        // Asignamos los datos correspondientes a los campos de los libros
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            //holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).titulo);
            holder.mAutorView.setText(mValues.get(position).autor);
            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);



        }

        //Recogemos cada View para insertarle los datos del libro
        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;
            final TextView mAutorView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
                mAutorView = (TextView) view.findViewById(R.id.autor);
            }
        }
    }
}
