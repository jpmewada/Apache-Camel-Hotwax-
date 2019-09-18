/**
 * 
 */
package org.apache.camel.avalara;

import java.util.List;


public class AvalaraTxnRequest {/*


	public List createTxn(List gstInList) {
		List responseList = new ArrayList();
		Map responseMap = new HashMap();
		if(gstInList != null) {
			if(gstInList.size()>0) {
				GstInList gstInListObject = new GstInList();
				Map gstMap;
				GstIn gstIn;
				StringBuilder stringBuilder  = new StringBuilder();
				for(int i=0; i<gstInList.size(); i++) {
					gstMap = (Map)gstInList.get(i);
					gstIn = new GstIn();
					
					if(gstMap.get("GSTIN") != null) {
						gstIn.setGSTIN((String)gstMap.get("GSTIN"));
					}else {
						stringBuilder.append("\"GSTIN\" ");
					}
					CounterParty counterParty = new CounterParty();
					if(gstMap.get("CounterParty_GSTIN") != null) {
						counterParty.setGSTIN((String)gstMap.get("CounterParty_GSTIN"));
					}

					if(gstMap.get("CounterParty_Name") != null) {
						counterParty.setName((String)gstMap.get("CounterParty_Name"));
					}

					if(gstMap.get("CounterParty_UIN") != null) {
						counterParty.setUIN((String)gstMap.get("CounterParty_UIN"));
					}
					gstIn.setCounterParty(counterParty);

					if(gstMap.get("Number") != null) {
						gstIn.setNumber((String)gstMap.get("Number"));
					}else {
						stringBuilder.append("\"Number\" ");
					}

					if(gstMap.get("Type") != null) {
						gstIn.setType((String)gstMap.get("Type"));
					}else {
						stringBuilder.append("\"Type\" ");
					}

					if(gstMap.get("Date") != null) {
						gstIn.setDate(new SimpleDateFormat("yyyy-MM-dd").format(((Date)gstMap.get("Date"))));
					}else {
						stringBuilder.append("\"Date\" ");
					}

					if(gstMap.get("POS") != null) {
						gstIn.setPOS((String)gstMap.get("POS"));
					}

					ShippingBill shippingBill  =  new ShippingBill();
					if(gstMap.get("ShippingBill_PortCode") != null) {
						shippingBill.setPortCode((String)gstMap.get("ShippingBill_PortCode"));
					}

					if(gstMap.get("ShippingBill_Value") != null) {
						shippingBill.setValue((String)gstMap.get("ShippingBill_Value"));
					}
					gstIn.setShippingBill(shippingBill);

					if(gstMap.get("ExportType") != null) {
						gstIn.setExportType((String)gstMap.get("ExportType"));
					}

					EwayBill ewayBill = new EwayBill();
					if(gstMap.get("EwayBill_Id") != null) {
						ewayBill.setId((String)gstMap.get("EwayBill_Id"));
					}
					gstIn.setEwayBill(ewayBill);

					OriginalDocument originaldoc = new OriginalDocument();
					if(gstMap.get("OriginalDocument_Number") != null) {
						originaldoc.setNumber((String)gstMap.get("OriginalDocument_Number"));
					}
					gstIn.setOriginalDocument(originaldoc);

					if(gstMap.get("CDNReason") != null) {
						gstIn.setCDNReason((String)gstMap.get("CDNReason"));
					}

					ECommOprMerchant eComm = new ECommOprMerchant();
					if(gstMap.get("ECommOprMerchant_Id") != null) {
						eComm.setId((String)gstMap.get("ECommOprMerchant_Id"));
					}

					if(gstMap.get("ECommOprMerchant_GSTIN") != null) {
						eComm.setGSTIN((String)gstMap.get("ECommOprMerchant_GSTIN"));
					}
					gstIn.setECommOprMerchant(eComm);

					if(gstMap.get("PGST") != null) {
						gstIn.setPGST((Boolean)gstMap.get("PGST"));
					}

					ShipFrom shipFrom = new ShipFrom();
					if(gstMap.get("ShipFrom_City") != null) {
						shipFrom.setCity((String)gstMap.get("ShipFrom_City"));
					}

					if(gstMap.get("ShipFrom_State") != null) {
						shipFrom.setState((String)gstMap.get("ShipFrom_State"));
					}else {
						stringBuilder.append("\"ShipFrom State\" ");
					}

					if(gstMap.get("ShipFrom_Line1") != null) {
						shipFrom.setLine1((String)gstMap.get("ShipFrom_Line1"));
					}

					if(gstMap.get("ShipFrom_Country") != null) {
						shipFrom.setCountry((String)gstMap.get("ShipFrom_Country"));
					}else {
						stringBuilder.append("\"ShipFrom Country\" ");
					}

					if(gstMap.get("ShipFrom_PostalCode") != null) {
						shipFrom.setPostalCode((String)gstMap.get("ShipFrom_PostalCode"));
					}
					gstIn.setShipFrom(shipFrom);

					ShipTo shipTo = new ShipTo();
					if(gstMap.get("ShipTo_City") != null) {
						shipTo.setCity((String)gstMap.get("ShipTo_City"));
					}

					if(gstMap.get("ShipTo_State") != null) {
						shipTo.setState((String)gstMap.get("ShipTo_State"));
					}else {
						stringBuilder.append("\"ShipTo State\" ");
					}

					if(gstMap.get("ShipTo_Line1") != null) {
						shipTo.setLine1((String)gstMap.get("ShipTo_Line1"));
					}

					if(gstMap.get("ShipTo_Country") != null) {
						shipTo.setCountry((String)gstMap.get("ShipTo_Country"));
					}else {
						stringBuilder.append("\"ShipTo Country\" ");
					}

					if(gstMap.get("ShipTo_PostalCode") != null) {
						shipTo.setPostalCode((String)gstMap.get("ShipTo_PostalCode"));
					}
					gstIn.setShipTo(shipTo);

					for(int j=1; j<Integer.MAX_VALUE; j++) {
						String Indexedline = "Line"+j;
						if(gstMap.get(Indexedline+"_HSNCode") == null) {
							break;
						}

						Line line = new Line();
						line.setHSNCode((String)gstMap.get(Indexedline+"_HSNCode"));

						if(gstMap.get(Indexedline+"_UnitQuantityCode") != null) {
							line.setUnitQuantityCode((String)gstMap.get(Indexedline+"_UnitQuantityCode"));
						}
						
						if(gstMap.get(Indexedline+"_Number") != null) {
							line.setNumber((String)gstMap.get(Indexedline+"_Number"));
						}
						
						if(gstMap.get(Indexedline+"_Description") != null) {
							line.setDescription((String)gstMap.get(Indexedline+"_Description"));
						}
						
						if(gstMap.get(Indexedline+"_Quantity") != null) {
							line.setQuantity((Double)gstMap.get(Indexedline+"_Quantity"));
						}
						
						if(gstMap.get(Indexedline+"_TaxableAmount") != null) {
							line.setTaxableAmount((Double)gstMap.get(Indexedline+"_TaxableAmount"));
						}
						
						if(gstMap.get(Indexedline+"_TaxAmount") != null) {
							line.setTaxAmount((Double)gstMap.get(Indexedline+"_TaxAmount"));
						}
						
						if(gstMap.get(Indexedline+"_TaxRate") != null) {
							line.setTaxRate((Double)gstMap.get(Indexedline+"_TaxRate"));
						}
						
						TDS tds = new TDS();
						if(gstMap.get(Indexedline+"_TDS_IGST") != null) {
							tds.setIGST((Double)gstMap.get(Indexedline+"_TDS_IGST"));
						}
						if(gstMap.get(Indexedline+"_TDS_IGSTRate") != null) {
							tds.setIGSTRate((Double)gstMap.get(Indexedline+"_TDS_IGSTRate"));
						}
						if(gstMap.get(Indexedline+"_TDS_CGST") != null) {
							tds.setCGST((Double)gstMap.get(Indexedline+"_TDS_CGST"));
						}
						if(gstMap.get(Indexedline+"_TDS_CGSTRate") != null) {
							tds.setCGSTRate((Double)gstMap.get(Indexedline+"_TDS_CGSTRate"));
						}
						if(gstMap.get(Indexedline+"_TDS_SGST") != null) {
							tds.setSGST((Double)gstMap.get(Indexedline+"_TDS_SGST"));
						}
						if(gstMap.get(Indexedline+"_TDS_SGSTRate") != null) {
							tds.setSGSTRate((Double)gstMap.get(Indexedline+"_TDS_SGSTRate"));
						}
						if(gstMap.get(Indexedline+"_TDS_CESS") != null) {
							tds.setCESS((Double)gstMap.get(Indexedline+"_TDS_CESS"));
						}
						if(gstMap.get(Indexedline+"_TDS_CESSRate") != null) {
							tds.setCESSRate((Double)gstMap.get(Indexedline+"_TDS_CESSRate"));
						}
						line.setTDS(tds);
						
						TCS tcs = new TCS();
						if(gstMap.get(Indexedline+"_TCS_IGST") != null) {
							tcs.setIGST((Double)gstMap.get(Indexedline+"_TCS_IGST"));
						}
						if(gstMap.get(Indexedline+"_TCS_IGSTRate") != null) {
							tcs.setIGSTRate((Double)gstMap.get(Indexedline+"_TCS_IGSTRate"));
						}
						if(gstMap.get(Indexedline+"_TCS_CGST") != null) {
							tcs.setCGST((Double)gstMap.get(Indexedline+"_TCS_CGST"));
						}
						if(gstMap.get(Indexedline+"_TCS_CGSTRate") != null) {
							tcs.setCGSTRate((Double)gstMap.get(Indexedline+"_TCS_CGSTRate"));
						}
						if(gstMap.get(Indexedline+"_TCS_SGST") != null) {
							tcs.setSGST((Double)gstMap.get(Indexedline+"_TCS_SGST"));
						}
						if(gstMap.get(Indexedline+"_TCS_SGSTRate") != null) {
							tcs.setSGSTRate((Double)gstMap.get(Indexedline+"_TCS_SGSTRate"));
						}
						if(gstMap.get(Indexedline+"_TCS_CESS") != null) {
							tcs.setCESS((Double)gstMap.get(Indexedline+"_TCS_CESS"));
						}
						if(gstMap.get(Indexedline+"_TCS_CESSRate") != null) {
							tcs.setCESSRate((Double)gstMap.get(Indexedline+"_TCS_CESSRate"));
						}
						line.setTCS(tcs);
						
						if(gstMap.get(Indexedline+"_ITCSpecialHandling") != null) {
							line.setITCSpecialHandling((String)gstMap.get(Indexedline+"_ITCSpecialHandling"));
						}
						
						if(gstMap.get(Indexedline+"_IGST") != null) {
							line.setIGST((Double)gstMap.get(Indexedline+"_IGST"));
						}
						
						if(gstMap.get(Indexedline+"_IGSTRate") != null) {
							line.setIGSTRate((Double)gstMap.get(Indexedline+"_IGSTRate"));
						}
						
						if(gstMap.get(Indexedline+"_CGST") != null) {
							line.setCGST((Double)gstMap.get(Indexedline+"_CGST"));
						}
						
						if(gstMap.get(Indexedline+"_CGSTRate") != null) {
							line.setCGSTRate((Double)gstMap.get(Indexedline+"_CGSTRate"));
						}
						
						if(gstMap.get(Indexedline+"_SGST") != null) {
							line.setSGST((Double)gstMap.get(Indexedline+"_SGST"));
						}
						
						if(gstMap.get(Indexedline+"_SGSTRate") != null) {
							line.setSGSTRate((Double)gstMap.get(Indexedline+"_SGSTRate"));
						}
						
						if(gstMap.get(Indexedline+"_CESS") != null) {
							line.setCESS((Double)gstMap.get(Indexedline+"_CESS"));
						}
						
						if(gstMap.get(Indexedline+"_CESSRate") != null) {
							line.setCESSRate((Double)gstMap.get(Indexedline+"_CESSRate"));
						}
						
						//gstIn.Lines.add(line);
					}
					//gstInListObject.getGstInList().add(gstIn);
				}
				if(stringBuilder.length() > 0) {
					stringBuilder.append("can't be null");
					responseMap.put("error", stringBuilder);
					responseList.add(responseMap);
				}else {
					try {
						responseList = CamelService.invokeAvalaraTxn(gstInListObject);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
				}
			}
		}
		return responseList;
	}
*/}
