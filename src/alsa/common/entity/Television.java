package alsa.common.entity;

public class Television extends Product{
    public Television(int id, String name, double price, int count) {
        super(id, name, price, count);
    }

    @Override
    public Product withDecreasedCount() {
        return new Television(id, name, price, count-1);
    }

    @Override
    public Product withIncreasedCount() {
        return new Television(id, name, price, count+1);
    }

    @Override
    public boolean hasSpecialGuarantee() {
        return false;
    }

    @Override
    public String toString() {
        return "Television{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
