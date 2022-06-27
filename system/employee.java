package system;

public class employee extends person {
    private String num, tel, part,job;
    public employee(String name, String gender, String id, int year, int month, int day, String num, String tel, String job, String part) {
        super(name, gender, id, year, month, day);
        this.num = num;
        this.tel = tel;
        switch (job) {
            case "助教":
                this.job = "助教";
                break;
            case "讲师":
                this.job = "讲师";
                break;
            case "副教授":
                this.job = "副教授";
                break;
            case "教授":
                this.job = "教授";
                break;
        }
            this.part = part;

    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {

        switch (job) {
            case "助教":
                this.job = "助教";
                break;
            case "讲师":
                this.job = "讲师";
                break;
            case "副教授":
                this.job = "副教授";
                break;
            case "教授":
                this.job = "教授";
                break;
        }
    }

}

