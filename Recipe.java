import java.io.*;
public class Recipe {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String title = br.readLine();
        sb.append(title).append('\n');
        float star = Float.parseFloat(br.readLine());
        int rate = (int)star;
        sb.append(rate).append('(');
        double pers = rate * 20;
        sb.append(pers).append('%');
        sb.append(')').append('\n');
        String tmp;
        for(int i=1; i<=10; i++){
            tmp = br.readLine();
            sb.append(i).append('.');
            sb.append(tmp).append('\n');
        }
        System.out.println(sb);
    }
}
