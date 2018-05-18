package net.better.hongqian.baseproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HongQian.Wang on 2017/11/28.
 */

public class QuesEntity implements Serializable {


        /**
         * info : {"category":[{"kp_id":2,"ques_num":10,"kp_name":"算法"},{"kp_id":3,"ques_num":1,"kp_name":"系统设计"},{"kp_id":4,"ques_num":1,"kp_name":"C/C++"}],"collection":1,"wrong":0}
         * data :
         */

        private InfoBean info;
        private String data;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public static class InfoBean implements Serializable{
            /**
             * category : [{"kp_id":2,"ques_num":10,"kp_name":"算法"},{"kp_id":3,"ques_num":1,"kp_name":"系统设计"},{"kp_id":4,"ques_num":1,"kp_name":"C/C++"}]
             * collection : 1
             * wrong : 0
             */

            private int collection;
            private int wrong;
            private List<CategoryBean> category;

            public int getCollection() {
                return collection;
            }

            public void setCollection(int collection) {
                this.collection = collection;
            }

            public int getWrong() {
                return wrong;
            }

            public void setWrong(int wrong) {
                this.wrong = wrong;
            }

            public List<CategoryBean> getCategory() {
                return category;
            }

            public void setCategory(List<CategoryBean> category) {
                this.category = category;
            }

            public static class CategoryBean implements Serializable{
                /**
                 * kp_id : 2
                 * ques_num : 10
                 * kp_name : 算法
                 */

                private int kp_id;
                private int ques_num;
                private String kp_name;
                private int is_cate;

                public int getIs_cate() {
                    return is_cate;
                }

                public void setIs_cate(int is_cate) {
                    this.is_cate = is_cate;
                }


                public int getIs_done() {
                    return is_done;
                }

                public void setIs_done(int is_done) {
                    this.is_done = is_done;
                }

                private int is_done;

                public int getKp_id() {
                    return kp_id;
                }

                public void setKp_id(int kp_id) {
                    this.kp_id = kp_id;
                }

                public int getQues_num() {
                    return ques_num;
                }

                public void setQues_num(int ques_num) {
                    this.ques_num = ques_num;
                }

                public String getKp_name() {
                    return kp_name;
                }

                public void setKp_name(String kp_name) {
                    this.kp_name = kp_name;
                }
            }

            @Override
            public String toString() {
                return "InfoBean{" +
                        "collection=" + collection +
                        ", wrong=" + wrong +
                        ", category=" + category +
                        '}';
            }
        }

    @Override
    public String toString() {
        return "QuesEntity{" +
                "info=" + info +
                ", data='" + data + '\'' +
                '}';
    }
}
