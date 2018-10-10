package com.example.shreeyanshi.authenticationexample;

public class PetInfo {

    private int Image;
    private String Category;
    private String Breed;
    private String Weight;
    private String Age;
    private String Price;

    //calling constructor to set the values

    public PetInfo(){

    }

    public PetInfo(int image, String category, String breed, String weight, String age, String price) {
        Image = image;
        Category = category;
        Breed = breed;
        Weight = weight;
        Age = age;
        Price = price;
    }

    //getter methods

    public int getImage() {
        return Image;
    }

    public String getCategory() {
        return Category;
    }

    public String getBreed() {
        return Breed;
    }

    public String getWeight() {
        return Weight;
    }

    public String getAge() {
        return Age;
    }

    public String getPrice() {
        return Price;
    }

    //setter methods

    public void setImage(int image) {
        Image = image;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public void setAge(String age) {
        Age = age;
    }

    public void setPrice(String price) {
        Price = price;
    }
}

