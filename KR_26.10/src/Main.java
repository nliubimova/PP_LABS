import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.Comparator;
import java.util.ArrayList;

class Hotel {
    String Hotel_Name;
    String Stadt;
    int Stern;

    Hotel(){
        Hotel_Name = null;
        Stadt = null;
        Stern = 0;
    }
    Hotel(String Hotel_Name, String Stadt,int Stern){
        this.Hotel_Name = Hotel_Name;
        this.Stadt = Stadt;
        this.Stern = Stern;
    }

    public void setHotel_name(String Hotel_Name) {
        this.Hotel_Name = Hotel_Name;
    }
    public String getHotel_name() {
        return Hotel_Name;
    }

    public void setStadt(String Stadt) {
        this.Stadt = Stadt;
    }
    public String getStadt() {
        return Stadt;
    }

    public void setStern(int Stern) {
        this.Stern = Stern;
    }
    public int getStern() {
        return Stern;
    }

    public void classReader(Scanner in, FileReader fr) throws Exception{
        String line = in.nextLine();
        String [] words  = line.split(" ");
        setStadt(words[0]);
        setHotel_name(words[1]) ;
        setStern(Integer.parseInt(words[2]));
    }

    public void writeHotelName(Scanner in, FileWriter fw ) throws Exception {
        fw.write("Der HotelName ist " + getHotel_name());
    }

    public void writeStadt(Scanner in, FileWriter fw ) throws Exception {
        fw.write("Der Stadt ist " + getStadt());
    }

    public void writeStern(Scanner in, FileWriter fw ) throws Exception {
        fw.write("Der Stern ist " + getStern());
    }

    public void write_HotelName(Scanner in, FileWriter fw ) throws Exception {
        fw.write(getHotel_name());
    }

    public void write_Stadt(Scanner in, FileWriter fw ) throws Exception {
        fw.write(getStadt());
    }

    public void write_Stern(Scanner in, FileWriter fw ) throws Exception {
        fw.write(getStern());
    }

    public void classWriter(Scanner in, FileWriter fw) throws Exception {
        fw.write("Der Stadt ist " + getStadt()+ " ");
        fw.write(" Der HotelName ist " + getHotel_name() + " ");
        fw.write("Die Stern ist " + getStern()+ '\n');

    }


}
class CompStadt implements Comparator<Hotel> {
    public int compare(Hotel eins, Hotel zwei){
        return eins.getStadt().compareTo(zwei.getStadt());
    }
}

class CompStern implements Comparator<Hotel> {
    public int compare (Hotel eins, Hotel zwei){
        if(eins.getStern() < zwei.getStern())
            return 1;
        else if(eins.getStern() > zwei.getStern())
            return -1;
        else
            return 0;
    }
}





public class Main {

    public static void Reader(Scanner in, FileReader fr, int numHotels, ArrayList<Hotel> hotels) throws Exception {
        for(int i =0; i < numHotels; i++){
            Hotel hotel = new Hotel();
            hotel.classReader(in,fr);
            hotels.add(hotel);
        }
    }

    public static void Writer(Scanner in, FileWriter fw, int numHotels, ArrayList<Hotel> hotels) throws Exception {
        for(int i =0; i<numHotels; i++){
            hotels.get(i).classWriter(in, fw);
        }
    }

    public static void Write_Task2(Scanner in, FileWriter fw, int numHotels, String city, ArrayList<Hotel> hotels) throws Exception{
        fw.write("Die Hotels in der Stadt: " + '\n');
        for(int i=0; i < numHotels; i++){
            if(Objects.equals(city, hotels.get(i).getStadt())){
                hotels.get(i).write_HotelName(in, fw);
                fw.write(' ');
                hotels.get(i).write_Stern(in,fw);
                fw.write('\n');
            }
        }
    }

    public static void Write_Task3(Scanner in, FileWriter fw, int numHotels, String hotel_name, ArrayList<Hotel> hotels) throws Exception{
        fw.write("Das Hotel lediegt in "+ '\n');
        for(int i =0; i < numHotels; i++){
            if(Objects.equals(hotel_name, hotels.get(i).getHotel_name())){
                hotels.get(i).write_Stadt(in,fw);
                fw.write('\n');
            }
        }
    }

    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("input.txt");
        FileWriter fw = new FileWriter("output.txt");
        Scanner in = new Scanner(fr);
        int numHotels = Integer.parseInt(in.nextLine());
        ArrayList<Hotel> hotels = new ArrayList<>(numHotels);
        Reader(in,fr,numHotels, hotels);
        Collections.sort(hotels, new CompStadt().thenComparing(new CompStern()));
        Writer(in,fw,numHotels, hotels);
        String desiredStadt = new String();
        desiredStadt = in.nextLine();
        Write_Task2(in, fw, numHotels, desiredStadt, hotels);
        String desiredHotel = new String();
        desiredHotel = in.nextLine();
        Write_Task3(in, fw, numHotels, desiredHotel, hotels);

        fr.close();
        fw.close();
    }
}