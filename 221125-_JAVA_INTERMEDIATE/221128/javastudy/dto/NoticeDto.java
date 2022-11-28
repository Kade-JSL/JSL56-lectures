package dto;

public class NoticeDto {
    int bno;
    String title, content, name;
    int viewcount;
    
    public int getBno() {
        return bno;
    }
    public void setBno(int bno) {
        this.bno = bno;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getViewcount() {
        return viewcount;
    }
    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }    
}
