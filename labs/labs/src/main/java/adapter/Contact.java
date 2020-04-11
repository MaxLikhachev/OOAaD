package adapter;

import adapter.App.IContact;

public class Contact implements IContact {

    String name, phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String toString() {
        return this.name + ", " + this.phoneNumber;
    }
}
