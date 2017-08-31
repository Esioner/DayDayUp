package com.esioner.myapplication.neihan;


import com.esioner.myapplication.neihan.neihanbean.neiHanBean.NeiHanBean;
import com.esioner.myapplication.neihan.neihanbean.neiHanBean.NeiHanDataBean;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static List<NeiHanDataBean> traverseData(NeiHanBean neiHanBean){
        List<NeiHanDataBean> neiHanDataBeanList = new ArrayList<>();
        for (NeiHanDataBean dataBean : neiHanBean.getData().getData()) {
            if (dataBean.getGroup() != null) {
                neiHanDataBeanList.add(dataBean);
            }
        }
        return neiHanDataBeanList;
    }

}
