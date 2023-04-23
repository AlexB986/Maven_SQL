public class City {
    private int id;
    private String name_city;

    public City() {
        this.id = id;
        this.name_city=name_city;
    }

    public City(int id,String name_city){
        this.id = id;
        this.name_city=name_city;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName_city(){
        return name_city;
    }
    public void setName_city(String name_city){
        this.name_city=name_city;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name_city='" + name_city + '\'' +
                '}';
    }
}
