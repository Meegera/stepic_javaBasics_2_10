import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Calculate {
    static public void main (String []args) throws FileNotFoundException {
        File file = new File("example.txt");
        Scanner sc = new Scanner (file);
        String line = sc.nextLine();
        double a = 0.0;
        double b = 0.0;
        String znak = " ";
        String res = "";
        int m=0;
        boolean flag = true;
        for(String num:line.split(" ")) {
            m++;
            if(m==1 | m==3) {
                try {
                    if(m == 1) a = Double.valueOf(num);
                    if(m == 3) b = Double.valueOf(num);
                }catch(NumberFormatException e) {
                    System.out.print("Error! Not number\n");
                    flag = false;
                    break;
                }
            }
        }
        if(flag) {
            m=0;
            for(String num:line.split(" ")) {
                m++;
                if(m==2) {
                    try {
                        znak = num;
                        if(!(num.equals("/") | num.equals("+") | num.equals("-") | num.equals("*"))) throw new Exception("Operation Error!");
                    }catch(Exception s){
                        System.out.print(s.getMessage());
                        flag=false;
                        break;
                    }
                }
            }
        }
        if(flag) {
            switch(znak){
                case("+"): res += (a + b);
                    break;
                case("-"): res += (a - b);
                    break;
                case("/"):
                    if(b==0.0) System.out.print("Error! Division by zero");
                    else     res += (a / b);
                    break;
                case("*"): res += (a * b);
                    break;
            }
            PrintWriter pw = new PrintWriter("output.txt");
            pw.println(res);
            pw.close();
        }

    }
}