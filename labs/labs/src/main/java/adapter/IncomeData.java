package adapter;

import adapter.Solution.IIncomeData;

public class IncomeData implements IIncomeData {

    String countryCode, company, contactFirstName, contactLastName;
    int countryPhoneCode, phoneNumber;

    public IncomeData(String countryCode, String company, String contactFirstName, String contactLastName, int countryPhoneCode, int phoneNumber) {
        this.countryCode = countryCode;
        this.company = company;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;

        this.countryPhoneCode = countryPhoneCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getCountryCode() {
        return this.countryCode;
    }

    @Override
    public String getCompany() {
        return this.company;
    }

    @Override
    public String getContactFirstName() {
        return this.contactFirstName;
    }

    @Override
    public String getContactLastName() {
        return this.contactLastName;
    }

    @Override
    public int getCountryPhoneCode() {
        return countryPhoneCode;
    }

    @Override
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return this.countryCode + ", " +
        this.company  + ", " +
        this.contactFirstName  + ", " +
        this.contactLastName  + ", " +

        this.countryPhoneCode  + ", " +
        this.phoneNumber;
    }
}
