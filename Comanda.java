public class Comanda {
    private Usuario client;
    private Pizza[] pizzas = new Pizza[10];
    private double totalPrice;
    private int pizzasQtt = 0;

    Comanda(Usuario client, Pizza pizza) {
        this.client = client;
        this.addPizzaToCard(pizza);
    }
    
    public Usuario getclient() { 
        return this.client;
    }

    public Pizza[] getpizzas() { 
        return this.pizzas;
    }

    public double gettotalPrice() { 
        return this.totalPrice;
    }

    public int getpizzasQtt() {
        return this.pizzasQtt;
    }

    public void setclient(Usuario client) { 
        this.client = client;
    }

    public void setpizzas(Pizza[] pizzas) { 
        this.pizzas = pizzas;
    }

    public void settotalPrice(double totalPrice) { 
        this.totalPrice = totalPrice;
    }

    public boolean addPizzaToCard(Pizza pizza) { 
        if (this.pizzasQtt >= this.pizzas.length) {
            System.out.println(this.client.getName() + " excedeu o limite máximo de pizzas pedidas.");
            return false;
        } else {
            this.pizzas[this.pizzasQtt] = pizza;
            this.pizzasQtt++;
            return true;
        }
    }

    public double setupTotalPrice() { 
        this.totalPrice = 0;
        for (int i = 0; i < this.pizzas.length; i++) {
            if (!(this.pizzas[i] == null)) { 
                this.totalPrice += this.pizzas[i].getprice();
            }
        }
        return this.totalPrice;
    }

    public void printAllCard() {
        System.out.println("------ Comanda ------");
        System.out.println("Cliente: " + this.client.getName() + "\n");
        for (int i = 0; i < this.pizzas.length; i++) {
            if (!(this.pizzas[i] == null)) { 
                System.out.println(this.pizzas[i].getflavourName() + "..." + this.pizzas[i].getprice());
            }
        }
        this.setupTotalPrice();
        this.pizzasQtt = 0;
        System.out.println("\nTotal: R$" + this.totalPrice);
    }
}


