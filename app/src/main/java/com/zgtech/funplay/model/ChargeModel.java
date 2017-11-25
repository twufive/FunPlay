package com.zgtech.funplay.model;

import java.util.List;

/**
 * Created by Administrator on 2017/11/9.
 */

public class ChargeModel {


    /**
     * code : 2
     * msg : 成功
     * obj : {"amount":300,"amountRefunded":0,"amountSettle":300,"app":"app_eHOaP8i5q5iP48uH","body":"Your Body","channel":"upacp","clientIp":"127.0.0.1","created":1511594898,"credential":{"object":"credential","upacp":{"mode":"00","tn":"201711251528181414731"}},"currency":"cny","extra":{},"id":"ch_PSGyPCyX5qL0urLaL4rb1SGG","livemode":false,"metadata":{},"object":"charge","orderNo":"100000011","paid":false,"refunded":false,"refunds":{"data":[],"hasMore":false,"object":"list","url":"/v1/charges/ch_PSGyPCyX5qL0urLaL4rb1SGG/refunds"},"reversed":false,"subject":"Your Subject","timeExpire":1511598498}
     */

    private int code;
    private String msg;
    private ObjBean obj;

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

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * amount : 300
         * amountRefunded : 0
         * amountSettle : 300
         * app : app_eHOaP8i5q5iP48uH
         * body : Your Body
         * channel : upacp
         * clientIp : 127.0.0.1
         * created : 1511594898
         * credential : {"object":"credential","upacp":{"mode":"00","tn":"201711251528181414731"}}
         * currency : cny
         * extra : {}
         * id : ch_PSGyPCyX5qL0urLaL4rb1SGG
         * livemode : false
         * metadata : {}
         * object : charge
         * orderNo : 100000011
         * paid : false
         * refunded : false
         * refunds : {"data":[],"hasMore":false,"object":"list","url":"/v1/charges/ch_PSGyPCyX5qL0urLaL4rb1SGG/refunds"}
         * reversed : false
         * subject : Your Subject
         * timeExpire : 1511598498
         */

        private int amount;
        private int amountRefunded;
        private int amountSettle;
        private String app;
        private String body;
        private String channel;
        private String clientIp;
        private int created;
        private CredentialBean credential;
        private String currency;
        private ExtraBean extra;
        private String id;
        private boolean livemode;
        private MetadataBean metadata;
        private String object;
        private String orderNo;
        private boolean paid;
        private boolean refunded;
        private RefundsBean refunds;
        private boolean reversed;
        private String subject;
        private int timeExpire;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getAmountRefunded() {
            return amountRefunded;
        }

        public void setAmountRefunded(int amountRefunded) {
            this.amountRefunded = amountRefunded;
        }

        public int getAmountSettle() {
            return amountSettle;
        }

        public void setAmountSettle(int amountSettle) {
            this.amountSettle = amountSettle;
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getClientIp() {
            return clientIp;
        }

        public void setClientIp(String clientIp) {
            this.clientIp = clientIp;
        }

        public int getCreated() {
            return created;
        }

        public void setCreated(int created) {
            this.created = created;
        }

        public CredentialBean getCredential() {
            return credential;
        }

        public void setCredential(CredentialBean credential) {
            this.credential = credential;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isLivemode() {
            return livemode;
        }

        public void setLivemode(boolean livemode) {
            this.livemode = livemode;
        }

        public MetadataBean getMetadata() {
            return metadata;
        }

        public void setMetadata(MetadataBean metadata) {
            this.metadata = metadata;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public boolean isPaid() {
            return paid;
        }

        public void setPaid(boolean paid) {
            this.paid = paid;
        }

        public boolean isRefunded() {
            return refunded;
        }

        public void setRefunded(boolean refunded) {
            this.refunded = refunded;
        }

        public RefundsBean getRefunds() {
            return refunds;
        }

        public void setRefunds(RefundsBean refunds) {
            this.refunds = refunds;
        }

        public boolean isReversed() {
            return reversed;
        }

        public void setReversed(boolean reversed) {
            this.reversed = reversed;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public int getTimeExpire() {
            return timeExpire;
        }

        public void setTimeExpire(int timeExpire) {
            this.timeExpire = timeExpire;
        }

        public static class CredentialBean {
            public static class UpacpBean {
            }
        }

        public static class ExtraBean {
        }

        public static class MetadataBean {
        }

        public static class RefundsBean {
            /**
             * data : []
             * hasMore : false
             * object : list
             * url : /v1/charges/ch_PSGyPCyX5qL0urLaL4rb1SGG/refunds
             */

            private boolean hasMore;
            private String object;
            private String url;
            private List<?> data;

            public boolean isHasMore() {
                return hasMore;
            }

            public void setHasMore(boolean hasMore) {
                this.hasMore = hasMore;
            }

            public String getObject() {
                return object;
            }

            public void setObject(String object) {
                this.object = object;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<?> getData() {
                return data;
            }

            public void setData(List<?> data) {
                this.data = data;
            }
        }
    }
}
