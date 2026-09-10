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
        return cabeza;
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
            else{
                iterador = iterador.siguiente;
            }
        }
        return null;
    }

    @Override
    public Object search(Object object) {
        ListNode iterador = this.cabeza;
        while(iterador != null){
            if (iterador.dato == object){
                return iterador.dato;
            }
            else{
                iterador = iterador.siguiente;
            }
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
        else{
            while(iterador.siguiente != null){
                iterador = iterador.siguiente;
            }
            ListNode nuevoNodo = new ListNode(object);
            iterador.siguiente = nuevoNodo;
            return true;
        }
    }

    @Override
    public boolean insert(ListNode node, Object object) {
        ListNode iterador = this.cabeza;
        if (iterador == null){
            return false;
        }
        else{
            while (iterador.dato != node){
                iterador = iterador.siguiente;
            }
            ListNode nuevoNodo = new ListNode(object);
        }
    }
    @Override
    public boolean insert(Object ob, Object object) {
        return false;
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
        return false;
    }

    @Override
    public boolean remove(ListNode node) {
        return false;
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }

    @Override
    public Iterator<ListNode> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] object) {
        return new Object[0];
    }

    @Override
    public Object getBeforeTo() {
        return null;
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        return null;
    }

    @Override
    public Object getNextTo() {
        return null;
    }

    @Override
    public Object getNextTo(ListNode node) {
        return null;
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        return null;
    }

    @Override
    public MiLista sortList() {
        return null;
    }

    @Override
    public String toString() {
        return "MiLista{" +
                "cabeza=" + cabeza +
                '}';
    }
}
