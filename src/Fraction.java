public class Fraction {
    private int x;
    private int y;

    Fraction(){
        this.x=0;
        this.y=1;
    }
    Fraction(int x){
        this.x=x;
        this.y=1;
    }



    Fraction(int x, int y){

        if(y==0)throw new IllegalArgumentException("Denominator is 0");
        else{
            if(x<0&&y<0||x>0&&y<0){
                this.x=-x;
                this.y=-y;
            }
            else {
                this.x=x;
                this.y=y;
            }

        }





    }
    @Override
    public String toString() {
        String res="";
        if(this.x!=0&&this.y!=0){
            res =x+"/"+y;
        }
        else if(this.x==0&&this.y!=0){
            res=""+0;
        }

       return res;
    }
    public static void main(String[] args) {
        Fraction myFraction1=new Fraction();
        Fraction myFraction2=new Fraction(3);
        Fraction myFraction3=new Fraction(2,8);
        Fraction myFraction4=new Fraction(-7,8);
        Fraction myFraction5=new Fraction(6,-9);
        Fraction myFraction6=new Fraction(0,9);
        System.out.println(myFraction1.toString());
        System.out.println(myFraction2.toString());
        System.out.println(myFraction3.toString());
        System.out.println(myFraction4.toString());
        System.out.println(myFraction5.toString());
        System.out.println(myFraction6.toString());
    }




}
