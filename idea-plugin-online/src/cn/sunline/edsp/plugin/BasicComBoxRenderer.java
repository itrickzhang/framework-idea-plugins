package cn.sunline.edsp.plugin;


import cn.sunline.edsp.plugin.model.SelectedTypeModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 下拉列表渲染
 */
public class BasicComBoxRenderer extends DefaultListCellRenderer {
    private Map<String, ImageIcon> iconMap = new HashMap<>();
    private Color background = new Color(0, 100, 255, 15);
    private Color defaultBackground = (Color) UIManager.get("List.background");

    public BasicComBoxRenderer() {
        iconMap.put(EdspConstant.COMPONENT_TYPE,new ImageIcon(getClass().getResource("/icons/right/controller.png")));
        iconMap.put(EdspConstant.FLOW_TYPE,new ImageIcon(getClass().getResource("/icons/right/mapper.png")));
        iconMap.put(EdspConstant.SERVICE_TYPE,new ImageIcon(getClass().getResource("/icons/right/mapper.png")));

    }

    public static List<SelectedTypeModel> getSelectedList(){
        List<SelectedTypeModel> list=new ArrayList<SelectedTypeModel>();
        SelectedTypeModel blank=new SelectedTypeModel();
        blank.setName("");
        blank.setValue(EdspConstant.COMBOX_BLANK);
        list.add(blank);

        SelectedTypeModel component=new SelectedTypeModel();
        component.setName("Component");
        component.setValue(EdspConstant.COMPONENT_TYPE);
        list.add(component);

        SelectedTypeModel flow=new SelectedTypeModel();
        flow.setName("Flow");
        flow.setValue(EdspConstant.FLOW_TYPE);
        list.add(flow);

        SelectedTypeModel service=new SelectedTypeModel();
        service.setName("Service");
        service.setValue(EdspConstant.SERVICE_TYPE);
        list.add(service);



        return list;
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        SelectedTypeModel emp = (SelectedTypeModel) value;
        this.setText(emp.getName());
        this.setIcon(iconMap.get(emp.getValue()));
        if (!isSelected) {
            this.setBackground(index % 2 == 0 ? background : defaultBackground);
        }
        return this;
    }
}