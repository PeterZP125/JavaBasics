package _01_抽象类;

public abstract class Graph {
    private Integer length;
    private Integer width;

    public abstract Integer getDimension(Integer length, Integer width);

    public static void main(String[] args) {
        new Graph() {
            @Override
            public Integer getDimension(Integer length, Integer width) {
                return length * width;
            }
        };
    }
}
