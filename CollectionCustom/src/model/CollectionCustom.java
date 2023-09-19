package model;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CollectionCustom<T> implements Iterator<T> {
    private T[] array;
    private int size;
    private int iteradorIndex = 0;

    public CollectionCustom(){
        array = (T[]) new Object[10];
        size = 0;
    }
    /**
     * @return int Devuelve la cantidad de valores ocupados en el array
     */
    public int getSize(){
        return size;
    }

    /**
     * Agrega al principio del array
     * @param element
     */
    public void addFirst(T element){
        if(array[0] == null) size++;
        array[0] = element;
    }

    /**
     * Agrega al final del array
     * @param element
     */
    public void addLast(T element){
        if(array[array.length - 1] == null) size++;

        array[array.length - 1] = element;
    }

    /**
     * Agregar elementos al array
     * @param element
     */
    public void add(T element){
        if(size >= array.length){
            resizeArray();
        }

        boolean seguirBuscandoLugar = true;
        int index = 0;

        do{
            if(array[index] == null){
                array[index] = element;
                seguirBuscandoLugar = false;
                size++;
            }
            index++;
        }while(seguirBuscandoLugar);
    }

    public boolean empty() {
        return size == 0;
    }

    /**
     * Metodo para visualizar el contenido de una posicion
     * @param index posicion que desea ver
     * @return el contenido de una posicion del array
     */
    public T get(int index){
        if(index >= array.length) return null;
        return array[index];
    }
    /**
     * Metodo para eliminar un objeto especifico
     * @param element
     * @return el elemento eliminado sino lo encontro devuelve un null
     */
    public T remove(T element){
        T returnElement = null;
        boolean seguirBuscando = true;
        int index = 0;
        if(size > 0){
            while (seguirBuscando && index < array.length){
                if (element.equals(array[index])) {
                    returnElement = array[index];
                    array[index] = null;
                    seguirBuscando = false;
                    size--;
                }
                index++;
            };
        }
        return returnElement;
    }
    /**
     * Metodo que remueve todos los elementos del array
     */
    public void removeAll(){
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }
    /**
     * Metodo privado para redimencionar el array cuadno sea necesario
     */
    private void resizeArray() {
        int nuevaCapacidad = array.length * 2;
        T[] nuevoArray = (T[]) new Object[nuevaCapacidad];
        System.arraycopy(array, 0, nuevoArray, 0, size);
        array = nuevoArray;
    }

    /**
     * Metodo que se utiliza antes de recorrer el CollectionCustom
     */
    public void resetearIterador(){
        iteradorIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return iteradorIndex < array.length && !empty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        return array[iteradorIndex++];
    }

}
