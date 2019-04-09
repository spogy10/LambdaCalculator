package parser;

public class ParseWrapper {

    private static int betaReductionCount = 0;
    private static boolean shouldPrint = false;

    public static String lambdaparse(String function){
        String result = "";
        betaReductionCount = 0;
        function = function.replace("λ", "&");
        parser p = new parser(function);
        p.setShouldPrint(shouldPrint);
        try {
            p.parse();
            result = p.finalResult.replace("&", "λ");
            result = removeUnnecessaryLambda(result);
            betaReductionCount = p.getBetaReductionCount();
        } catch (Exception e) {
            //e.printStackTrace();
            result = "Unable to compute lambda expression";
        }
        return result;
    }

    public static int getBetaReductionCount(){
        return betaReductionCount;
    }

    public static String removeUnnecessaryLambda(String s){
        if(s.contains("λ")) {
            s = s.substring(4);
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    public static String lambdaparse(String function, parser p){
        String result = "";
        betaReductionCount = 0;
        function = function.replace("λ", "&");
        p = new parser(function);
        p.setShouldPrint(shouldPrint);
        try {
            p.parse();
            result = p.finalResult.replace("&", "λ");
            result = removeUnnecessaryLambda(result);
            betaReductionCount = p.getBetaReductionCount();
        } catch (Exception e) {
            //e.printStackTrace();
            result = "Unable to compute lambda expression";
        }
        return result;
    }

    public static String lambdaParserLoop(String function){
        String result = "";
        parser p = new parser(function);
        try{
            result = lambdaparse(function, p);
            for(int i = 0; i <= 1000; i++){
                if(!result.contains("λ"))
                    break;

                result = lambdaparse(result, p);
            }
        }catch (Exception e){
            e.printStackTrace();
            result = p.finalResult;
        }

        return result;


    }
}
