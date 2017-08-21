package com.esioner.myapplication.neihan.neihanbean;

import java.util.List;

/**
 * Created by Esioner on 2017/8/21.
 */

public class ContentTypeBean {
    public String message;
    public List<TypeData> typeDatas;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TypeData> getTypeDatas() {
        return typeDatas;
    }

    public void setTypeDatas(List<TypeData> typeDatas) {
        this.typeDatas = typeDatas;
    }
}
