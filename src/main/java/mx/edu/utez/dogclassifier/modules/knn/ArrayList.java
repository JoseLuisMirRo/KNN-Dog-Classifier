package mx.edu.utez.dogclassifier.modules.knn;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements Iterable<T>{
    //Atributos que definen al arrayList
    private T[] array; //Array generico que define el arrayList
    private int size; //Tamaño del arrayList
    private int capacity; //Capacidad del arrayList

    //Construtor de la lista
    @SuppressWarnings("unchecked")
    public ArrayList(){
        this.capacity = 10; //Capacidad inicial del arrayList -> Iniciamos con 10 espacios por estandar
        this.array = (T[]) new Object[capacity]; //Inicializacion del array
        this.size = 0; //Tamaño inicial del arrayList
    }

    //Metodo para redimensionar el array cuando es necesario 
    private void resize(){
        capacity *= 2; //Duplicamos la capacidad del array
        T[] newArray = (T[]) new Object[this.capacity]; //Creamos un nuevo array con la nueva capacidad
        System.arraycopy(this.array, 0, newArray, 0, size); //Copiamos los elementos del array original al nuevo array
        this.array = newArray; //Reasignamos la referencia al nuevo array
    }

    //Metodo para agregar un elemento al final - Es void por que estamos haciendo nuestra propia implementacion
    public boolean add(T element){
        if(this.size == this.capacity){ //Si el tamaño es igual a la capacidad
            resize(); //Redimensionamos el array
        }
        this.array[this.size++] = element; //Agregamos el elemento al final del array
        return true;
    }

    //Metodo para obtener un elemento por indice
    public T get(int index){
        if(index<0 || index>=size){ //Si el indice es menor a 0 o mayor al tamaño del array
            throw new IndexOutOfBoundsException("El indice esta fuera de los limites del arreglo"); //Lanzamos una excepcion
        }
        return this.array[index];
    }

    //Metodo para remover un elemento por indice
    public boolean remove(int index){
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException("El indice esta fuera de los limites del arreglo");
        }

        //Mover los elementos despues del indice a la izquierda
        for(int i=index; i<size-1; i++){
            array[i] = this.array[i+1];
        }
        array[size-1] = null; //Eliminamos el ultimo elemento
        size--; //Disminuimos el tamaño del array

        return true;
    }

    //Metodo para obtener el tamaño del array
    public int size(){
        return this.size;
    }

    //Metodo para verificar si el ArrayList esta vacio
    public boolean isEmpty(){
        return this.size == 0;
    }

    //Metodo para limpiar el ArrayList
    public void clear() {
        for(int i=0; i<size; i++){
            array[i] = null;
        }
        this.size = 0;
    }

    //Metodo para buscar si un elemento esta en el ArrayList
    public boolean contains(T element){
        for(int i=0; i<size; i++){
            if(array[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    //Metodo para reemplazar un elemento en un índice específico
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("El índice está fuera de los límites del arreglo");
        }
        T oldElement = this.array[index]; // Guardar el elemento actual
        this.array[index] = element;     // Reemplazar con el nuevo elemento
        return oldElement;               // Devolver el elemento anterior
    }

    //Implementacion del iterador
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    // Clase interna para implementar el iterador
    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        //Metodo para verificar si hay mas elementos
        @Override
        public boolean hasNext() {
            return currentIndex < size; // Verifica si hay más elementos
        }

        //Metodo para obtener el siguiente elemento
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista");
            }
            return array[currentIndex++]; // Devuelve el elemento actual y avanza al siguiente
        }

        //Metodo para eliminar un elemento
        @Override
        public void remove() {
            if (currentIndex <= 0) {
                throw new IllegalStateException("No se puede eliminar antes de llamar a next()");
            }
            ArrayList.this.remove(--currentIndex); // Elimina el elemento y ajusta el índice
        }
    }
}

