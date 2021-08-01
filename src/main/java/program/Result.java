package program;

public class Result {
    double result;
    String action;
    public Result (double a, String b){
      this.result=a;
      this.action=b;
    }
    public String toString(){
        return String.valueOf(result) + " "+ action;
    }
}

