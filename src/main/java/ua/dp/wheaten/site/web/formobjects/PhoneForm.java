package ua.dp.wheaten.site.web.formobjects;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 31.08.15
 * Time: 18:07
 * To change this template use File | Settings | File Templates.
 */
public class PhoneForm {

    private String code;

    private String number;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneForm{" +
                "code='" + code + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
