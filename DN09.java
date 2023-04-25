import java.util.ArrayList;
interface Lik {
    int obseg();
}
class Pravokotnik implements Lik {
    private int a, b;

    public Pravokotnik(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int obseg() {
        return 2 * (a + b);
    }
}

class Kvadrat implements Lik {
    private int a;

    public Kvadrat(int a) {
        this.a = a;
    }

    @Override
    public int obseg() {
        return 4 * a;
    }
}

class NKotnik implements Lik {
    private int n, a;

    public NKotnik(int n, int a) {
        this.n = n;
        this.a = a;
    }

    @Override
    public int obseg() {
        return n * a;
    }
}
public class DN09 {

    private static ArrayList<Lik> liki = new ArrayList<>();

    public static int skupniObseg(ArrayList<Lik> liki) {
        int obseg = 0;
        for (Lik lik : liki) {
            obseg += lik.obseg();
        }
        return obseg;
    }

    public static void main(String[] args) {
        for (String arg : args) {
            String[] parts = arg.split(":");
            switch (parts[0].toLowerCase()) {
                case "kvadrat":
                    liki.add(new Kvadrat(Integer.parseInt(parts[1])));
                    break;
                case "pravokotnik":
                    liki.add(new Pravokotnik(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                    break;
                case "nkotnik":
                    liki.add(new NKotnik(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                    break;
            }
        }

        int skupniObseg = skupniObseg(liki);
        System.out.println(skupniObseg);
    }
}