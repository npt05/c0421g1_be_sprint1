package com.codegym.entity.about_news;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewsDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer newsId;

    @NotBlank(message = "Vui lòng nhập tiêu đề tin tức.")
    @Size(message = "Độ dài tin từ 10 đến 100 ký tự.", min = 10, max = 100)
    private String newsTitle;

    @NotBlank(message = "Vui lòng nhập phần tóm tắt tin tức.")
    @Size(message = "Độ dài tóm tắt từ 10 đến 256 ký tự.", min = 10, max = 256)
    private String newsBrief;

    @NotBlank(message = "Vui lòng nhập phần nội dung tin tức.")
    @Size(message = "Độ dài nội dung từ 100 đến 1024 ký tự.", min = 100, max = 1024)
    private String newsContent;

    @NotBlank(message = "Vui lòng nhập url hình ảnh.")
    private String imageUrl;

    @NotBlank(message = "Vui lòng chọn ngày đăng.")
    private String postDate;

    @JsonBackReference
    private Type type;


    public NewsDto() {
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsBrief() {
        return newsBrief;
    }

    public void setNewsBrief(String newsBrief) {
        this.newsBrief = newsBrief;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
