import model.CollectionCustom;

public class Main {
    public static void main(String[] args) {
        // Ejemplo con Integer
        CollectionCustom<Integer> integerCollection = new CollectionCustom<>();

        // Agregar elementos de tipo Integer
        integerCollection.add(10);
        integerCollection.add(20);
        integerCollection.add(30);
        integerCollection.addFirst(5);
        integerCollection.addLast(40);

        // Mostrar el tamaño de la colección
        System.out.println("Tamaño de integerCollection: " + integerCollection.getSize());

        // Mostrar los elementos
        System.out.println("Elementos en integerCollection:");
        integerCollection.resetearIterador();
        while(integerCollection.hasNext()) {
            System.out.println(integerCollection.next());
        }

        // Remover un elemento
        Integer removedElement = integerCollection.remove(20);
        System.out.println("Elemento removido: " + removedElement);

        // Remover todos los elementos
        integerCollection.removeAll();

        // Verificar si la colección está vacía
        System.out.println("La colección está vacía: " + integerCollection.empty());

        // Ejemplo con String
        CollectionCustom<String> stringCollection = new CollectionCustom<>();

        // Agregar elementos de tipo String
        stringCollection.add("Manzana");
        stringCollection.add("Banana");
        stringCollection.addLast("Cereza");
        stringCollection.addFirst("Naranja");
        stringCollection.add("Fresa");

        // Mostrar el tamaño de la colección
        System.out.println("\nTamaño de stringCollection: " + stringCollection.getSize());

        // Mostrar los elementos
        System.out.println("Elementos en stringCollection:");
        integerCollection.resetearIterador();
        while(integerCollection.hasNext()) {
            System.out.println(integerCollection.next());
        }

        // Remover un elemento
        String removedString = stringCollection.remove("Banana");
        System.out.println("Elemento removido: " + removedString);

        // Remover todos los elementos
        stringCollection.removeAll();

        // Verificar si la colección está vacía
        System.out.println("La colección está vacía: " + stringCollection.empty());

    }
}