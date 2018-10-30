public class SuperArray{
  private String[] data;
  private int size = 0;

  public SuperArray(){
    data = new String[10];
  }

  public SuperArray(int startingCapacity){
    if (startingCapacity < 0){
      throw new IllegalArgumentException();
    }
    data = new String[startingCapacity];
  }

  public void clear(){
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    if (size == 0){
      return true;
    }
    return false;
  }

  public boolean add(String s){
    if (data.length > size()){
      data[size] = s;
      size ++;
    }
    else{
      resize();
      add(s);
    }
    return true;
  }

  public String toString(){
    if (size() == 0){
      return "[]";
    }
    String output = "[";
    for(int x = 0; x < size(); x++){
      if (x == size() - 1){
        output += data[x] + "]";
      }
      else{
        output += data[x] + ", ";
      }
    }
    return output;
  }

  public String toStringDebug(){
    if (size() == 0){
      return "[]";
    }
    String output = "[";
    for(int x = 0; x < data.length; x++){
      if (x == data.length - 1){
        output += data[x] + "]";
      }
      else{
        output += data[x] + ", ";
      }
    }
    return output;
  }

  public String get(int idx){
    if (idx < 0 || idx >= size()){
      throw new IndexOutOfBoundsException();
    }
    else{
      return data[idx];
    }
  }

  public String set(int idx, String str){
    String old = "";
    if (idx < 0 || idx >= size()){
      throw new IndexOutOfBoundsException();
    }
    else{
      old = data[idx];
      data[idx] = str;
    }
    return old;
  }

  private void resize(){
    String newarr[] = new String[2*data.length+1];
    for (int x = 0; x < size(); x++){
      newarr[x] = data[x];
    }
    data = newarr;
  }

  public boolean contains(String target){
    for (int x = 0; x < size(); x++){
      if(target.equals(data[x])){
        return true;
      }
    }
    return false;
  }

  public int indexOf(String target){
    for (int x = 0; x < size(); x++){
      if(target.equals(data[x])){
        return x;
      }
    }
    return -1;
  }

  public int lastIndexOf(String target){
    int last = -1;
    for (int x = 0; x < size(); x++){
      if(target.equals(data[x])){
        last = x;
      }
    }
    return last;
  }

  public void add(int idx, String str){
    if (idx < 0 || idx > size()){
      throw new IndexOutOfBoundsException();
    }
    else{
      if (size() >= data.length){
        this.resize();
        this.add(idx,str);
      }
      else{

      for (int x = size(); x >= idx; x -= 1){
        if (x == idx){
          data[x] = str;
          size ++;
        }
        else{
          data[x] = data[x-1];
        }
      }
    }

    }
  }
  /*public void add(int idx,String str){
    if (idx < 0 || idx > size()){
      throw new IndexOutOfBoundsException("idx not good!");
    }
    else{
      if (size() >= data.length){
        this.resize();
        for (int x = idx; x < data.length-1; x++){
          if (x == idx){
            data[x] = str;
          }
          else{
            data[x+1]=data[x];
          }
        }
       }

      else if (size() < data.length){
        for (int x = this.size(); x < data.length-1; x++){
          if (x == idx){
            data[x] = str;
          }
          else{
            data[x+1]=data[x];
          }
        }
      }
    }


    size++;
  }*/


  public String remove(int idx) {
    String oldstr = data[idx];
    if (idx < 0 || idx > size()){
      throw new IndexOutOfBoundsException();
    }
    else{
      for (int x = idx; x <= size(); x += 1){
        if (x == size()){
          data[x] = null;
        }
        else{
          data[x] = data[x+1];
        }
      }
      size --;
    }
    return oldstr;
  }

  public boolean remove(String str){
    int idx = indexOf(str);
    if (contains(str)){
      remove(idx);
      return true;
    }
    else{
      return false;
    }
  }
}
