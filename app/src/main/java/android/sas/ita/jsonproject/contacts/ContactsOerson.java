package android.sas.ita.jsonproject.contacts;

/**
 * Created by sasmob on 12/13/2017.
 */

public class ContactsOerson {



    private String name;
    private String id;
    private String email;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_mobile() {
        return phone_mobile;
    }

    public void setPhone_mobile(String phone_mobile) {
        this.phone_mobile = phone_mobile;
    }

    public String getPhone_home() {
        return phone_home;
    }

    public void setPhone_home(String phone_home) {
        this.phone_home = phone_home;
    }

    public String getPhone_office() {
        return phone_office;
    }

    public void setPhone_office(String phone_office) {
        this.phone_office = phone_office;
    }

    private String gender;
    private String phone_mobile;
    private String phone_home;
    private String phone_office;
}
