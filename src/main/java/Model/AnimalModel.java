/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.ImageIcon;

public class AnimalModel {
    private String name;
    private String information;
    private int level;
    private String foodType;
    private String animalGroup;
    private String scientificName;
    private ImageIcon icon;  // Icon atau gambar untuk setiap hewan.

    public AnimalModel(String name, String information, int level, String foodType, String animalGroup, String scientificName, ImageIcon icon) {
        this.name = name;
        this.information = information;
        this.level = level;
        this.foodType = foodType;
        this.animalGroup = animalGroup;
        this.scientificName = scientificName;
        this.icon = icon;
    }

    // Getter dan setter untuk semua atribut.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getAnimalGroup() {
        return animalGroup;
    }

    public void setAnimalGroup(String animalGroup) {
        this.animalGroup = animalGroup;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}


