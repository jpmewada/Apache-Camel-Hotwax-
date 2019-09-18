/**
 * 
 */
package com.jp.httpclient;

import org.apache.camel.avalara.CamelService;

/**
 * @author jaiprakash
 *
 */
public class HCTokenDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(CamelService.callAvalaraTxnApi());
			System.out.println(CamelService.callAvalaraEwayBillApi());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
