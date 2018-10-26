public class SuperArray{
  private String[] data;
  private int size = 0;

  public SuperArray(){
    data = new String[10];
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
    String output = "[";
    for(int x = 0; x < size(); x++){
      if (x == size() - 1){
        output += data[x] + "]";
      }
      else{
        output += data[x] + ", ";
      }
    }
    if (size() == 0){
      output += "]";
    }
    return output;
  }

  public String toStringDebug(){
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
      System.err.println("Error: idx out of range");
      return null;
    }
    else{
      return data[idx];
    }
  }

  public String set(int idx, String str){
    String old = "";
    if (idx < 0 || idx >= size()){
      System.err.print("Error: idx out of range");
      return null;
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
      System.out.println("Error: idx out of range");
    }
    else{
      for (int x = size() + 1; x >= idx; x -= 1){
        if (x == idx){
          data[x] = str;
        }
        else{
          data[x] = data[x-1];
        }
      }
      size ++;
    }
  }

  public String remove(int idx) {
    String oldstr = data[idx];
    if (idx < 0 || idx > size()){
      System.out.println("Error: idx out of range");
      return null;
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
