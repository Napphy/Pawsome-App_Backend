package com.rijai.users.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name="dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String breed;
    private String sex;
    private String size;
    private String description;
    private Date birthday;

    @Lob
    @Column(columnDefinition = "LONG BLOB")
    private String image;

    public Dog() {
    }

    public Dog(int id, String name, int age, String breed, String sex, String size, String description, Date birthday, String image) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.sex = sex;
        this.size = size;
        this.description = description;
        this.birthday = birthday;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return id == dog.id && age == dog.age && Objects.equals(name, dog.name) && Objects.equals(breed, dog.breed) && Objects.equals(sex, dog.sex) && Objects.equals(size, dog.size) && Objects.equals(description, dog.description) && Objects.equals(birthday, dog.birthday) && Objects.equals(image, dog.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, breed, sex, size, description, birthday, image);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", sex='" + sex + '\'' +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                ", birthday=" + birthday +
                ", image='" + image + '\'' +
                '}';
    }
}
