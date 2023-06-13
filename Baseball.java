import java.util.*;
import java.io.*;
public class Baseball {
    public static void main(String[] args) throws IOException {
        int [] targetNum = ran();
        int count=10;
        int tr=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(count>0) {
            System.out.println("세 자리 숫자를 한 칸씩 띄워서 입력하세요. 남은 기회 "+count+"번");
            try{
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                if (st.countTokens() != 3) {
                    throw new NoSuchElementException(); // 토큰 개수가 3이 아닌 경우 예외 발생
                }
                int a, b, c;

                try {
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    c = Integer.parseInt(st.nextToken());
                    if(a>9||b>9||c>9){
                        throw new NumberFormatException(); // 입력 중 두 자리 이상의 숫자인 경우 예외 발생
                    }
                } catch (NumberFormatException e) {
                    throw new NumberFormatException(); // 정수로 변환할 수 없는 토큰이 있는 경우 예외 발생
                }
            int strike=0;
            int ball=0;
            tr+=1;
            if(a==targetNum[0]){
                strike++;
            } else if(a==targetNum[1] || a==targetNum[2]){
                ball++;
            }
            if(b==targetNum[1]){
                strike++;
            } else if(b==targetNum[0] || b==targetNum[2]){
                ball++;
            }
            if(c==targetNum[2]){
                strike++;
            } else if(c==targetNum[0] || c==targetNum[1]){
                ball++;
            }
            if(strike==3){
                System.out.println("정답입니다! 총 시도 횟수 : "+ tr + "번");
                count=0;
            } else if(count==1 && strike != 3 ){
                System.out.println("아쉽게도 기회를 모두 소진하셨습니다");
                System.exit(0);
            }
            else {
                System.out.println(strike + "S " + ball + "B");
            }
            count--;
            } catch (NoSuchElementException e) {
                System.out.println("입력 값이 올바르지 않습니다. 세 자리 숫자를 한 칸씩 띄워서 입력하세요.");
            } catch (NumberFormatException e) {
                System.out.println("입력 값이 올바르지 않습니다. 세 자리 숫자를 입력하세요.");
            } catch(IOException e){
                System.out.println("입력 중 오류가 발생했습니다. 다시 입력해주세요.");
            }
        }
        try{
            br.close();
        } catch (IOException e) {
            System.out.println("입력 스트림을 닫는 도중 오류가 발생하였습니다.");
        }
    }

    public static int[] ran() {
        Random ran = new Random();
        int tmp = ran.nextInt(10);
        int[] targetNum = {tmp, -1, -1};
        tmp = ran.nextInt(10);
        while (targetNum[0] == tmp) {
            tmp = ran.nextInt(10);
        }
        targetNum[1] = tmp;
        tmp = ran.nextInt(10);
        while (targetNum[0] == tmp || targetNum[1] == tmp) {
            tmp = ran.nextInt(10);
        }
        targetNum[2] = tmp;
        return targetNum;
    }
}

