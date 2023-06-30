/**
 * Generated by ramidzkh's awesome generator thingy
 */
package me.hwiggy.whmjava.payload.g;

import me.hwiggy.whmjava.payload.Payload;

/**
 * This class and its methods directly relate to the API documentation.
 * API documentation can be found at the￼ following URL:
 ￼* https://developers.whmcs.com/api-reference/getclientsdetails/
 */
public class GetClientsDetailsPayload extends Payload {

    /*
     * Obtain the Clients Details for a specific client
     */
    public GetClientsDetailsPayload() {
        super ("GetClientsDetails");
    }

    /***
     *
     * @param clientID The client id to obtain the details for. $clientid or $email is required
     */
    public GetClientsDetailsPayload withClientID(int clientID) {
        put("clientid", clientID);

        return this;
    }

    /***
     *
     * @param email The email address of the client to search for
     */
    public GetClientsDetailsPayload withEmail(String email) {
        put("email", email);

        return this;
    }

    /***
     *
     * @param stats Also return additional client statistics.
     */
    public GetClientsDetailsPayload withStats(boolean stats) {
        put("stats", stats);

        return this;
    }
}