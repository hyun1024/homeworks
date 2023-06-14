import java.io.*;
import java.util.*;
public class Baseball2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("맞추실 숫자의 자릿수를 선택해주세요. ex) 3 or 4");
            int corNum;
            try {
                corNum = Integer.parseInt(br.readLine());
                if(corNum != 3 && corNum != 4) {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                System.out.println("입력 값이 올바르지 않습니다. 숫자를 입력하세요.");
                continue;  // 다시 입력 받기 위해 continue 문 사용
            } catch (IllegalArgumentException e) {
                System.out.println("입력 값이 올바르지 않습니다. 3 또는 4를 입력하세요.");
                continue;  // 다시 입력 받기 위해 continue 문 사용
            }
            int[] targetNum = ran(corNum);
            int count, lvNum;
            String levelText;
            while(true) {
                System.out.println("난이도를 선택해 주세요. ex) Easy, Normal, Hard");
                levelText = br.readLine();
                switch (levelText.toLowerCase()) {
                    case "easy":
                        lvNum = 10;
                        count = lvNum;
                        break;
                    case "normal":
                        lvNum = 7;
                        count = lvNum;
                        break;
                    case "hard":
                        lvNum = 5;
                        count = lvNum;
                        break;
                    default:
                        System.out.println("유효하지 않은 난이도입니다. Easy, Normal, Hard 중 하나를 입력해주세요.");
                        continue;
                }

                break;
            }
            int tr = 0;
            int strike, ball;
            while (count > 0) {
                System.out.println(corNum+ "자리 숫자를 한 칸씩 띄워서 입력하세요. 남은 기회 " + count + "번");
                try {
                    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                    if (st.countTokens() != corNum) {
                        throw new NoSuchElementException(); // 토큰 개수가 다를 경우 예외 발생
                    }
                    int tmp;
                    strike = ball = 0;
                    tr += 1;
                    for (int i = 0; i < corNum; i++) {
                        tmp = Integer.parseInt(st.nextToken());
                        if (tmp > 9) {
                            throw new NumberFormatException(); // 입력 중 두 자리 이상의 숫자인 경우 예외 발생
                        }
                        if (targetNum[i] == tmp) {
                            strike++;
                        } else if (contains(targetNum, tmp)) {
                            ball++;
                        }
                    }

                    if (strike == corNum) {
                        System.out.println("정답입니다! 총 시도 횟수 : " + tr + "번");
                        count = 0;
                        break;
                    } else if (count == 1 && strike != corNum) {
                        System.out.println("아쉽게도 기회를 모두 소진하셨습니다");
                        break;
                    } else {
                        System.out.println(strike + "S " + ball + "B");
                        count--;
                    }

                } catch (NoSuchElementException e) {
                    System.out.println("입력 값이 올바르지 않습니다. "+corNum+ "자리 숫자를 한 칸씩 띄워서 입력하세요.");
                } catch (NumberFormatException e) {
                    System.out.println("입력 값이 올바르지 않습니다.  "+corNum+"자리 숫자를 입력하세요.");
                } catch (IOException e) {
                    System.out.println("입력 중 오류가 발생했습니다. 다시 입력해주세요.");
                }
            }
            System.out.println("한 번 더 하시려면 아무 값이나 입력해주세요."+"\n"+"종료를 원하시면 exit를 입력해주세요.");

            String reStart=br.readLine();
            if(reStart.equalsIgnoreCase("exit")){
                break;
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            System.out.println("입력 스트림을 닫는 도중 오류가 발생하였습니다.");
        }
    }
    public static int[] ran (int corNum){
        Random ran = new Random();
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numList.add(i);
        }
        int[] targetNum = new int[corNum];
        for (int i = 0; i < targetNum.length; i++) {
            int n = ran.nextInt(numList.size());
            targetNum[i] = numList.get(n);
            numList.remove(n);
        }
        return targetNum;
    }
    public static boolean contains(int[] array, int number) {
        for (int num : array) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }
}