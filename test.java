import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] products = new String[n];
        for (int i = 0; i < n; i++) {
            products[i] = sc.next();
        }
        String searchWord = sc.next();
        List<List<String>> ans = suggestProducts(products, searchWord);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> suggestProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        int left = 0, right = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> res = new ArrayList<>();
            char c = searchWord.charAt(i);
            while (left <= right && (products[left].length() == i || products[left].charAt(i) < c))
                left++;
            while (left <= right && (products[right].length() == i || products[right].charAt(i) > c))
                right--;
            for (int j = 0; j < 3 && left + j <= right; j++)
                res.add(products[left + j]);
            ans.add(res);
        }
        return ans;
    }
}