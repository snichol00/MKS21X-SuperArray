public class SuperArray{
  private String[] data;
  private int size;

  public SuperArray(){
    String arr[] = new String[10];
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
      data[size + 1] = s;
    }
    /*else{
      resize();
      add(s);
    }*/
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
      return null;
    }
    else{
      return data[idx];
    }
  }

  public String set(int idx, String str){
    if (idx < 0 || idx >= size()){
      return null;
    }
    else{
      data[idx] = str;
    }
    return toString();
  }
}
