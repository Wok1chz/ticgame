package sample;

public class Elements {
    private int arg;
    private  final Elements[] gmap = new Elements[9];


    Elements(int arg){
        this.arg=arg;
    }

    int get_value(int i){
        return gmap[i].arg;
    }

    public void fill_map(){
        for (int i = 0; i < 9; i++) {
            gmap[i] = new Elements(0);
        }
    }
    public void set_x( int i){ gmap[i].arg=1; }
    public void set_o( int i){
        gmap[i].arg=2;
    }

    //0 1 2
    //3 4 5
    //6 7 8

  public boolean check_win(){
        if((gmap[0].arg==1 && gmap[1].arg==1 && gmap[2].arg==1) || (gmap[0].arg==2 &&gmap[1].arg==2 &&gmap[2].arg==2)){
            return true;
        } else if((gmap[3].arg==1 && gmap[4].arg==1 && gmap[5].arg==1) || (gmap[3].arg==2 &&gmap[4].arg==2 &&gmap[5].arg==2)){
            return true;
    }else if((gmap[6].arg==1 && gmap[7].arg==1 && gmap[8].arg==1) || (gmap[6].arg==2 &&gmap[7].arg==2 &&gmap[8].arg==2)) {
            return true;
        }
        else if((gmap[0].arg==1 && gmap[3].arg==1 && gmap[6].arg==1) || (gmap[0].arg==2 &&gmap[3].arg==2 &&gmap[6].arg==2)){
            return true;
        }
        else if((gmap[1].arg==1 && gmap[4].arg==1 && gmap[7].arg==1) || (gmap[1].arg==2 &&gmap[4].arg==2 &&gmap[7].arg==2)){
            return true;
        }
        else if((gmap[2].arg==1 && gmap[5].arg==1 && gmap[8].arg==1) || (gmap[2].arg==2 &&gmap[5].arg==2 &&gmap[8].arg==2)){
            return true;
        } else if((gmap[0].arg==1 && gmap[4].arg==1 && gmap[8].arg==1) || (gmap[0].arg==2 &&gmap[4].arg==2 &&gmap[8].arg==2)){
            return true;
        } else return (gmap[2].arg == 1 && gmap[4].arg == 1 && gmap[6].arg == 1) || (gmap[2].arg == 2 && gmap[4].arg == 2 && gmap[6].arg == 2);
  }

  public  boolean check_full(){
      return gmap[0].arg != 0 && gmap[1].arg != 0 && gmap[2].arg != 0 && gmap[3].arg != 0 && gmap[4].arg != 0 && gmap[5].arg != 0 && gmap[6].arg != 0 && gmap[7].arg != 0 && gmap[8].arg != 0;
  }
}
