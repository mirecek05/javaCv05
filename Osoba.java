package cviceni05;

import java.util.Objects;
import java.util.Random;

public class Osoba {
    private String jmeno;
    private boolean zena;
    private int vyska;
    private final static Random RANDOM = new Random();

    public Osoba() {
        jmeno = nahodneJmeno(2,5);
        zena = RANDOM.nextBoolean();
        vyska = RANDOM.nextInt(150,201);
    }

    public static String nahodneJmeno(int minZnaku, int maxZnaku){
        int pocetZnaku = RANDOM.nextInt(minZnaku, maxZnaku + 1); //+1 protoze to generuje >= prvni parametr a <druhy parametr
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pocetZnaku; i++) {
            sb.append((char)('a' + RANDOM.nextInt(26)));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "jmeno='" + jmeno + '\'' +
                ", zena=" + zena +
                ", vyska=" + vyska +
                '}';
    }

    public String getJmeno() {
        return jmeno;
    }

    public boolean isZena() {
        return zena;
    }

    public int getVyska() {
        return vyska;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Osoba osoba)) return false;
        return zena == osoba.zena && vyska == osoba.vyska
                //&& Objects.equals(jmeno, osoba.jmeno);
                &&jmeno.equals(osoba.jmeno);
    }

}

class ExtraNevhodnaOsoba extends Osoba{
    @Override
    public int hashCode() {
        return 5;
    }
}

class NevhodnaOsoba extends Osoba{
    @Override
    public int hashCode() {
        return getVyska();
    }
}
class PrijatelnaOsoba extends Osoba{
    @Override
    public int hashCode() {
        //return isZena() == true ? getVyska() * 2 : getVyska();
        return getVyska() * (isZena() ? 2 : 1);
    }
}
class PerfektniOsoba extends Osoba{
    @Override
    public int hashCode() {
        int vysledek = this.isZena() ? 1 : 0;
        vysledek = 31 * vysledek + getVyska();
        vysledek = 31 * vysledek + getJmeno().hashCode();
        return vysledek;
    }
}
class ObjectsHashOsoba extends Osoba{
    @Override
    public int hashCode() {
        return Objects.hash(isZena(), getVyska(), getJmeno()); //nejjednodussi a nejrychlejsi
    }
}
class ObjectsHashCodeOsoba  extends Osoba{
    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }
}
