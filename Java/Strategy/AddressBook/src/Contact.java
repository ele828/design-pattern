/**
 * Created by Eric on 15/10/27.
 */
public class Contact {

    private String givenName;
    private String familyName;
    private String phoneNumber;
    private String organisation;

    public Contact(String givenName, String familyName, String phoneNumber, String organisation) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.phoneNumber = phoneNumber;
        this.organisation = organisation;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    @Override
    public String toString() {
        return "["
                +  this.givenName + "  "
                +  this.familyName + "  "
                +  this.phoneNumber + "  "
                +  this.organisation + "  "
                + "]";
    }
}
