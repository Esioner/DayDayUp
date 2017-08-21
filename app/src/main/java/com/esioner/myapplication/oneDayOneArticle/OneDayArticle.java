package com.esioner.myapplication.oneDayOneArticle;



public class OneDayArticle {
    public Data data;


    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public class Data {
        public String author;
        public String content;
        /**
         * 首段
         */
        public String digest;
        public String title;
        public int wc;
        public Date date;


        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }



        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getWc() {
            return wc;
        }

        public void setWc(int wc) {
            this.wc = wc;
        }

        public class Date {
            public String curr;

            public String getCurr() {
                return curr;
            }

            public void setCurr(String curr) {
                this.curr = curr;
            }

            public String getNext() {
                return next;
            }

            public void setNext(String next) {
                this.next = next;
            }

            public String getPrev() {
                return prev;
            }

            public void setPrev(String prev) {
                this.prev = prev;
            }

            public String next;
            public String prev;
        }

    }

}
