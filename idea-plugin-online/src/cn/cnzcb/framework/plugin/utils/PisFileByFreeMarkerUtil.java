package cn.cnzcb.framework.plugin.utils;

import cn.cnzcb.framework.plugin.model.NewRightModel;
import com.intellij.ide.projectView.ProjectView;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.util.OpenSourceUtil;
import freemarker.template.Template;

import java.io.StringWriter;

/**
 * @author xujin
 */
public class PisFileByFreeMarkerUtil {

    public static FreemarkerConfiguration freemarker = new FreemarkerConfiguration("/templates");

    /**
     * 右键创建扩展点
     * @param project
     * @param model
     * @param moduleRootPath
     * @throws Exception
     */
    public static void createFile(Project project, Object model, String moduleRootPath,String ftlName) throws Exception {

        NewRightModel rightModel =(NewRightModel)model;
        VirtualFile vf = createPackageDir(rightModel.getSelectedPackage(),moduleRootPath);
        //可以使用virtualfile.createChildData（）方法创建文件实例
        VirtualFile virtualFile=vf.createChildData(project, rightModel.getId()+".java");
        StringWriter sw = new StringWriter();
        Template template = PisFileByFreeMarkerUtil.freemarker.getTemplate(ftlName);
        template.process(model, sw);
        //使用VirtualFile.setBinaryContent()写一些数据到对应的文件中
        virtualFile.setBinaryContent(sw.toString().getBytes(EdspIdeaUtils.DEFAULT_CHARSET));
        //HaloIdeaUtils.addWaitOptimizeFile(virtualFile);

        FileEditorManager fileEditorManager = FileEditorManager.getInstance(project);
        if (fileEditorManager.isFileOpen(virtualFile)) {
            OpenSourceUtil.navigate(true, new OpenFileDescriptor(project, virtualFile));
            ProjectView.getInstance(project).select(null, virtualFile, true);
            return;
        }
        fileEditorManager.openFile(virtualFile, true);
        ProjectView.getInstance(project).select(null, virtualFile, true);
        ApplicationManager.getApplication().invokeLater(() -> {
            ToolWindow toolWindow = ToolWindowManager.getInstance(project).getToolWindow("Project");
            toolWindow.activate(null, true);
        });
    }

    public static void createXmlFile(Project project, Object model, String moduleRootPath,String ftlName) throws Exception {

        NewRightModel rightModel =(NewRightModel)model;
        VirtualFile vf = createPackageDir(rightModel.getSelectedPackage(),moduleRootPath);
        //可以使用virtualfile.createChildData（）方法创建文件实例
        VirtualFile virtualFile=vf.createChildData(project, rightModel.getId()+".xml");
        StringWriter sw = new StringWriter();
        Template template = PisFileByFreeMarkerUtil.freemarker.getTemplate(ftlName);
        template.process(model, sw);
        //使用VirtualFile.setBinaryContent()写一些数据到对应的文件中
        virtualFile.setBinaryContent(sw.toString().getBytes(EdspIdeaUtils.DEFAULT_CHARSET));
        //HaloIdeaUtils.addWaitOptimizeFile(virtualFile);

        FileEditorManager fileEditorManager = FileEditorManager.getInstance(project);
        if (fileEditorManager.isFileOpen(virtualFile)) {
            OpenSourceUtil.navigate(true, new OpenFileDescriptor(project, virtualFile));
            ProjectView.getInstance(project).select(null, virtualFile, true);
            return;
        }
        fileEditorManager.openFile(virtualFile, true);
        ProjectView.getInstance(project).select(null, virtualFile, true);
        ApplicationManager.getApplication().invokeLater(() -> {
            ToolWindow toolWindow = ToolWindowManager.getInstance(project).getToolWindow("Project");
            toolWindow.activate(null, true);
        });
    }



    private static VirtualFile createPackageDir(String packageName, String moduleRootPath) {
        packageName = "src/main/resources/" + packageName;
        String path = FileUtil.toSystemIndependentName(moduleRootPath + "/" + StringUtil.replace(packageName, ".", "/"));
        //new File(path).mkdirs();
        return LocalFileSystem.getInstance().refreshAndFindFileByPath(path);
    }




}
