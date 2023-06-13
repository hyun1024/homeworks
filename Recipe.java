import java.io.*;
import java.util.*;

public class Recipe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        System.out.println("저장하실 자료 구조를 선택해 주세요. ex)List, Set, Map");
        String setCol = br.readLine();
        switch (setCol) {
            case "List":
                ArrayList<String> listRecipe = new ArrayList<>();
                System.out.println("요리 이름을 입력해 주세요.");
                String listTitle = br.readLine();
                listTitle = "[ List로 작성된 <" + listTitle + "> 레시피 ]";
                sb.append(listTitle).append('\n');
                while (true) {
                    System.out.println("레시피를 작성해주세요.");
                    String tmp = br.readLine();
                    if (tmp.equals("끝")) {
                        break;
                    } else {
                        listRecipe.add(tmp);
                    }
                }
                sb.append('\n');
                for (int i = 1; i < listRecipe.size() + 1; i++) {
                    sb.append(i).append(". ");
                    sb.append(listRecipe.get(i-1)).append('\n');
                }
                System.out.println(sb);
                break;

            case "Set" :
                LinkedHashSet<String> setRecipe = new LinkedHashSet<>();
                System.out.println("요리 이름을 입력해 주세요.");
                String setTitle = br.readLine();
                setTitle = "[ Set으로 작성된 <" + setTitle + "> 레시피 ]";
                sb.append(setTitle).append('\n');
                while (true) {
                    System.out.println("레시피를 작성해주세요.");
                    String tmp = br.readLine();
                    if (tmp.equals("끝")) {
                        break;
                    } else {
                        setRecipe.add(tmp);
                    }
                }
                sb.append('\n');
                Iterator printer= setRecipe.iterator();
                for (int i = 1; i < setRecipe.size() + 1; i++) {
                    sb.append(i).append(". ");
                    sb.append(printer.next()).append('\n');
                }
                System.out.println(sb);
                break;

            case "Map" :
                Map<Integer, String> mapRecipe = new HashMap<>();
                int lineNumber = 1;
                System.out.println("요리 이름을 입력해 주세요.");
                String mapTitle = br.readLine();
                mapTitle = "[ Map으로 작성된 <" + mapTitle + "> 레시피 ]";
                sb.append(mapTitle).append('\n');
                while (true) {
                    System.out.println("레시피를 작성해주세요.");
                    String tmp = br.readLine();
                    if (tmp.equals("끝")) {
                        break;
                    } else {
                        mapRecipe.put(lineNumber++, tmp);
                    }
                }
                sb.append('\n');
                for (int i = 1; i < mapRecipe.size() + 1; i++) {
                    sb.append(i).append(". ");
                    sb.append(mapRecipe.get(i)).append('\n');
                }
                System.out.println(sb);

                break;

            default :
                System.out.println("작성할 수 없는 자료 구조입니다.");
                break;

        }
    }
}
