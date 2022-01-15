package chapter1.point3;

public class Person {
    private Phone homePhone;
    private Phone officePhone;

    // 집번호
    public Phone getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(Phone homePhone) {
        this.homePhone = homePhone;
    }

    // 사무실 번호
    public Phone getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(Phone officePhone) {
        this.officePhone = officePhone;
    }
}
