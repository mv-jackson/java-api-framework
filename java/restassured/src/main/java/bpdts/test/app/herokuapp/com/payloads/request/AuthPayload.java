package bpdts.test.app.herokuapp.com.payloads.request;

import org.codehaus.jackson.annotate.JsonProperty;

public class AuthPayload {

    @JsonProperty
    private String city;
    @JsonProperty
    private String password;

    private AuthPayload(String city, String password) {
        this.city = city;
        this.password = password;
    }

    public String getUsername() {
        return city;
    }

    public String getPassword() {
        return password;
    }

    public static class AuthPayloadBuilder{

        private String city;
        private String password;

        public AuthPayloadBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AuthPayloadBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public AuthPayload build(){
            return new AuthPayload(city, password);
        }
    }
}
