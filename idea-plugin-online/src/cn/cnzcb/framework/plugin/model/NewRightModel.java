package cn.cnzcb.framework.plugin.model;

public class NewRightModel {

    /**
     * 类名
     */
    private  String id;

    /**
     * 所选择的类的类型
     */
    private  String classType;

    private String longname;

    private String packagePath;

    /**
     * 创建java类所在的包
     */
    private  String  selectedPackage;


    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getSelectedPackage() {
        return selectedPackage;
    }

    public void setSelectedPackage(String selectedPackage) {
        this.selectedPackage = selectedPackage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }
}
