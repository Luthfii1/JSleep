package LuthfiMisbachulMunirJSleepFN;

/**
 * @author Luthfi Misbachul Munir
 * @version 29 September 2022
 */

public class Room extends Serializable implements FileParser
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    
    @Override
    public Object write(){
        return null;
    }
    
    @Override
    public boolean read (String a){
        return true;
    }

    public Room(int id, String name, int size, Price price, 
                Facility facility, City city, String address)
    {
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.bedType = bedType.SINGLE;
    }
    
    public String toString(){
        return  "\nid Pelanggan : " + id + "\nNama : " + this.name + "\nSize : " + this.size + 
                "\nHarga : " + this.price + "\nFasilitas : " + this.facility + "\nKota : " + 
                this.city + "\nAlamat : " + this.address;
    }
}
