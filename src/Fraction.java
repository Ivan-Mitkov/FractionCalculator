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
    public  int getEnumenator(){
        return this.x;
    }
    public int getDenominator(){
        return this.y;
    }
    public double toDouble(){
        double a=(double)this.x;
        double b = (double)this.y;
        return a/b;
    }
    public int toLowestTerms(){
        int a= this.x;
        int b=this.y;
        int divider = gcd(a,b);
        int m=a/divider;
        int n=b/divider;
        return m*n*divider;
    }
    public static int toLowestTerms(int a, int b){
        int divider = gcd(a,b);
        int m=a/divider;
        int n=b/divider;
        return m*n*divider;
    }
    public static int gcd(int a, int b){

        while (a!=0&&b!=0){
            int divider=a%b;
            a=b;
            b=divider;
        }
        return a;
    }

    public Fraction add(Fraction other){
        int lowestTerm=toLowestTerms(this.y,other.y);
      int thisMultip=lowestTerm/this.y;
      int otherMultip=lowestTerm/other.y;
      int firstEnum=thisMultip*this.x;
      int secondEnum=otherMultip*other.x;
      int fracEnum=firstEnum+secondEnum;
      Fraction res=new Fraction(fracEnum,lowestTerm);
      return res;
    }
    public Fraction subtract(Fraction other){
       int fracEnum=this.x*other.y-(Math.abs(this.y*other.x));
       int fracDenum=this.y*other.y;
        Fraction temp=new Fraction(fracEnum,fracDenum);
        Fraction res=formatFrac(temp);
        return res;
    }
    public static Fraction formatFrac(Fraction a){
        int m=gcd(a.x,a.y);
        int en=a.x/m;
        int den=a.y/m;
        return new Fraction(en,den);
    }
    public Fraction multiply(Fraction other){
        int fracEnum=this.x*other.x;
        int fracDenum=this.y*other.y;
        Fraction temp=new Fraction(fracEnum,fracDenum);
        Fraction res=formatFrac(temp);
        return res;
    }
    public Fraction divide(Fraction other){
        int fracEnum=this.x*other.y;
        int fracDenum=this.y*other.x;
        Fraction temp=new Fraction(fracEnum,fracDenum);
        Fraction res=formatFrac(temp);
        return res;
    }
    public boolean equals(Fraction other){
        Fraction first=formatFrac(this);
        Fraction second=formatFrac(other);
        return first.x==second.x&&first.y==second.y;
    }
    public static void main(String[] args) {
        Fraction myFraction1=new Fraction();
        Fraction myFraction2=new Fraction(4,18);
        Fraction myFraction3=new Fraction(2,9);
        Fraction myFraction4=new Fraction(-7,8);
        Fraction myFraction5=new Fraction(12,9);
        Fraction myFraction6=new Fraction(0,9);
        Fraction a=myFraction3.divide(myFraction4);
        System.out.println(a.toString());
        System.out.println(myFraction2.equals(myFraction3));

    }




}
