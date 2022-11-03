import java.util.Objects;

public class Campo {
    private char simbolo;

    public Campo() {
        this.simbolo = ' '; //inicia com vazio
    }

    //getters & setters
    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        if (this.simbolo == ' ') {
            this.simbolo = simbolo;
        } else {
            System.out.println("Campo já usado!");
        }
    }

    @Override
    public String toString() {
        return "Campo{" +
                "simbolo=" + simbolo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campo)) return false;
        Campo campo = (Campo) o;
        return simbolo == campo.simbolo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(simbolo);
    }
}
