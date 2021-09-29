import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mult {
    private String expression;

    public Mult() {
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void readLineFromFile() {
        try (BufferedReader fr = new BufferedReader(new FileReader("C:\\Users\\Elizaveta\\OneDrive\\Документы\\SPgit18\\produce_without_using_mult/expression.txt"))) {
            expression = fr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double mult() {
        double log = 0;
        String[] numbers = expression.split("\\*");
        for (String num : numbers) {
            log += Math.log10(Integer.parseInt(num));
        }
        Double m = Math.pow(10, log);
        return m;
    }
}
