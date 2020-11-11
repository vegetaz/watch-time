package com.watchstore.vvbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "product")
public class Product {
    @Id
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "image")
    private String image;
    @Field(name = "listCategory")
    private Object listCategory;
    @Field(name = "style")
    private Object style;
    @Field(name = "description")
    private String description;

    public Product() {
    }

    public Product(String id, String name, String image, Object listCategory, Object style, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.listCategory = listCategory;
        this.style = style;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getListCategory() {
        return listCategory;
    }

    public void setListCategory(Object listCategory) {
        this.listCategory = listCategory;
    }

    public Object getStyle() {
        return style;
    }

    public void setStyle(Object style) {
        this.style = style;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", listCategory=" + listCategory +
                ", style=" + style +
                ", description='" + description + '\'' +
                '}';
    }
}
