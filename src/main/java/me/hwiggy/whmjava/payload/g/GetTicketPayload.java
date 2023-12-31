/**
 * Generated by ramidzkh's awesome generator thingy
 */
package me.hwiggy.whmjava.payload.g;

import me.hwiggy.whmjava.payload.Payload;

/***
 * This class and its methods directly relate to the API documentation.
 * API documentation can be found at the￼ following URL:
 ￼* https://developers.whmcs.com/api-reference/getticket/
 */
public class GetTicketPayload extends Payload {

    /*
     * Obtain a specific ticket
     */
    public GetTicketPayload() {
        super ("GetTicket");
    }


    /***
     *
     * @param ticketnum Obtain the ticket for the specific Client Ticket Number
     */
    public GetTicketPayload withTicketnum(String ticketnum) {
        put("ticketnum", ticketnum);

        return this;
    }

    /***
     *
     * @param ticketid Obtain the ticket for the specific ticket id (Either $ticketnum or $ticketid is required)
     */
    public GetTicketPayload withTicketid(int ticketid) {
        put("ticketid", ticketid);

        return this;
    }

    /***
     *
     * @param repliessort ASC or DESC. Which order to organise the ticket replies
     */
    public GetTicketPayload withRepliessort(String repliessort) {
        put("repliessort", repliessort);

        return this;
    }
}