package com.alexlee.blog;

import java.util.Date;

/**
 * @author alexlee
 * @version 1.0
 * @date 2019/7/12 13:48
 */
public class Blog {
    private String id;
    private String createtime;
    private boolean top;

    public String getId() {
        return id;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", createtime=" + createtime +
                ", top=" + top +
                '}';
    }
}
