
import java.util.Scanner;
public abstract class main {
    static Usuario[] clients = {new Usuario(1, "John Doe", false), new Usuario(2, "Jane Doe", false), new Usuario(3, "Manager", true), new Usuario(4, "Sergio", false)};
    static Pizzaria pizzaria = new Pizzaria("Pizzaria Italiana", true);
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean finished = false; 
        welcomeMessage();
        listClients();
        while (!finished) { 
            System.out.print("> ");
            int clientChosen = sc.nextInt(); 
            if (clientChosen != 0) { 
                if (!(clientChosen > clients.length) && clientChosen > 0) {
                    manage(--clientChosen); 
                }
            } else {
                finished = true;
            }
        }
        System.out.println("O programa foi finalizado.");
    }

    public static void listClients() { 
        System.out.println("------ Clientes ------");
        for (int i = 0; i < clients.length; i++) {
            System.out.println((i+1) + " - " + clients[i].getName());
        }
        System.out.println("Escolha um cliente para gerenciar.");
    }

    public static void manage(int clientId) {
        boolean chose = false;
        Usuario client = clients[clientId];
        boolean isManager = client.getisManager();
        boolean hasAnyOrder = false;
        String clientName = client.getName();

        System.out.println("O que " + clientName + " irá fazer?");
        System.out.println("1 - Pedir pizza");
        if (!(pizzaria.getcardFromClient(client.getclientId()) == null || pizzaria.getcardFromClient(client.getclientId()).getpizzasQtt() == 0)) {
            hasAnyOrder = true;
        }
        if (hasAnyOrder) {
            System.out.println("2 - Fechar a conta (" + pizzaria.getcardFromClient(client.getclientId()).setupTotalPrice() + ")");
        }
        if (isManager) {
            System.out.println("3 - Listar todos os pedidos");
        }

        System.out.print("> ");
        int option = sc.nextInt();

        switch(option) {
            case 1:
                System.out.println("Que pizza " + clientName + " irá pedir?");
                pizzaria.getPizzas();
                while (!chose) {
                    System.out.print("> ");
                    int pizzaId = sc.nextInt();
                    if (!(pizzaId > pizzaria.getAllPizzaArray().length) || !(pizzaId < 0)) {
                        client.makeOrder(pizzaria, --pizzaId); 
                        chose = true;
                    }
                }
                break;
            case 2:
                if (hasAnyOrder) { 
                    pizzaria.printAllOrdersFromClient(client);
                    pizzaria.getcardFromClient(client.getclientId()).setpizzas(new Pizza[10]);
                    System.out.println(client.getName() + " pagou a conta!"); 
                }
            case 3:
                if (isManager) { 
                    System.out.println("------ Pedidos ------");
                    pizzaria.listOrders();
                    break;
                }
        }
        welcomeMessage();
        listClients();
    }

    public static void welcomeMessage() {
        if (pizzaria.getisOpen()) {
            System.out.println(pizzaria.getpizzeriaName() + " está aberta!");
        } else {
            System.out.println(pizzaria.getpizzeriaName() + " está fechada! Mas mesmo assim você pode tentar pedir para testar as funcionalidades do programa.");
        }
        System.out.println("------ Cardápio ------");
        pizzaria.getPizzas();
    }
}

