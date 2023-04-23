public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    private  int id_city;
    private City city;

    public Employee() {
        this.id = id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.gender=gender;
        this.age=age;
        this.city=city;
        this.id_city=id_city;
    }

    //    public Employee(int id,String first_name,String last_name,String gender,int age,City city){
    public Employee(int id,String first_name,String last_name,String gender,int age,int id_city){
        this.id = id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.gender=gender;
        this.age=age;
        this.city=city;
        this.id_city=id_city;

    }

    public int getId(){
        return id;
    }
    public void SetId(int id){
        this.id = id;
    }
    public String getFirst_name(){
        return first_name;
    }
    public void setFirst_name(String first_name){
        this.first_name=first_name;
    }
    public String getLast_name(){
        return last_name;
    }
    public void setLast_name(String last_name){
        this.last_name=last_name;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", id_city=" + id_city +
                ", city=" + city +
                "}\n";
    }
}
