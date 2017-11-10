package com.zgtech.funplay.model;

/**
 * Created by Administrator on 2017/11/9.
 */

public class ChargeModel {

    /**
     * code : 2
     * msg : 成功
     * obj : {"id":"ch_HOOezDSyLyT4O00eHC0G0KKK","object":"charge","created":1510199438,"livemode":false,"paid":false,"refunded":false,"reversed":false,"app":"app_LKqnTGb50W9Cq5uj","channel":"alipay","orderNo":"12407506","clientIp":"58.20.12.191","amount":30000,"amountSettle":30000,"currency":"cny","subject":"火车站十人团两日游","body":"火车站十人团两日游,湖南18妹子做导游，原价5百块，现在3百块，贵不贵？意不意外？惊不惊喜？速速报名。","timePaid":null,"timeExpire":1510285838,"timeSettle":null,"transactionNo":null,"refunds":{"object":"list","url":"/v1/charges/ch_HOOezDSyLyT4O00eHC0G0KKK/refunds","hasMore":false,"data":[]},"amountRefunded":0,"failureCode":null,"failureMsg":null,"metadata":{},"credential":{"object":"credential","alipay":{"orderInfo":"_input_charset=\"utf-8\"&body=\"火车站十人团两日游,湖南18妹子做导游，原价5百块，现在3百块，贵不贵？意不意外？惊不惊喜？速速报名。\"&it_b_pay=\"2017-11-10 11:50:38\"¬ify_url=\"https%3A%2F%2Fnotify.pingxx.com%2Fnotify%2Fcharges%2Fch_HOOezDSyLyT4O00eHC0G0KKK\"&out_trade_no=\"12407506\"&partner=\"2008338532517812\"&payment_type=\"1\"&seller_id=\"2008338532517812\"&service=\"mobile.securitypay.pay\"&subject=\"火车站十人团两日游\"&total_fee=\"300.00\"&sign=\"ZkgwNEs4MUNPcTlDeW4xaUg0UGlyNUc0\"&sign_type=\"RSA\""}},"extra":{},"description":null}
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
         * id : ch_HOOezDSyLyT4O00eHC0G0KKK
         * object : charge
         * created : 1510199438
         * livemode : false
         * paid : false
         * refunded : false
         * reversed : false
         * app : app_LKqnTGb50W9Cq5uj
         * channel : alipay
         * orderNo : 12407506
         * clientIp : 58.20.12.191
         * amount : 30000
         * amountSettle : 30000
         * currency : cny
         * subject : 火车站十人团两日游
         * body : 火车站十人团两日游,湖南18妹子做导游，原价5百块，现在3百块，贵不贵？意不意外？惊不惊喜？速速报名。
         * timePaid : null
         * timeExpire : 1510285838
         * timeSettle : null
         * transactionNo : null
         * refunds : {"object":"list","url":"/v1/charges/ch_HOOezDSyLyT4O00eHC0G0KKK/refunds","hasMore":false,"data":[]}
         * amountRefunded : 0
         * failureCode : null
         * failureMsg : null
         * metadata : {}
         * credential : {"object":"credential","alipay":{"orderInfo":"_input_charset=\"utf-8\"&body=\"火车站十人团两日游,湖南18妹子做导游，原价5百块，现在3百块，贵不贵？意不意外？惊不惊喜？速速报名。\"&it_b_pay=\"2017-11-10 11:50:38\"¬ify_url=\"https%3A%2F%2Fnotify.pingxx.com%2Fnotify%2Fcharges%2Fch_HOOezDSyLyT4O00eHC0G0KKK\"&out_trade_no=\"12407506\"&partner=\"2008338532517812\"&payment_type=\"1\"&seller_id=\"2008338532517812\"&service=\"mobile.securitypay.pay\"&subject=\"火车站十人团两日游\"&total_fee=\"300.00\"&sign=\"ZkgwNEs4MUNPcTlDeW4xaUg0UGlyNUc0\"&sign_type=\"RSA\""}}
         * extra : {}
         * description : null
         */

        private String id;
        private String object;
        private int created;
        private boolean livemode;
        private boolean paid;
        private boolean refunded;
        private boolean reversed;
        private String app;
        private String channel;
        private String orderNo;
        private String clientIp;
        private int amount;
        private int amountSettle;
        private String currency;
        private String subject;
        private String body;
        private Object timePaid;
        private int timeExpire;
        private Object timeSettle;
        private Object transactionNo;
        private RefundsBean refunds;
        private int amountRefunded;
        private Object failureCode;
        private Object failureMsg;
        private MetadataBean metadata;
        private CredentialBean credential;
        private ExtraBean extra;
        private Object description;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public int getCreated() {
            return created;
        }

        public void setCreated(int created) {
            this.created = created;
        }

        public boolean isLivemode() {
            return livemode;
        }

        public void setLivemode(boolean livemode) {
            this.livemode = livemode;
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

        public boolean isReversed() {
            return reversed;
        }

        public void setReversed(boolean reversed) {
            this.reversed = reversed;
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getClientIp() {
            return clientIp;
        }

        public void setClientIp(String clientIp) {
            this.clientIp = clientIp;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getAmountSettle() {
            return amountSettle;
        }

        public void setAmountSettle(int amountSettle) {
            this.amountSettle = amountSettle;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public Object getTimePaid() {
            return timePaid;
        }

        public void setTimePaid(Object timePaid) {
            this.timePaid = timePaid;
        }

        public int getTimeExpire() {
            return timeExpire;
        }

        public void setTimeExpire(int timeExpire) {
            this.timeExpire = timeExpire;
        }

        public Object getTimeSettle() {
            return timeSettle;
        }

        public void setTimeSettle(Object timeSettle) {
            this.timeSettle = timeSettle;
        }

        public Object getTransactionNo() {
            return transactionNo;
        }

        public void setTransactionNo(Object transactionNo) {
            this.transactionNo = transactionNo;
        }

        public RefundsBean getRefunds() {
            return refunds;
        }

        public void setRefunds(RefundsBean refunds) {
            this.refunds = refunds;
        }

        public int getAmountRefunded() {
            return amountRefunded;
        }

        public void setAmountRefunded(int amountRefunded) {
            this.amountRefunded = amountRefunded;
        }

        public Object getFailureCode() {
            return failureCode;
        }

        public void setFailureCode(Object failureCode) {
            this.failureCode = failureCode;
        }

        public Object getFailureMsg() {
            return failureMsg;
        }

        public void setFailureMsg(Object failureMsg) {
            this.failureMsg = failureMsg;
        }

        public MetadataBean getMetadata() {
            return metadata;
        }

        public void setMetadata(MetadataBean metadata) {
            this.metadata = metadata;
        }

        public CredentialBean getCredential() {
            return credential;
        }

        public void setCredential(CredentialBean credential) {
            this.credential = credential;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public static class RefundsBean {
        }

        public static class MetadataBean {
        }

        public static class CredentialBean {
            public static class AlipayBean {
            }
        }

        public static class ExtraBean {
        }
    }
}
