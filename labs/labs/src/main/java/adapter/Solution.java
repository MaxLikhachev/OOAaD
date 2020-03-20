package adapter;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    public static void main(String[] args) {
        initCountries();
        IncomeData incomeData = new IncomeData("UA", "JavaRush Ltd.", "Ivan", "Ivanov", 38, 501234567);
        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(incomeData);

        Customer customer = new Customer(incomeDataAdapter.getCompanyName(), incomeDataAdapter.getCountryName());
        Contact contact = new Contact(incomeDataAdapter.getName(), incomeDataAdapter.getPhoneNumber());

        System.out.println("Income data: " + incomeData);
        System.out.println("Customer: " + customer);
        System.out.println("Contact: " + contact);
    }

    private static void initCountries() {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static class IncomeDataAdapter implements ICustomer, IContact {

        IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }

        @Override
        public String getName() {
            return this.incomeData.getContactLastName() + ", " + this.incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() { 
            String phoneNumber = "" + incomeData.getPhoneNumber();
            
            for (int i = phoneNumber.length(); i < 10; i++)
                phoneNumber = "0" + phoneNumber;

            return "+" + incomeData.getCountryPhoneCode() + "(" + phoneNumber.substring(0, 3) + ")"  + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 8) + "-" + phoneNumber.substring(8, 10);
        }

        @Override
        public String getCompanyName() {
            return this.incomeData.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.incomeData.getCountryCode());
        }

    }

    public static interface IIncomeData {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        int getCountryPhoneCode();      //For example: 38
        int getPhoneNumber();           //For example: 501234567
    }

    public static interface ICustomer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface IContact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}

