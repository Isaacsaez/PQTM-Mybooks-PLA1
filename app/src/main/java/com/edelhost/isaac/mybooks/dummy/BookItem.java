package com.edelhost.isaac.mybooks.dummy;

import java.util.ArrayList;
import java.util.Date;
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
       addItem(new DummyItem("1","Las Fábulas de las Emociones", "María Valverde", "23-04-2017","Este libro contiene las claves para aprender a desarrollar la inteligencia emocional. Éstas permitiran al niño identificar y aceptar sus emociones, sin dejarse llevar por ellas, consiguiendo así, una mayor autonomía para resolver situaciones de manera más positiva. Además de ser un apoyo para la adquisición de buenos hábitos tales como: la alimentación, la rutina del sueño y la higiene, entre otros."));
       addItem(new DummyItem("2","Sisu Yoga", "María Valverde","25-03-2019","Este cuento pretende ser una herramienta para introducir a los niños en el mundo del conocimiento personal, a través de una historia emocionante y divertida, en la que se sentirán los protagonistas.\n" +
               "\n" +
               "El contenido del libro es una sesión de yoga que empieza por tomar conciencia del cuerpo, sigue con unas aasanas o ejercicios adaptados a los niños,, que fomentan la flexibilidad, la habilidad y la coordinación y finaliza con un pranayama o respiraciones, que favorecen la concentración."));
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
