/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaclient;

/**
 *
 * @author Eric Bruno
 */
public interface ServerResponses {
    public void onHostnameResponse(String msg);
    public void onMemoryResponse(String msg);
    public void onRandomNumberResponse(String msg);
}
