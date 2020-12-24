public class TestClass {
    public static void main(String[] args) {
        InterfaceFactory factory = new CarFactory();
        InterfaceFactory pizza = new Pizza();

        MyProxy proxy = new MyProxy(factory);
        InterfaceFactory proxyInstance = (InterfaceFactory) proxy.getProxy();

        proxyInstance.make();

        proxy = new MyProxy(pizza);
        InterfaceFactory pizzaFactory = (InterfaceFactory) proxy.getProxy();
        pizzaFactory.make();
    }
}
