package cn.cnzcb.framework.plugin.model;

public class NewRightContext {

    /**
     * 类名
     */
    private static String id;

    /**
     * 所选择的类的类型
     */
    private static String classType;

    /**
     * 创建java类所在的包
     */
    private static String  selectedPackage;

    private static String longname;

    private static String packagePath;


    public static String getClassType() {
        return classType;
    }

    public static void setClassType(String classType) {
        NewRightContext.classType = classType;
    }


    public static String getSelectedPackage() {
        return selectedPackage;
    }

    public static void setSelectedPackage(String selectedPackage) {
        NewRightContext.selectedPackage = selectedPackage;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        NewRightContext.id = id;
    }

    public static String getLongname() {
        return longname;
    }

    public static void setLongname(String longname) {
        NewRightContext.longname = longname;
    }

    public static String getPackagePath() {
        return packagePath;
    }

    public static void setPackagePath(String packagePath) {
        NewRightContext.packagePath = packagePath;
    }

    public static void clearAllSet() {
        classType = null;
        id = null;
        selectedPackage = null;
        longname = null;
        packagePath = null;
    }

    public static NewRightModel copyToNewRightModel() {
        NewRightModel newRightModel = new NewRightModel();
        newRightModel.setId(id);
        newRightModel.setSelectedPackage(selectedPackage);
        newRightModel.setLongname(longname);
        newRightModel.setPackagePath(packagePath);
        newRightModel.setClassType(classType);
        return newRightModel;
    }

}
