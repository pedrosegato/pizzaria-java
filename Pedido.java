public class Pedido {
    private Usuario client;
    private Pizza pizza;

    Pedido(Usuario client, Pizza pizza) { 
        this.client = client;
        this.pizza = pizza;
    }

    public Usuario getclient() { 
        return this.client;
    }

    public Pizza getpizza() { 
        return this.pizza;
    }

    public void setclient(Usuario client) { 
        this.client = client;
    }

    public void setpizza(Pizza pizza) { 
        this.pizza = pizza;
    }
}


