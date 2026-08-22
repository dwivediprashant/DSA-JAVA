import java.util.*;

public class WinTheHero {
    public static int minVillainRemoveToHeroWin(int[] v, int m, int h) {
        int totalHeroHealth = m * h;
        int removedVillain = 0;
        int currHeroHealth = h;
        for (int i = 0; i < v.length;) {
            if (currHeroHealth > v[i]) {
                currHeroHealth -= v[i];// villain defeated
                i++;
            } else if (currHeroHealth < v[i]) {
                m--;// current hero dead
                if (m > 0) {
                    currHeroHealth = h;// move to next hero
                } else {
                    // no hero remained so remianed vilaain should be removed for hero survival
                    removedVillain = v.length - i;
                    break;
                }
            } else {
                currHeroHealth -= v[i];
                i++;
            }
        }
        return removedVillain;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// no of villains
        int m = sc.nextInt();// no of heros
        int h = sc.nextInt();// hero health
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            v[i] = x;
        }

        System.out.println(minVillainRemoveToHeroWin(v, m, h));
    }
}
