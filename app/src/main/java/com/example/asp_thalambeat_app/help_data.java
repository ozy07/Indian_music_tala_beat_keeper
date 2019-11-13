package com.example.asp_thalambeat_app;

public class help_data {
    String heading, body;
    int image_id;

    public help_data(String heading, String body, int image_id){
        this.heading = heading;
        this.body = body;
        this.image_id = image_id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
