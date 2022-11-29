public class Pizza {
    private String flavourName; 
    private double price; 

    Pizza(String flavourName, double price) { 
        this.flavourName = flavourName;
        this.price = price;
    }

    public String getflavourName() { 
        return this.flavourName;
    }

    public double getprice() { 
        return this.price;
    }

    public void setflavourName(String flavourName) { 
        this.flavourName = flavourName;
    }

    public void setprice(double price) { 
        this.price = price;
    }
}

