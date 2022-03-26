public class MySelfArray<E> {

    private E[] data;
    private int size;

    public MySelfArray(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public MySelfArray(){
        this(0);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return data.length == 0;
    }

    public void addLast(E e){
        add(data.length,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void add(int index,E e){
        if(index < 0 || index > getSize()){
            throw new IllegalArgumentException("index is not illegal.");
        }
        if(size == data.length){
            resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i+ 1] = data[i];
        }
        data[index] = e;
        size ++ ;
    }

    public E get(int index){
        if(index < 0 || index > getSize()){
            throw new IllegalArgumentException("index is not illegal.");
        }
        return data[index];
    }

    public void set(int index,E e){
        if(index < 0 || index > getSize()){
            throw new IllegalArgumentException("index is not illegal.");
        }
        data[index] = e;
    }

    public boolean contains(E e){

        for (int i = 0; i < data.length; i++) {
            if(data[i] == e){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i = 0; i < data.length; i++) {
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }



    public E remove(int index){
        if(index < 0 || index > getSize()){
            throw new IllegalArgumentException("index is not illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
