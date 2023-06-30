/**
 * Generated by ramidzkh's awesome generator thingy
 */
package me.hwiggy.whmjava.payload.d;

import me.hwiggy.whmjava.payload.Payload;

/***
 * This class and its methods directly relate to the API documentation.
 * API documentation can be found at the￼ following URL:
 ￼* https://developers.whmcs.com/api-reference/domaingetwhoisinfo/
 */
public class DomainGetWhoisInfoPayload extends Payload {

    /***
     * Obtains the current whois information for the domain.
     * @param domainID The id of the domain to obtain the whois information for
     */
    public DomainGetWhoisInfoPayload(int domainID) {
        super ("DomainGetWhoisInfo");
        put("domainid", domainID);
    }
}