package com.restfulbooker.api.payloads.request;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

public class BookingDatesPayload {

    @JsonProperty
    private Date checkin;
    @JsonProperty
    private Date checkout;

    public BookingDatesPayload(Date checkin, Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }
}
