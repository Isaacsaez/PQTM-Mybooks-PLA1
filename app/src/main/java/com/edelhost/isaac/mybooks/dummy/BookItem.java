package com.edelhost.isaac.mybooks.dummy;

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
       // Añadimos 2 Libros para la lista
       addItem(new DummyItem("1","Las Fábulas de las Emociones", "María Valverde", "23-04-2017","Libro de emociones infantil"));
       addItem(new DummyItem("2","Sisu Yoga", "María Valverde","25-03-2019","Libro de Yoga para niños"));
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

        public DummyItem(String id, String titulo, String autor, String fecha, String descripcion) {
            this.id = id;
            this.titulo = titulo;
            this.autor = autor;
            this.fecha = fecha;
            this.descripcion = descripcion;
        }

        @Override
        public String toString() {
            return titulo;
        }
    }
}
