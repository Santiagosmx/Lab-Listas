import java.util.Iterator;
import java.util.List;

public class MiLista implements ListInterface{
    ListNode cabeza;

    @Override
    public boolean isEmpty()
    {
        ListNode actual = this.cabeza;
        if(actual == null){
            return true;
        }
        else
        {
            return false;
        }
        /*
        if head == null
        print true
        else print false
         */
    }

    @Override
    public int getSize() {
        ListNode iterador = this.cabeza;
        int contador = 1;
        while (iterador.siguiente != null){
            iterador = iterador.siguiente;
            contador = contador + 1;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;
    }

    @Override
    public Object getHead() {
        if(cabeza == null){
            return null;
        }
        return cabeza.dato
    }

    @Override
    public Object getTail() {
        ListNode iterador = this.cabeza;
        while(iterador != null && iterador.siguiente != null){
            iterador = iterador.siguiente;
        }
        return iterador;
    }

    @Override
    public Object get(ListNode node) {
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if(iterador.dato == node.dato ){
                return iterador.dato;
            }
            iterador = iterador.siguiente;

        }
        return null;
    }

    @Override
    public Object search(Object object) {
        ListNode iterador = this.cabeza;

        while (iterador != null) {
            if (iterador.dato.equals(object)) {
                return iterador.dato;
            }

            iterador = iterador.siguiente;
        }

        return null;
    }

    @Override
    public boolean add(Object object) {
        ListNode iterador = this.cabeza;
        if(iterador == null){
            ListNode nuevaCabeza = new ListNode(object);
            this.cabeza = nuevaCabeza;
            return true;
        }
        while(iterador.siguiente != null){
            iterador = iterador.siguiente;
        }
        ListNode nuevoNodo = new ListNode(object);
        iterador.siguiente = nuevoNodo;
        return true;

    }

    @Override
    public boolean insert(ListNode node, Object object) {
        ListNode iterador = this.cabeza;
        while (iterador != null && iterador != node){
            iterador = iterador.siguiente;
        }
        if (iterador == null){
            return false;
        }
        ListNode nuevoNodo = new ListNode(object);
        nuevoNodo.siguiente = iterador.siguiente;
        iterador.siguiente = nuevoNodo;

        return true;
    }

    @Override
    public boolean insert(Object ob, Object object) {
        ListNode iterador = this.cabeza;
        while (iterador != null && !iterador.dato.equals(ob)){
            iterador = iterador.siguiente;
        }
        if (iterador == null){
            return false;
        }
        ListNode nuevoNodo = new ListNode(object);
        nuevoNodo.siguiente = iterador.siguiente;
        iterador.siguiente = nuevoNodo;

        return true;
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            // 1er paso: Crear el nuevo nodo con la información recibida
            ListNode nuevaCabeza = new ListNode(object);
            //2do paso: Conectar el nodo a la cabeza
            nuevaCabeza.siguiente = this.cabeza;
            //3er paso: redefinir la cabeza
            this.cabeza = nuevaCabeza;
            return true;
        } catch (Exception e){
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        if(this.cabeza == null){
            ListNode nuevaCabeza = new ListNode(object);
            this.cabeza = nuevaCabeza;
        }else {
            ListNode nuevaCola = new ListNode(object);
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;

            }
            iterador.siguiente = nuevaCola;
        }
        return true;

    }

    @Override
    public boolean set(ListNode node, Object object) {
        ListNode iterador = this.cabeza;
        while (iterador != null && iterador != node){
            iterador = iterador.siguiente;
        }
        if (iterador == null){
            return false;
        }
        iterador.dato = object;

        return true;
    }

    @Override
    public boolean remove(ListNode node) {
        ListNode anterior = null;
        ListNode iterador = this.cabeza;
        while(iterador != null && iterador != node){
            anterior = iterador;
            iterador = iterador.siguiente;
        }
        if (iterador == null){
            return false;
        }
        else if(iterador == this.cabeza){
          this.cabeza = iterador.siguiente;
        }
        else{
            anterior.siguiente = iterador.siguiente;
        }
        return true;
    }

    @Override
    public boolean contains(Object object) {
        ListNode iterador = this.cabeza;
        while(iterador != null && !iterador.dato.equals(object)){
            iterador = iterador.siguiente;
        }
        if(iterador == null){
            return false;
        }
        return true;
    }

    @Override
    public java.util.Iterator<ListNode> iterator() {
        return new java.util.Iterator<ListNode>() {

            private ListNode actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public ListNode next() {
                ListNode temporal = actual;
                actual = actual.siguiente;
                return temporal;
            }
        };
    }

    @Override
    public Object[] toArray() {
        int cantidad = 0;
        ListNode iterador = this.cabeza;

        while (iterador != null) {
            cantidad++;
            iterador = iterador.siguiente;
        }

        Object[] array = new Object[cantidad];

        iterador = this.cabeza;
        int i = 0;

        while (iterador != null) {
            array[i] = iterador.dato;
            iterador = iterador.siguiente;
            i++;
        }

        return array;
    }

    @Override
    public Object[] toArray(Object[] object) {
        ListNode iterador = this.cabeza;
        int i = 0;

        while (iterador != null && i < object.length) {
            object[i] = iterador.dato;
            iterador = iterador.siguiente;
            i++;
        }

        return object;
    }

    @Override
    public Object getBeforeTo() {
        if (this.cabeza == null || this.cabeza.siguiente == null) {
            return null;
        }

        ListNode iterador = this.cabeza;

        while (iterador.siguiente.siguiente != null) {
            iterador = iterador.siguiente;
        }

        return iterador.dato;
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        if (this.cabeza == null || this.cabeza == node) {
            return null;
        }

        ListNode anterior = null;
        ListNode iterador = this.cabeza;

        while (iterador != null && iterador != node) {
            anterior = iterador;
            iterador = iterador.siguiente;
        }

        if (iterador == null) {
            return null;
        }

        return anterior.dato;
    }

    @Override
    public Object getNextTo() {
        if (this.cabeza == null) {
            return null;
        }

        return this.cabeza.siguiente;
    }

    @Override
    public Object getNextTo(ListNode node) {
        if (node == null) {
            return null;
        }

        return node.siguiente;
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        MiLista nuevaLista = new MiLista();
        ListNode iterador = from;

        while (iterador != null) {
            nuevaLista.add(iterador.dato);

            if (iterador == to) {
                break;
            }

            iterador = iterador.siguiente;
        }

        return nuevaLista;
    }

    @Override
    public MiLista sortList() {
        MiLista nuevaLista = new MiLista();

        ListNode iterador = this.cabeza;

        while (iterador != null) {
            iterador = iterador.siguiente;
        }

        return nuevaLista;
    }

    @Override
    public String toString() {
        String resultado = "[";
        ListNode iterador = this.cabeza;

        while (iterador != null) {
            resultado += iterador.dato;

            if (iterador.siguiente != null) {
                resultado += ", ";
            }

            iterador = iterador.siguiente;
        }

        resultado += "]";

        return resultado;
    }
}
