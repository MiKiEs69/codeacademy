package org.example;

import org.example.Adress.Country;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Property implements Serializable {
    private transient Adress adress;
    private transient Person owner;
    private String type;

    public Property() {
    }

    public Property(Adress adress, Person owner, String type) {
        this.adress = adress;
        this.owner = owner;
        this.type = type;
    }

    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();
            oos.writeObject(this.adress.getHomeAdress());
            oos.writeObject(this.adress.getCountry());
            oos.writeObject(this.adress.getPostCode());
            oos.writeObject(this.owner.getFirstName());
            oos.writeObject(this.owner.getLastName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readObject(ObjectInputStream ois) {
        try {
            ois.defaultReadObject();
            String homeAdress = (String) ois.readObject();
            Country country = (Country) ois.readObject();
            String postCode = (String) ois.readObject();
            String ownerFirstName = (String) ois.readObject();
            String ownerLastName = (String) ois.readObject();
            this.adress = new Adress(homeAdress,country,postCode);
            this.owner = new Person(ownerFirstName,ownerLastName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Property{" +
                "adress=" + adress +
                ", owner=" + owner +
                ", type='" + type + '\'' +
                '}';
    }
}
