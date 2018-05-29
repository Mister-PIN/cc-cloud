package com.cc.mediacentre.common;

public class CCEnum {

    public enum MediaBps {
        SSSS("ssss","1080P"),SSS("sss","720P"),SS("ss","超清"),S("s","高清"),A("a","默认"),B("b","标清"),C("c","极速");
        private String code;
        private String name;

        MediaBps(String code, String name){
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }


    public enum BillStatus {
        DISABLED(0, "disabled"),NEW_ADD(1, "add"),HAS_SUBMIT(2, "submit"),HAS_CONFIRM(3, "confirm"),HAS_AUDIT(4, "audit");
        private int code;
        private String name;

        BillStatus(int code, String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

}
