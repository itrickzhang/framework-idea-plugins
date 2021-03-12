package cn.sunline.edsp.plugin;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import cn.sunline.edsp.plugin.model.NewRightContext;
import cn.sunline.edsp.plugin.model.SelectedTypeModel;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

/**
 * @author zcb
 */
public class BasicCreateSelectInfoStep extends ModuleWizardStep {

    private JPanel myMainPanel;

    private JPanel myPackagePanel;

    /**
     * 类名
     */
    private JTextField id;

    /**
     * 下拉列表框
     */
    private JComboBox<SelectedTypeModel> kind;




    private Project myProject;
    private Module myModule;




    /**
     * 创建Mapper选择数据对象相关
     */
    private JLabel dataObjectTip;
    private JTextField dataObjectValue;
    private JButton dataObjectChooseButton;
    private JTextField longname;
    private JTextField packagePath;
    private JLabel 类名;
    private JLabel 中文名称;

    /**
     * @param project
     * @param module
     */
    public BasicCreateSelectInfoStep(Project project, Module module) {
        myProject = project;
        myModule = module;
        initComBox();
        dataObjectTip.setVisible(false);
        dataObjectValue.setVisible(false);
        dataObjectChooseButton.setVisible(false);
        kind.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                SelectedTypeModel selectedTypeModel = (SelectedTypeModel) e.getItem();
                switch (selectedTypeModel.getValue()) {
                    case EdspConstant.COMPONENT_TYPE:
                        NewRightContext.setClassType(EdspConstant.COMPONENT_TYPE);
                        break;
                    case EdspConstant.SERVICE_TYPE:
                        NewRightContext.setClassType(EdspConstant.SERVICE_TYPE);
                        break;
                    case EdspConstant.FLOW_TYPE:
                        NewRightContext.setClassType(EdspConstant.FLOW_TYPE);
                        break;
                    default:
                        NewRightContext.setClassType(null);
                }

            }
        });
    }



    private void initComBox() {

        List<SelectedTypeModel> list = BasicComBoxRenderer.getSelectedList();
        for (SelectedTypeModel seleType : list) {
            kind.addItem(seleType);
        }
        kind.setRenderer(new BasicComBoxRenderer());


    }

    @Override
    public JComponent getComponent() {
        return myMainPanel;
    }

    @Override
    public boolean validate() throws ConfigurationException {
        if (id.getText().isEmpty()) {
            throw new ConfigurationException("ID cannot be empty", "Create XML Tips");
        }
        if (longname.getText().isEmpty()) {
            throw new ConfigurationException("longname cannot be empty", "Create XML Tips");
        }

        if (packagePath.getText().isEmpty()) {
            throw new ConfigurationException("packagePath cannot be empty", "Create XML Tips");
        }
        NewRightContext.setId(id.getText());
        NewRightContext.setLongname(longname.getText());
        NewRightContext.setPackagePath(packagePath.getText());
        return super.validate();
    }


    @Override
    public void updateDataModel() {

    }


}
