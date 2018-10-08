package com.edelhost.isaac.mybooks.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class BookItem {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

   static{
       // Añadimos 2 Libros para la lista
       addItem(new DummyItem("1","Las Fábulas de las Emociones", "María Valverde", "23-04-2017","Libro de emociones infantil"));
       addItem(new DummyItem("2","Sisu Yoga", "María Valverde","25-03-2019","Libro de Yoga para niños"));
   }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

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
