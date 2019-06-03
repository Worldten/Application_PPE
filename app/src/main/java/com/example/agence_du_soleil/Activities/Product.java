package com.example.agence_du_soleil.Activities;

public class Product {
    private String image;
    private String name;
    private String price;
    private String ville;
    private String address;
    private int surface;
    private int piece;
    private int charge;
    private String classe_energ;
    String cp;
    public Product(String image, String name, Double price, String ville, String address, int surface, int piece, int charge, String cp, String class_energ) {
        this.image = image;
        this.name = name;
        this.price = Double.toString(price);
        this.ville = ville;
        this.address = address;
        this.surface = surface;
        this.piece = piece;
        this.charge = charge;
        this.cp = cp;
        this.classe_energ = class_energ;

    }

    public String getImage() {
        return image;
    }

    public String getClasse()
    {
        return classe_energ;
    }

    public String getCouleur(String charactere){
        String color;
        switch (charactere)
        {
            case "G":
                color = "#ff0000";
                break;
            case "F":
                color = "#ff8000";
                break;
            case "E":
                color = "#ffb900";
                break;
            case "D":
                color = "#ffe400";
                break;
            case "C":
                color = "#f7ff00";
                break;
            case "B":
                color = "#c9ff00";
                break;
            case "A":
                color = "#80ff00";
                break;
                default:
                    color = "#000";
                    break;

        }
        return color;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}