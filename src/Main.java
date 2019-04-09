import parser.ParseWrapper;

public class Main {
    public static void main(String[] args) { //todo: change print out value to false
        String f = "(&x.(+ x 2)) 4";
        f = "((&x. x x)(&x.x x))";
        //f = "((&x. ((&y.(x y))x))(&z.w))";
        //f = "(λy.(λz.w)(λz.w))";
        //f = "(λz.w)";
        //f = "((((&f.(&g.(&x.((fx)(g x)))))(&m.(&n.(n m))))(&n.z))p)";
        //f = "(&x.x)p";
        //f = "(&m.(&n.nx))";
        //f = "(&g.(&x.(&m.(&n.nx))gx))";
        System.out.println(ParseWrapper.lambdaParserLoop(f));
    }
}
