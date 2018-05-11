package com.peake.webseed.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_news")
public class TblNews {
    @Id
    @Column(name = "pk_global_id")
    private String pkGlobalId;

    @Column(name = "m_date")
    private Date mDate;

    private String news1;

    private String news2;

    private String news3;

    private String news4;

    @Column(name = "news_md1")
    private String newsMd1;

    @Column(name = "news_md2")
    private String newsMd2;

    @Column(name = "news_md3")
    private String newsMd3;

    @Column(name = "news_md4")
    private String newsMd4;

    private String host;

    private String guest1;

    private String guest2;

    private String tags;

    /**
     * @return pk_global_id
     */
    public String getPkGlobalId() {
        return pkGlobalId;
    }

    /**
     * @param pkGlobalId
     */
    public void setPkGlobalId(String pkGlobalId) {
        this.pkGlobalId = pkGlobalId;
    }

    /**
     * @return m_date
     */
    public Date getmDate() {
        return mDate;
    }

    /**
     * @param mDate
     */
    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    /**
     * @return news1
     */
    public String getNews1() {
        return news1;
    }

    /**
     * @param news1
     */
    public void setNews1(String news1) {
        this.news1 = news1;
    }

    /**
     * @return news2
     */
    public String getNews2() {
        return news2;
    }

    /**
     * @param news2
     */
    public void setNews2(String news2) {
        this.news2 = news2;
    }

    /**
     * @return news3
     */
    public String getNews3() {
        return news3;
    }

    /**
     * @param news3
     */
    public void setNews3(String news3) {
        this.news3 = news3;
    }

    /**
     * @return news4
     */
    public String getNews4() {
        return news4;
    }

    /**
     * @param news4
     */
    public void setNews4(String news4) {
        this.news4 = news4;
    }

    /**
     * @return news_md1
     */
    public String getNewsMd1() {
        return newsMd1;
    }

    /**
     * @param newsMd1
     */
    public void setNewsMd1(String newsMd1) {
        this.newsMd1 = newsMd1;
    }

    /**
     * @return news_md2
     */
    public String getNewsMd2() {
        return newsMd2;
    }

    /**
     * @param newsMd2
     */
    public void setNewsMd2(String newsMd2) {
        this.newsMd2 = newsMd2;
    }

    /**
     * @return news_md3
     */
    public String getNewsMd3() {
        return newsMd3;
    }

    /**
     * @param newsMd3
     */
    public void setNewsMd3(String newsMd3) {
        this.newsMd3 = newsMd3;
    }

    /**
     * @return news_md4
     */
    public String getNewsMd4() {
        return newsMd4;
    }

    /**
     * @param newsMd4
     */
    public void setNewsMd4(String newsMd4) {
        this.newsMd4 = newsMd4;
    }

    /**
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return guest1
     */
    public String getGuest1() {
        return guest1;
    }

    /**
     * @param guest1
     */
    public void setGuest1(String guest1) {
        this.guest1 = guest1;
    }

    /**
     * @return guest2
     */
    public String getGuest2() {
        return guest2;
    }

    /**
     * @param guest2
     */
    public void setGuest2(String guest2) {
        this.guest2 = guest2;
    }

    /**
     * @return tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * @param tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }
}