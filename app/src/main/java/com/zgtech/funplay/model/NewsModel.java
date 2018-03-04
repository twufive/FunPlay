package com.zgtech.funplay.model;

import java.util.List;

/**
 * Created by Juice on 2018-3-4.
 */

public class NewsModel {


    /**
     * code : 2
     * msg : 成功
     * list : [{"newsId":5,"title":"新春快乐","subTitle":"趣玩祝大家新快乐","body":"<p style=\"text-align: center;\"><strong>趣玩APP祝大家新快乐！！！<\/strong><\/p><p style=\"text-align: center;\"><strong><br/><\/strong><\/p>","createTime":"2018-01-27 02:10:55.0"}]
     * page : null
     */

    private int code;
    private String msg;
    private Object page;
    private List<ListBean> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * newsId : 5
         * title : 新春快乐
         * subTitle : 趣玩祝大家新快乐
         * body : <p style="text-align: center;"><strong>趣玩APP祝大家新快乐！！！</strong></p><p style="text-align: center;"><strong><br/></strong></p>
         * createTime : 2018-01-27 02:10:55.0
         */

        private int newsId;
        private String title;
        private String subTitle;
        private String body;
        private String createTime;

        public int getNewsId() {
            return newsId;
        }

        public void setNewsId(int newsId) {
            this.newsId = newsId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}
