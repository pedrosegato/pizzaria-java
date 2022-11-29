public class Pizzaria {
    private int ordersQtt = 0;
    private String pizzeriaName;
    private boolean isOpen; 
    private Pizza pizzas[] = {new Pizza("Calabresa", 30), new Pizza("Mussarela", 35)}; 
    private Pedido[] orders = new Pedido[20];
    private Comanda[] cards = new Comanda[10]; 

    Pizzaria(String pizzeriaName, boolean isOpen) { 
        this.pizzeriaName = pizzeriaName;
        this.isOpen = isOpen;
    }

    public String getpizzeriaName() { 
        return this.pizzeriaName;
    }

    public boolean getisOpen() { 
        return this.isOpen;
    }

    public Pizza getpizza(int pizzaId) { 
        return this.pizzas[pizzaId];
    }

    public Pizza[] getAllPizzaArray() { 
        return this.pizzas;
    }

    public void getPizzas() { 
        for (int i = 0; i < this.pizzas.length; i++) {
            System.out.println((i+1) + " - " + this.getpizza(i).getflavourName() + "...R$" + this.getpizza(i).getprice());
        }
    }

    public Pedido getorder(int orderId) { 
        return this.orders[orderId];
    }

    public void listOrders() { 
        for (int i = 0; i < this.orders.length; i++) {
            if (!(this.orders[i] == null)) {
                System.out.println(this.orders[i].getpizza().getflavourName() + "(" + this.getorder(i).getclient().getName() + ")");
            }
        }
    }

    public int getOrdersQtt() { 
        return this.ordersQtt;
    }
    
    public void setpizzeriaName(String pizzeriaName) { 
        this.pizzeriaName = pizzeriaName;
    }

    public void setisOpen(boolean isOpen) { 
        this.isOpen = isOpen;
    }

    public void setpizzas(Pizza pizzas[]) { 
        this.pizzas = pizzas;
    }

    public void setorders(Pedido orders[]) { 
        this.orders = orders;
    }

    public void printAllOrdersFromClient(Usuario client) { 
        this.cards[client.getclientId()].printAllCard();
    }

    public Comanda getcardFromClient(int clientId) { 
        return this.cards[clientId];
    }

    public boolean registerOrder(Usuario client, int pizzaId) {
        if (!this.isOpen) { 
            System.out.println("Erro: a pizzaria está fechada.");
            return false;
        }
        if (this.ordersQtt >= this.orders.length) { 
            System.out.println("Erro: os pedidos estão congestionados.");
            return false;
        }
       
        if (this.cards[client.getclientId()] == null) { 
            this.cards[client.getclientId()] = new Comanda(client, this.getpizza(pizzaId));
        } else {
            boolean cards = this.cards[client.getclientId()].addPizzaToCard(this.getpizza(pizzaId));
            if (!cards) { 
                System.out.println("Erro: o cliente excedeu o seu limite.");
                return false;
            }
        }
        this.orders[ordersQtt] = new Pedido(client, this.pizzas[pizzaId]); 
        this.ordersQtt++;
        return true;
    }
}


