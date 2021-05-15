package com.bpdts.api.payloads.response;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UsersResponseData {

    @Getter @Setter private int id;
    @Getter @Setter private String first_name;
    @Getter @Setter private String last_name;
    @Getter @Setter private String email;
    @Getter @Setter private String ip_address;
    @Getter @Setter private int latitude;
    @Getter @Setter private int longitude;

}









