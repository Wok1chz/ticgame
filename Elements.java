package sample;

public class Elements {
    private
    int arg;

    Elements(int arg){
        this.arg=arg;
    }

    int get_value(){
        return arg;
    }

    static void fill_map(Elements map[]){
        for (int i = 0; i < 9; i++) {
            map[i] = new Elements(0);
        }
    }
    static void set_x(Elements map[], int i){ map[i].arg=1; }
    static void set_o(Elements map[], int i){
        map[i].arg=2;
    }

    static void show_map(Elements map[]) {
        for (int i = 0; i < 9; i++) {
            System.out.println(map[i].get_value());
        }
    }

    //0 1 2
    //3 4 5
    //6 7 8

  public static boolean check_win(Elements[] map){
        if((map[0].arg==1 && map[1].arg==1 && map[2].arg==1) || (map[0].arg==2 &&map[1].arg==2 &&map[2].arg==2)){
            return true;
        } else if((map[3].arg==1 && map[4].arg==1 && map[5].arg==1) || (map[3].arg==2 &&map[4].arg==2 &&map[5].arg==2)){
            return true;
    }else if((map[6].arg==1 && map[7].arg==1 && map[8].arg==1) || (map[6].arg==2 &&map[7].arg==2 &&map[8].arg==2)) {
            return true;
        }
        else if((map[0].arg==1 && map[3].arg==1 && map[6].arg==1) || (map[0].arg==2 &&map[3].arg==2 &&map[6].arg==2)){
            return true;
        }
        else if((map[1].arg==1 && map[4].arg==1 && map[7].arg==1) || (map[1].arg==2 &&map[4].arg==2 &&map[7].arg==2)){
            return true;
        }
        else if((map[2].arg==1 && map[5].arg==1 && map[8].arg==1) || (map[2].arg==2 &&map[5].arg==2 &&map[8].arg==2)){
            return true;
        } else if((map[0].arg==1 && map[4].arg==1 && map[8].arg==1) || (map[0].arg==2 &&map[4].arg==2 &&map[8].arg==2)){
            return true;
        } else return (map[2].arg == 1 && map[4].arg == 1 && map[6].arg == 1) || (map[2].arg == 2 && map[4].arg == 2 && map[6].arg == 2);
  }

  public static boolean check_full(Elements[] map){
      return map[0].arg != 0 && map[1].arg != 0 && map[2].arg != 0 && map[3].arg != 0 && map[4].arg != 0 && map[5].arg != 0 && map[6].arg != 0 && map[7].arg != 0 && map[8].arg != 0;
  }
}
