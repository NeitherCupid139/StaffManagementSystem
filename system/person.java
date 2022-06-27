package system;

public class person extends date{
    private String name,gender,id;
    public person(String name,String gender,String id,int year,int month,int day){
        super(year, month, day);
        this.name = name;
        this.gender = gender;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
