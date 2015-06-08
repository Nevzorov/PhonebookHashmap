package nevzorov.com;

import java.util.HashMap;

public class Card {
    private int mnumb;
    private int hnumb;
    private String email;
    private String skype;

    public Card(int mnumb, int hnumb, String email, String skype) {
        this.mnumb = mnumb;
        this.hnumb = hnumb;
        this.email = email;
        this.skype = skype;
    }

    public int getMnumb() {
        return mnumb;
    }

    public void setMnumb(int mnumb) {
        this.mnumb = mnumb;
    }

    public int getHnumb() {
        return hnumb;
    }

    public void setHnumb(int hnumb) {
        this.hnumb = hnumb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }
}
