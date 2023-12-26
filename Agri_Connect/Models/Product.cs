using Microsoft.AspNetCore.Identity;

namespace Product;

public class Product{

    public int Pid{get;set;}
    public string Pname{get;set;}
    public int quantity{get;set;}
    public double price{get;set;}
    public string image{get;set;}


    public Product(int id, string name, int quantity, double price, string image){
        this.Pid = id;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.Pname = name;
    }
    
}