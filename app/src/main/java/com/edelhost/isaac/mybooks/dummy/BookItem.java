package com.edelhost.isaac.mybooks.dummy;

import android.graphics.drawable.Drawable;

import com.edelhost.isaac.mybooks.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Clase que contiene los datos de los libros listados en la App MyBooks

public class BookItem {


    // Creamos el array de libros a mostrar y un map del array
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    // Añadimos 2 Libros para la lista con sus diferentes campos
   static{
       addItem(new DummyItem("1","Las Fábulas de las Emociones", "María Valverde", "23-04-2017","Este libro contiene las claves para aprender a desarrollar la inteligencia emocional. Éstas permitiran al niño identificar y aceptar sus emociones, sin dejarse llevar por ellas, consiguiendo así, una mayor autonomía para resolver situaciones de manera más positiva. Además de ser un apoyo para la adquisición de buenos hábitos tales como: la alimentación, la rutina del sueño y la higiene, entre otros.",R.drawable.fabulas));
       addItem(new DummyItem("2","Sisu Yoga", "María Valverde","25-03-2019","Este cuento pretende ser una herramienta para introducir a los niños en el mundo del conocimiento personal, a través de una historia emocionante y divertida, en la que se sentirán los protagonistas.\n" +
               "\n" +
               "El contenido del libro es una sesión de yoga que empieza por tomar conciencia del cuerpo, sigue con unas aasanas o ejercicios adaptados a los niños,, que fomentan la flexibilidad, la habilidad y la coordinación y finaliza con un pranayama o respiraciones, que favorecen la concentración.",R.drawable.sisu));
   }


    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    // creamos las variables para cada campo de los libros
    public static class DummyItem {
        public String id;
        public String titulo;
        public String autor;
        public String fecha;
        public String descripcion;
        public int imagen;


        public DummyItem(String id, String titulo, String autor, String fecha, String descripcion, int imagen) {
            this.id = id;
            this.titulo = titulo;
            this.autor = autor;
            this.fecha = fecha;
            this.descripcion = descripcion;
            this.imagen= imagen;
        }

        @Override
        public String toString() {
            return titulo;
        }
    }
}
