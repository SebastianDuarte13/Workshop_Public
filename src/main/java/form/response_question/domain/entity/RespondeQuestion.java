package form.response_question.domain.entity;

public class RespondeQuestion {
    private int id;
    private int response_id;
    private int subresponses_id;
    private String responsetext;
    public RespondeQuestion(int response_id, int subresponses_id, String responsetext) {
        this.response_id = response_id;
        this.subresponses_id = subresponses_id;
        this.responsetext = responsetext;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getResponse_id() {
        return response_id;
    }
    public void setResponse_id(int response_id) {
        this.response_id = response_id;
    }
    public int getSubresponses_id() {
        return subresponses_id;
    }
    public void setSubresponses_id(int subresponses_id) {
        this.subresponses_id = subresponses_id;
    }
    public String getResponsetext() {
        return responsetext;
    }
    public void setResponsetext(String responsetext) {
        this.responsetext = responsetext;
    }

    
}
