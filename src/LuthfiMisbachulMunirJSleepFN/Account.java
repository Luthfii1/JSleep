package LuthfiMisbachulMunirJSleepFN;

public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;

    public Object write(){
        return null;
    }

    public boolean read (String a){
        return true;
    }
    
    public Account(int id, String name, String email, String password)
    {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString(){
        return  "\nid Pelanggan : " + id + "\nNama : " + this.name + "\nEmail : " + this.email +
                "\nPassword : " + this.password;
    }
}
