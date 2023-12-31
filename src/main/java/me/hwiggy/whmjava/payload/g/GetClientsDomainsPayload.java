/**
 * Generated by ramidzkh's awesome generator thingy
 */
package me.hwiggy.whmjava.payload.g;

import me.hwiggy.whmjava.payload.Payload;

/**
 * This class and its methods directly relate to the API documentation.
 * API documentation can be found at the￼ following URL:
 ￼* https://developers.whmcs.com/api-reference/getclientsdomains/
 */
public class GetClientsDomainsPayload extends Payload {

    /*
     * Obtain a list of Client Purchased Domains matching the provided criteria
     */
    public GetClientsDomainsPayload() {
        super ("GetClientsDomains");
    }

    /***
     *
     * @param limitStart The offset for the returned log data (default: 0)
     */
    public GetClientsDomainsPayload withLimitStart(int limitStart) {
        put("limitstart", limitStart);

        return this;
    }

    /***
     *
     * @param limitNum The number of records to return (default: 25)
     */
    public GetClientsDomainsPayload withLimitNum(int limitNum) {
        put("limitnum", limitNum);

        return this;
    }

    /***
     *
     * @param clientID The client id to obtain the details for.
     */
    public GetClientsDomainsPayload withClientID(int clientID) {
        put("clientid", clientID);

        return this;
    }

    /***
     *
     * @param domainID The specific domain id to obtain the details for
     */
    public GetClientsDomainsPayload withDomainID(int domainID) {
        put("domainid", domainID);

        return this;
    }

    /***
     *
     * @param domain The specific domain to obtain the details for
     */
    public GetClientsDomainsPayload withDomain(String domain) {
        put("domain", domain);

        return this;
    }
}