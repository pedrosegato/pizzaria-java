public class Usuario {
    private int clientId;
    private String name; 
    private boolean isManager; 

    Usuario(int clientId, String name, boolean isManager) {
        this.clientId = clientId;
        this.name = name;
        this.isManager = isManager;
    }
    
    public String getName() { 
        return this.name;
    }

    public boolean getisManager() { 
        return this.isManager;
    }

    public int getclientId() { 
        return this.clientId;
    }

    public void setName(String name) { 
        this.name = name;
    }

    public void setisManager(boolean isManager) { 
        this.isManager = isManager;
    }

    public void setclientId(int clientId) { 
        this.clientId = clientId;
    }

    public boolean makeOrder(Pizzaria pizzeria, int pizzaId) { 
        boolean orderRegistered = pizzeria.registerOrder(this, pizzaId); 
        if (!orderRegistered) { 
            return false;
        }
        return true;  
    }
}


