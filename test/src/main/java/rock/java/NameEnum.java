package rock.java;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-02-28 14:09
 */
public enum  NameEnum {
    LIZHIHUA("lizhihua","李志华"),
    YJJ("yjj","袁佳佳");

    private String code;
    private String name;
    private NameEnum(String code,String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
