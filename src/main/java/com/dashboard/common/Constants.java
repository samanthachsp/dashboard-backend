package com.dashboard.common;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static final Map<String, String> ERROR_KEYS = new HashMap<String, String>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		put("UQ_CLIENT_CODE", "client.duplicate.code");
		put("UQ_CLIENT_NAME", "client.duplicate.name");
	}};

	public static final String REPORTS_PATH = "C:/Reports/";
	
	public static final String JSON_REPORTS_PATH = "C:/Reports/json/";
	
	public static final String DB_BACKUP_PATH_SYSTEM = "C:\\DBDump\\dump-system-";
	
	public static final String DB_BACKUP_PATH = "C:\\DBDump\\manual\\dump-manual-";
	
	public static final String DB_BACKUP_COMMAND_PATH ="C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\";
	
	public static final String DB_BACKUP_FILE_EXT = ".dql";
	
	public static final int REPORTS_HEADER_ROW = 2;
	
	public static final String REPORTS_TEMPLATE = "_template.xlsx";
	
	public static final String XLSX = ".xlsx";
	
	public static final String PDF = ".pdf";
	
	public static final String HASH = "#";
	
	public static final String EMPTY_STRING = "";
	
	public static final String LOCAL_ORDER_NO_START = "Q";
	
	public static final String SPACE_STRING = " ";
	
	public static final String HYPHEN = " - ";
	
	public static final String BACK_SLASH = "/";
	
	public static final String NA = "NA";
	
	public static final int ONE = 1;
	
	public static final String USER_ID = "user_id";
	
	public static final double TOTAL_HRS_PER_DAY = 7.75;
	
	public static final String SECTION_M = "Section M";
	
	public static final String SHOP_8 = "8";
	
	public static final String SHOP_18 = "18";
	
	public static final int MANUAL_PO = 1;
	
	// Requisitions generated for Item received
	public static final String REQUISITION_TYPE_I = "I";
	
	// Requisitions Material Request auto generated path
	public static final String REQUISITION_TYPE_R = "R"; 
	
	// Cancelled requisition status
	public static final String REQUISITION_STATUS_C = "C";
	
	// Approved requisition status
	public static final String REQUISITION_STATUS_A = "A";
	
	// New requisition status
	public static final String REQUISITION_STATUS_N = "N";
	
	// PO generated for stores order
	public static final String PO_TYPE_S = "S";
	
	// PO generated for local order
	public static final String PO_TYPE_L = "L";
	
	public static final DecimalFormat DF = new DecimalFormat("0.00");
	
	public static final int JASPER_REPORT_LOCAL_ORDER = 1;
	
	public static final int JASPER_REPORT_DOQ = 2;
	
	public static final int JASPER_REPORT_QUOTATION = 3;
	
	public static final int JASPER_REPORT_PO = 4;
	
	public static final int JASPER_REPORT_IR = 5;
	
	public static final int JASPER_REPORT_PAYMENT = 6;
	
	public static final int JASPER_REPORT_OPENING_SUMMARY = 7;
	
	public static final int JASPER_REPORT_SUMMARY_SHEET = 8;
	
	public static final int JASPER_REPORT_PROC_COMMITEE_MINITS_MAJOR = 9;
	
	public static final int JASPER_REPORT_PROC_COMMITEE_MINITS_MINOR = 10;
	
	public static final int JASPER_REPORT_EMPTY_QUOTATION = 11;
	
	public static final int JASPER_REPORT_POS = 12;
	
	public static final int SYSTEM_VERSION = 2060;
	
	public static final String ITEM_AUDIT_QUAERY = "select aud.*,revinfo.revtstmp from (\r\n"
			+ "			SELECT 0 as id, 'StartingStock-Initial' as transaction, id as transactionId , DateCreated as createdDate, DateModified as modifiedDate, item_id as itemId, noOfItems, unitPrice FROM starting_stock_initial where item_id=? and UnitPrice=? and isApproved=1\r\n"
			+ "			UNION ALL\r\n"
			+ "			SELECT 0 as id, 'StartingStock-Now' as transaction, id as transactionId , DateCreated as createdDate, DateModified as modifiedDate, item_id as itemId, noOfItems, unitPrice FROM starting_stock where item_id=? and UnitPrice=? and isApproved=1\r\n"
			+ "			UNION ALL\r\n"
			+ "			SELECT 1 as id,'CurrentStock-Initial' as transaction, id as transactionId, DateCreated as createdDate, DateModified as modifiedDate, item_id as itemId, noOfItems, unitPrice FROM current_stock_initial where item_id=? and UnitPrice=? and isApproved=1\r\n"
			+ "			UNION ALL\r\n"
			+ "			SELECT 1 as id,'CurrentStock-Now' as transaction, id as transactionId, DateCreated as createdDate, DateModified as modifiedDate, item_id as itemId, noOfItems, unitPrice FROM current_stock where item_id=? and UnitPrice=? and isApproved=1\r\n"
			+ "			UNION ALL\r\n"
			+ "			SELECT rev as id, 'CurrentStock-Audit' as transaction, id as transactionId, DateCreated as createdDate, DateModified as modifiedDate, item_id as itemId, noOfItems, unitPrice FROM current_stock_aud where item_id=? and UnitPrice=? and isApproved=1\r\n"
			+ "			UNION ALL\r\n"
			+ "			SELECT rev as id,'GrnItem-Audit' as transaction, id as transactionId, createdDate, modifiedDate, item_id as itemId, ReceivedQuantity - RejectedQuantity as noOfItems, unitPrice FROM grn_item_aud where item_id=? and UnitPrice=? and isApproved=1\r\n"
			+ "			UNION ALL\r\n"
			+ "			SELECT rev as id,'RequisitionItem-Audit' as transaction, id as transactionId, createdDate, modifiedDate, item_id as itemId, Quantity as noOfItems, unitPrice FROM requisition_item_aud where item_id=? and UnitPrice=? and isApproved=1\r\n"
			+ "			UNION ALL\r\n"
			+ "			SELECT rev as id,'CdnItem-Audit' as transaction, id as transactionId, createdDate, modifiedDate, item_id as itemId, Quantity as noOfItems, unitPrice FROM cdn_item_aud where item_id=? and UnitPrice=? and isApproved=1\r\n"
			+ "			UNION ALL\r\n"
			+ "			SELECT rev as id,'RemoveStockItem-Audit' as transaction, id as transactionId, createdDate, modifiedDate, item_id as itemId, removeNoOfItems as noOfItems, unitPrice FROM remove_stock_aud where item_id=? and UnitPrice=? and isApproved=1) aud\r\n"
			+ "			left outer join revinfo on revinfo.rev=aud.id order by id";
	
	public enum TRANSACTIONS {
		AMMEND_STORES_ORDER_ITEM(1),
		AMMEND_LOCAL_ORDER_ITEM(2),
		AMMEND_REQUISITION_ITEM(3),
		AMMEND_GRN_ITEM(4),
		AMMEND_GRN(5),
		AMMEND_LOCAL_ORDER(6);
		private int id;

		TRANSACTIONS(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}
	
	public enum REPORTS_TYPE {
		PDF(Constants.PDF),
		EXCEL(XLSX);
		
		REPORTS_TYPE(String extension) {
			this.extension= extension;
		}
		
		private String extension;

		public String getExtension() {
			return extension;
		}

		public void setExtension(String extension) {
			this.extension = extension;
		}
		
		
	}
	

	public enum REPORTS {
		REQUISITION(1, "requisitions", "SELECT mg.name as Section,r.skNo as SKNo, r.RequisitionNo, r.DateCreated as RequisitionDate, Sum(ri.UnitPrice* ri.Quantity) as Total, r.Status FROM requisition r inner join requisition_item ri on ri.requisition_id=r.id inner join material_group mg on mg.id=r.section_id where  mg.name Like ? Group by r.id",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		GRN(2, "grns", "SELECT  mg.name as Section,g.GrnNo, g.InvoiceNo, i.longName as Item, gi.ReceivedQuantity, gi.RejectedQuantity, gi.UnitPrice, g.* FROM grn g inner join grn_item gi on gi.grn_id=g.id inner join item  i on i.id=gi.item_id inner join material_group mg on mg.id=g.section_id where mg.name Like ?   order By g.GrnNo",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		LOCAL_ORDER(3, "localOrders", "SELECT mg.Name as Section, l.jobNumber, l.LocalOrderNo, l.shopNo, l.clientName, i.longName as item, li.Quantity, li.EngEstimate FROM local_order l inner join local_order_item li on l.id=li.localorder_id inner join item i on i.id=li.item_id inner join material_request mr on mr.localorder_id=l.id inner join material_group mg on mg.id=mr.sectionid order by mg.Name,l.id",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		STORES_ORDER(4, "storesOrders", "SELECT s.*, i.longName as item, si.Quantity, si.EngEstimate FROM stores_order s inner join stores_order_item si on s.id=si.storesorder_id inner join item i on i.id=si.item_id order by s.id",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		ITEMS(5, "items", "SELECT  mg.name as Section,i.* FROM item i inner join item_master im on im.id=i.item_master_id inner join material_group mg on mg.id=im.material_type_id where mg.name Like ?",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		CDN(6, "cdn", "select mg.name as Section,c.CDNNo as CDNNumber, r.RequisitionNo, r.skNo as SKNo, Sum(ci.UnitPrice* ci.Quantity) as CDNValue from CDN c inner join cdn_item ci on ci.cdn_id=c.id inner join requisition r on r.id=c.requisition_id inner join material_group mg on mg.id=r.section_id where mg.name Like ? ",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		VERIFICATION(7, "verification", "\r\n"
				+ "SELECT  mg.name as Section,items.id, item.longName as Item, items.UnitPrice ,IFNULL(stock.NoOfItems,0) as StartingStock, IFNULL(stock.TotalValue,0) as StartingStockCost, IFNULL(grn.NoOfItems,0) as Grn, IFNULL(grn.TotalValue, 0) as GrnCost, IFNULL(reqisition .NoOfItems,0) as Reqisition, IFNULL(reqisition.TotalValue,0) as RequisitionCost,\r\n"
				+ " IFNULL(cdn.NoOfItems,0) as Cdn, IFNULL(cdn.TotalValue,0) as CdnCost, IFNULL(damages.NoOfItems,0) as Damages, IFNULL(damages.TotalValue,0) as DamagesCost, (IFNULL(stock.NoOfItems,0) + IFNULL(grn.NoOfItems, 0) + IFNULL(cdn.NoOfItems,0) - IFNULL(reqisition.NoOfItems,0) - IFNULL(damages.NoOfItems,0)) as Stock, (IFNULL(stock.TotalValue,0) + IFNULL(grn.TotalValue, 0) + IFNULL(cdn.TotalValue,0)- IFNULL(reqisition.TotalValue,0) - IFNULL(damages.TotalValue,0)) as TotalCost\r\n"
				+ "FROM (select i.id, s.UnitPrice  from starting_stock s  inner join item i on s.item_id=i.id where s.isApproved=1\r\n"
				+ "UNION\r\n"
				+ "select  i.id,gi.UnitPrice  from grn_item gi inner join item i on gi.item_id=i.id where gi.isApproved=1 group by item_id, UnitPrice\r\n"
				+ "UNION\r\n"
				+ "select  i.id,c.UnitPrice  from cdn_item c inner join item i on c.item_id=i.id where c.isApproved=1 group by item_id, UnitPrice\r\n"
				+ "UNION\r\n"
				+ "select  i.id,r.UnitPrice  from remove_stock r inner join item i on r.item_id=i.id where r.isApproved=1 group by item_id, UnitPrice\r\n"
				+ "UNION\r\n"
				+ "SELECT  i.id,ri.UnitPrice FROM  requisition_item ri  inner join item i on ri.item_id=i.id inner join requisition r on r.id=ri.requisition_id where ri.isApproved=1 and r.status<>'C' Group by item_id, UnitPrice ) items \r\n"
				+ "left outer join (select i.id, i.longName as Item, s.UnitPrice as Rate,s.NoOfItems, s.UnitPrice*s.NoOfItems as TotalValue from starting_stock s  inner join item i on s.item_id=i.id where s.isApproved=1) stock on stock.id=items.id and stock.Rate=items.UnitPrice\r\n"
				+ "left outer join (select  i.id,i.longName as Item,gi.UnitPrice as Rate,SUM(ReceivedQuantity - RejectedQuantity) as NoOfItems, SUM(ReceivedQuantity - RejectedQuantity) *gi.UnitPrice  as TotalValue from grn_item gi inner join item i on gi.item_id=i.id where gi.isApproved=1 group by item_id, UnitPrice) grn on items.id=grn.id and grn.Rate=items.UnitPrice\r\n"
				+ "left outer join (SELECT  i.id,i.longName as Item,ri.UnitPrice as Rate, SUM(ri.Quantity) as NoOfItems, Sum(ri.UnitPrice* ri.Quantity) as TotalValue FROM  requisition_item ri inner join requisition r on r.id=ri.requisition_id inner join item i on ri.item_id=i.id where ri.isApproved=1 and ri.status<>'C' Group by item_id, UnitPrice) reqisition on items.id=reqisition.id and reqisition.Rate=items.UnitPrice\r\n"
				+ "left outer join (SELECT  i.id,i.longName as Item,ci.UnitPrice as Rate, SUM(ci.Quantity) as NoOfItems, Sum(ci.UnitPrice* ci.Quantity) as TotalValue FROM  cdn_item ci  inner join item i on ci.item_id=i.id where ci.isApproved=1 Group by item_id, UnitPrice) cdn on items.id=cdn.id and cdn.Rate=items.UnitPrice\r\n"
				+ "left outer join (SELECT  i.id,i.longName as Item,rs.UnitPrice as Rate, SUM(rs.removeNoOfItems) as NoOfItems, Sum(rs.UnitPrice* rs.removeNoOfItems) as TotalValue FROM  remove_stock rs  inner join item i on rs.item_id=i.id where rs.isApproved=1 Group by item_id, UnitPrice) damages on items.id=damages.id and damages.Rate=items.UnitPrice\r\n"
				+ "inner join item on item.id=items.id inner join item_master im on im.id=item.item_master_id inner join material_type mt on im.material_type_id=mt.id inner join material_group  mg on mt.group_id=mg.id  where mg.name Like ? order by mg.Name, item.longName",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		STOCK(8, "stock",  "\r\n"
				+ "SELECT  mg.name as Section,items.id, item.longName as Item, items.UnitPrice ,IFNULL(stock.NoOfItems,0) as StartingStock, IFNULL(stock.TotalValue,0) as StartingStockCost, IFNULL(grn.NoOfItems,0) as Grn, IFNULL(grn.TotalValue, 0) as GrnCost, IFNULL(reqisition .NoOfItems,0) as Reqisition, IFNULL(reqisition.TotalValue,0) as RequisitionCost,\r\n"
				+ " IFNULL(cdn.NoOfItems,0) as Cdn, IFNULL(cdn.TotalValue,0) as CdnCost, IFNULL(damages.NoOfItems,0) as Damages, IFNULL(damages.TotalValue,0) as DamagesCost, (IFNULL(stock.NoOfItems,0) + IFNULL(grn.NoOfItems, 0) + IFNULL(cdn.NoOfItems,0) - IFNULL(reqisition.NoOfItems,0) - IFNULL(damages.NoOfItems,0)) as Stock, (IFNULL(stock.TotalValue,0) + IFNULL(grn.TotalValue, 0) + IFNULL(cdn.TotalValue,0)- IFNULL(reqisition.TotalValue,0) - IFNULL(damages.TotalValue,0)) as TotalCost\r\n"
				+ "FROM (select i.id, s.UnitPrice  from starting_stock s  inner join item i on s.item_id=i.id where s.isApproved=1\r\n"
				+ "UNION\r\n"
				+ "select  i.id,gi.UnitPrice  from grn_item gi inner join item i on gi.item_id=i.id where gi.isApproved=1 group by item_id, UnitPrice\r\n"
				+ "UNION\r\n"
				+ "select  i.id,c.UnitPrice  from cdn_item c inner join item i on c.item_id=i.id where c.isApproved=1 group by item_id, UnitPrice\r\n"
				+ "UNION\r\n"
				+ "select  i.id,r.UnitPrice  from remove_stock r inner join item i on r.item_id=i.id where r.isApproved=1 group by item_id, UnitPrice\r\n"
				+ "UNION\r\n"
				+ "SELECT  i.id,ri.UnitPrice FROM  requisition_item ri  inner join item i on ri.item_id=i.id inner join requisition r on r.id=ri.requisition_id where ri.isApproved=1 and r.status<>'C' Group by item_id, UnitPrice ) items \r\n"
				+ "left outer join (select i.id, i.longName as Item, s.UnitPrice as Rate,s.NoOfItems, s.UnitPrice*s.NoOfItems as TotalValue from starting_stock s  inner join item i on s.item_id=i.id where s.isApproved=1) stock on stock.id=items.id and stock.Rate=items.UnitPrice\r\n"
				+ "left outer join (select  i.id,i.longName as Item,gi.UnitPrice as Rate,SUM(ReceivedQuantity - RejectedQuantity) as NoOfItems, SUM(ReceivedQuantity - RejectedQuantity) *gi.UnitPrice  as TotalValue from grn_item gi inner join item i on gi.item_id=i.id where gi.isApproved=1 group by item_id, UnitPrice) grn on items.id=grn.id and grn.Rate=items.UnitPrice\r\n"
				+ "left outer join (SELECT  i.id,i.longName as Item,ri.UnitPrice as Rate, SUM(ri.Quantity) as NoOfItems, Sum(ri.UnitPrice* ri.Quantity) as TotalValue FROM  requisition_item ri inner join requisition r on r.id=ri.requisition_id inner join item i on ri.item_id=i.id where ri.isApproved=1 and ri.status<>'C' Group by item_id, UnitPrice) reqisition on items.id=reqisition.id and reqisition.Rate=items.UnitPrice\r\n"
				+ "left outer join (SELECT  i.id,i.longName as Item,ci.UnitPrice as Rate, SUM(ci.Quantity) as NoOfItems, Sum(ci.UnitPrice* ci.Quantity) as TotalValue FROM  cdn_item ci  inner join item i on ci.item_id=i.id where ci.isApproved=1 Group by item_id, UnitPrice) cdn on items.id=cdn.id and cdn.Rate=items.UnitPrice\r\n"
				+ "left outer join (SELECT  i.id,i.longName as Item,rs.UnitPrice as Rate, SUM(rs.removeNoOfItems) as NoOfItems, Sum(rs.UnitPrice* rs.removeNoOfItems) as TotalValue FROM  remove_stock rs  inner join item i on rs.item_id=i.id where rs.isApproved=1 Group by item_id, UnitPrice) damages on items.id=damages.id and damages.Rate=items.UnitPrice\r\n"
				+ "inner join item on item.id=items.id inner join item_master im on im.id=item.item_master_id inner join material_type mt on im.material_type_id=mt.id inner join material_group  mg on mt.group_id=mg.id  where mg.name Like ? order by mg.Name, item.longName",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		BUFFER_STOCK(9, "bufferStock", "SELECT  mg.name as Section,l.* FROM order_level l inner join item on item.id=l.item_id inner join item_master im on im.id=item.item_master_id inner join material_type mt on im.material_type_id=mt.id inner join material_group  mg on mt.group_id=mg.id  where mg.name Like ?",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		OT_REPORT(10, "otReport", "SELECT ROW_NUMBER() OVER(ORDER BY JobNo ASC) AS RowNum, spd.JobNo, spd.EmployeeNo, e.Name, spd.WorkDescription, spd.OT, sp.recommendedBy, sp.otApprovedBy, spd.WorkDescriptionStatus as PerformancePercentage  from SHOP_PERFORMANCE sp INNER JOIN SHOP_PERFORMANCE_DETAILS spd on sp.Id=spd.shop_performance_id \r\n"
				+ "INNER JOIN EMPLOYEE e ON e.EmployeeID=spd.EmployeeId where sp.ShopNo=? and sp.PerformanceDate=? and spd.OT> 0 and sp.isOtVerified=1 order by spd.EmployeeNo", 1,REPORTS_TYPE.PDF, 6, new int[] {2, 3}, 0),
		NIGHT_OT_REPORT(11, "nightOtReport", "SELECT ROW_NUMBER() OVER(ORDER BY spd.EmployeeNo ASC) AS Row, spd.EmployeeNo,spd.JobNo, spd.WorkDescription, spd.WorkDescriptionStatus, sp.NightSupervision  from SHOP_PERFORMANCE sp INNER JOIN SHOP_PERFORMANCE_DETAILS spd on sp.Id=spd.shop_performance_id \r\n"
				+ "INNER JOIN EMPLOYEE e ON e.EmployeeID=spd.EmployeeId where sp.ShopNo=? and sp.PerformanceDate=? and spd.OT> 0  and sp.isOtVerified=1 order by spd.EmployeeNo", 1,REPORTS_TYPE.PDF, 6, new int[] {2, 3}, 1),
		ADVANCE_REPORT(12, "advanceReport", "SELECT ROW_NUMBER() OVER(ORDER BY spd.EmployeeNo ASC) AS Row, spd.EmployeeNo, e.Name,spd.JobNo, spd.WorkDescriptionStatus, spd.WorkDescription, sp.otApprovedBy, spd.AdvanceAmount  from SHOP_PERFORMANCE sp INNER JOIN SHOP_PERFORMANCE_DETAILS spd on sp.Id=spd.shop_performance_id \r\n"
				+ "INNER JOIN EMPLOYEE e ON e.EmployeeID=spd.EmployeeId where sp.ShopNo=? and sp.PerformanceDate=? and spd.AdvanceAmount> 0 and sp.IsOtApproved=1 order by spd.EmployeeNo", 1,REPORTS_TYPE.PDF, 6, new int[] {2, 3}, 0),
		ATTENDANCE_REPORT(13, "attendanceReport", "select attendance.attendanceDate, attendance.In1,attendance.Out1,attendance.In3,attendance.Out3, labor.* FROM (select CONVERT(VARCHAR(10), DDate, 121) as attendanceDate, la.* from Labour_Attendance la INNER JOIN Labour_Entries le ON le.EntryNo=la.EntryNo INNER JOIN EMPLOYEE e \r\n"
				+ "ON e.EmployeeID=le.EmployeeID INNER JOIN SHOP s ON s.ShopID=le.ShopID where e.EmployeeNo=? and s.Number=? and le.YYear=? and le.MMonth=?) attendance\r\n"
				+ "LEFT OUTER JOIN (select sp.PerformanceDate, spd.JobNo, spd.Nhrs, spd.OT  from SHOP_PERFORMANCE sp INNER JOIN SHOP_PERFORMANCE_DETAILS spd on sp.Id=spd.shop_performance_id\r\n"
				+ "INNER JOIN EMPLOYEE e ON e.EmployeeID=spd.EmployeeId where e.EmployeeNo=? and sp.ShopNo=? and YEAR(sp.PerformanceDate)=? and MONTH(sp.PerformanceDate)=?) labor \r\n"
				+ "ON attendance.attendanceDate=labor.PerformanceDate", 1,REPORTS_TYPE.EXCEL, 7, new int[] {2, 3, 4 , 5}, 0),
		PENDING_LOCAL_ORDER(14, "pendingLocalOrders", "SELECT l.*, i.longName as item, li.Quantity, li.EngEstimate FROM local_order l inner join local_order_item li on l.id=li.localorder_id inner join item i on i.id=li.item_id WHERE l.id NOT IN(SELECT localorder_id FROM register_order WHERE localorder_id IS NOT NULL) order by l.id",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		PENDING_STORES_ORDER(15, "pendingStoresOrders", "SELECT s.*, i.longName as item, si.Quantity, si.EngEstimate FROM stores_order s inner join stores_order_item si on s.id=si.storesorder_id inner join item i on i.id=si.item_id WHERE s.id NOT IN(SELECT storesorder_id FROM register_order WHERE storesorder_id IS NOT NULL) order by s.id",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		REGISTER_ORDER(16, "registerOrders", "SELECT r.*, i.longName as item,ri.Specification, ri.Tolerance, ri.Quantity, ri.EngEstimate FROM register_order r inner join register_order_item ri on r.id=ri.registerorder_id  inner join item i on i.id=ri.item_id  order by r.id",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		STOCK_DEVIATION(17, "stockDeviations", "SELECT  report.id, report.item, report.Name as Section,  report.UnitPrice, report.StartingStock, report.Grn, report.Reqisition, report.Cdn, report.Damages,  report.stock as StockVerification, c.NoOfItems as CurrentStock FROM (SELECT mg.Name,items.id, item.longName as Item, items.UnitPrice ,IFNULL(stock.NoOfItems,0) as StartingStock, IFNULL(stock.TotalValue,0) as StartingStockCost, IFNULL(grn.NoOfItems,0) as Grn, IFNULL(grn.TotalValue, 0) as GrnCost, IFNULL(reqisition .NoOfItems,0) as Reqisition, IFNULL(reqisition.TotalValue,0) as RequisitionCost,\r\n"
				+ "				IFNULL(cdn.NoOfItems,0) as Cdn, IFNULL(damages.NoOfItems,0) as Damages, IFNULL(cdn.TotalValue,0) as CdnCost, (IFNULL(stock.NoOfItems,0) + IFNULL(grn.NoOfItems, 0) + IFNULL(cdn.NoOfItems,0) - IFNULL(reqisition.NoOfItems,0) - IFNULL(damages.NoOfItems,0)) as Stock, (IFNULL(stock.TotalValue,0) + IFNULL(grn.TotalValue, 0) + IFNULL(cdn.TotalValue,0)- IFNULL(reqisition.TotalValue,0) - IFNULL(damages.TotalValue,0)) as TotalCost\r\n"
				+ "				FROM (select i.id, s.UnitPrice  from starting_stock s  inner join item i on s.item_id=i.id where s.isApproved=1\r\n"
				+ "				UNION\r\n"
				+ "				select  i.id,gi.UnitPrice  from grn_item gi inner join item i on gi.item_id=i.id where gi.isApproved=1 group by item_id, UnitPrice\r\n"
				+ "				UNION\r\n"
				+ "				select  i.id,c.UnitPrice  from cdn_item c inner join item i on c.item_id=i.id where c.isApproved=1 group by item_id, UnitPrice\r\n"
				+ "				UNION\r\n"
				+ "				select  i.id,r.UnitPrice  from remove_stock r inner join item i on r.item_id=i.id where r.isApproved=1 group by item_id, UnitPrice\r\n"
				+ "				UNION"
				+ "				SELECT  i.id,ri.UnitPrice FROM  requisition_item ri  inner join item i on ri.item_id=i.id  inner join requisition r on r.id=ri.requisition_id where ri.isApproved=1 and r.status<>'C' Group by item_id, UnitPrice ) items \r\n"
				+ "				left outer join (select i.id, i.longName as Item, s.UnitPrice as Rate,s.NoOfItems, s.UnitPrice*s.NoOfItems as TotalValue from starting_stock s  inner join item i on s.item_id=i.id where s.isApproved=1) stock on stock.id=items.id and stock.Rate=items.UnitPrice\r\n"
				+ "				left outer join (select  i.id,i.longName as Item,gi.UnitPrice as Rate,SUM(ReceivedQuantity - RejectedQuantity) as NoOfItems, SUM(ReceivedQuantity - RejectedQuantity) *gi.UnitPrice  as TotalValue from grn_item gi inner join item i on gi.item_id=i.id where gi.isApproved=1 group by item_id, UnitPrice) grn on items.id=grn.id and grn.Rate=items.UnitPrice\r\n"
				+ "				left outer join (SELECT  i.id,i.longName as Item,ri.UnitPrice as Rate, SUM(ri.Quantity) as NoOfItems, Sum(ri.UnitPrice* ri.Quantity) as TotalValue FROM  requisition_item ri inner join requisition r on r.id=ri.requisition_id inner join item i on ri.item_id=i.id where ri.isApproved=1 and ri.status<>'C' Group by item_id, UnitPrice) reqisition on items.id=reqisition.id and reqisition.Rate=items.UnitPrice\r\n"
				+ "				left outer join (SELECT  i.id,i.longName as Item,ci.UnitPrice as Rate, SUM(ci.Quantity) as NoOfItems, Sum(ci.UnitPrice* ci.Quantity) as TotalValue FROM  cdn_item ci  inner join item i on ci.item_id=i.id where ci.isApproved=1 Group by item_id, UnitPrice) cdn on items.id=cdn.id and cdn.Rate=items.UnitPrice\r\n"
				+ "				left outer join (SELECT  i.id,i.longName as Item,rs.UnitPrice as Rate, SUM(rs.removeNoOfItems) as NoOfItems, Sum(rs.UnitPrice* rs.removeNoOfItems) as TotalValue FROM  remove_stock rs  inner join item i on rs.item_id=i.id where rs.isApproved=1 Group by item_id, UnitPrice) damages on items.id=damages.id and damages.Rate=items.UnitPrice\r\n"
				+ "				inner join item on item.id=items.id inner join item_master im on im.id=item.item_master_id inner join material_type mt on im.material_type_id=mt.id inner join material_group  mg on mt.group_id=mg.id  order by mg.Name, item.longName) report inner join current_stock c on c.item_id=report.id and c.UnitPrice=report.UnitPrice where report.stock<>c.NoOfItems",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		REQUISITION_DETAILS(18, "requisitionsDetails", "SELECT  mg.name as Section,r.skNo as SKNo, r.RequisitionNo, r.DateCreated as RequisitionDate, i.longName as Item, ri.UnitPrice, ri.Quantity, r.Status FROM requisition r inner join requisition_item ri on ri.requisition_id=r.id  inner join item  i on i.id=ri.item_id inner join material_group mg on mg.id=r.section_id where mg.name Like ? order By r.RequisitionNo",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		NEGATIVE_STOCK(19, "negativeStock", "select i.longName, c.* from Current_Stock c inner join item i on i.id=c.item_id where NoOfItems<0 or tobeissued<0",0,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),;
		
		private int id;
		
		private String name;
		
		private String query;
		
		// If legacy db set to 1 else 0.
		private int db;
		
		private REPORTS_TYPE reportType;
		
		//Start row index. It'll insert record in the template from this row index
		private int startIndex;
		
		//This will be used to insert report params sent from front end, to report template.
		private int[] paramIndexes;
		
		//It'll ignore These columns from the end
		private int ignoreColumns;

		REPORTS(int id, String name, String query, int db, REPORTS_TYPE reportType, int startIndex, int[] paramIndexes, int ignoreColumns) {
			this.id = id;
			this.name = name;
			this.query = query;
			this.db = db;
			this.reportType = reportType;
			this.startIndex = startIndex;
			this.paramIndexes = paramIndexes;
			this.ignoreColumns = ignoreColumns;
		}

		public int getId() {
			return id;
		}
		
		public String getName() {
			return this.name;
		}
		
		public String getExcelName() {
			return this.name + System.currentTimeMillis() + Constants.XLSX;
		}
		
		public String getPdfName() {
			return this.name + System.currentTimeMillis() + Constants.PDF;
		}
		
		public static final REPORTS getByValue(int value){
		    return Arrays.stream(REPORTS.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(null);
		}

		public String getQuery() {
			return query;
		}

		public REPORTS_TYPE getReportType() {
			return reportType;
		}

		public int getDb() {
			return db;
		}


		public int getStartIndex() {
			return startIndex;
		}

		public int[] getParamIndexes() {
			return paramIndexes;
		}

		public int getIgnoreColumns() {
			return ignoreColumns;
		}

	}
	
	public enum DASHBOARD_CARDS {
		JOB_ANALITICS(1, "Job Analytics", "{call sp_Cumulative_Job_Dashboard (?, ?, ? ,? ,?)}",1,REPORTS_TYPE.EXCEL,1, new int[] {}, 0),
		;
		
		private int id;
		
		private String name;
		
		private String query;
		
		// If legacy db set to 1 else 0.
		private int db;
		
		private REPORTS_TYPE reportType;
		
		//Start row index. It'll insert record in the template from this row index
		private int startIndex;
		
		//This will be used to insert report params sent from front end, to report template.
		private int[] paramIndexes;
		
		//It'll ignore These columns from the end
		private int ignoreColumns;

		DASHBOARD_CARDS(int id, String name, String query, int db, REPORTS_TYPE reportType, int startIndex, int[] paramIndexes, int ignoreColumns) {
			this.id = id;
			this.name = name;
			this.query = query;
			this.db = db;
			this.reportType = reportType;
			this.startIndex = startIndex;
			this.paramIndexes = paramIndexes;
			this.ignoreColumns = ignoreColumns;
		}

		public int getId() {
			return id;
		}
		
		public String getName() {
			return this.name;
		}
		
	
		public static final DASHBOARD_CARDS getByValue(int value){
		    return Arrays.stream(DASHBOARD_CARDS.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(null);
		}

		public String getQuery() {
			return query;
		}

		public REPORTS_TYPE getReportType() {
			return reportType;
		}

		public int getDb() {
			return db;
		}


		public int getStartIndex() {
			return startIndex;
		}

		public int[] getParamIndexes() {
			return paramIndexes;
		}

		public int getIgnoreColumns() {
			return ignoreColumns;
		}

	}
	
	public enum OVERHEAD_TYPES{
	  ALLOH,
	  NOPOHAOH,
	  NOAOH,
	  NOOH;
	}
	
	public enum SHOP_TYPES{
	  ACTIVE,
	  INACTIVE,
	  INACTIVESPECIAL,
	  SPECIAL;
	}

	public static enum TEC_USER_TYPE {
		CHAIRMAN (1, "Chairman"),
		MEMBER (2, "Member"),
		OUTSIDE_MEMBER (3, "Outside Member");
		private int id;
		private String role;
		
		TEC_USER_TYPE(int id, String role){
			this.id = id;
			this.role = role;
		}
		
		public int getId() {
			return id;
		}
		
		public String getRole() {
			return role;
		}

	}

	public static enum LABOR_TYPE {
		NHRS (1),
		OT (2);
		private int id;

		LABOR_TYPE(int id){
			this.id = id;
		}
		
		public int getId() {
			return id;
		}
	}
	public static enum NOTIFICATION_TYPE {
		DEFAULT (0, "DEFAUTL", "/default/"),
		NEW_ITEM (1, "NEW_ITEM", "/itemmaster/"),
		NEW_MATERIAL_GROUP (2, "NEW_MATERIAL_GROUP", "/materialgroups/"),
		NEW_MATERIAL_TYPE (3, "NEW_MATERIAL_TYPE", "/materialtype/"),
		NEW_STORE (4, "NEW_STORE", "/store/"),
		NEW_RACK (5, "NEW_RACK", "/rack/"),
		NEW_BIN (6, "NEW_BIN", "/bin/"),
		NEW_REORDER_LEVEL (7, "NEW_REORDER_LEVEL", "/orderlevel/"),
		BUFFER_LEVEL_REACHED (8, "BUFFER_LEVEL_REACHED", "/orderlevel/"),
		REORDER_LEVEL_REACHED (9, "REORDER_LEVEL_REACHED", "/orderlevel/"),
		REORDERED (10, "REORDERED", "/storesorder/"),
		NEW_REMOVE_STOCK (11, "NEW_REMOVE_STOCK", "/removestock/"),
		NEW_GRN (12, "NEW_GRN", "/grn/"),
		GRN_QUALITY_VERIFIED (13, "GRN_QUALITY_VERIFIED", "/grn/"),
		GRN_PAYMENT_RECOMENDED (14, "GRN_PAYMENT_RECOMENDED", "/grn/"),
		NEW_STORES_ORDER (15, "NEW_STORES_ORDER", "/storesorder/"),
		NEW_MATERIAL_REQUEST (16, "NEW_MATERIAL_REQUEST", "/materialrequest/"),
		MR_REQUISITION (17, "MR_REQUISITION", "/requisition/"),
		MR_LOCAL_ORDER (18, "MR_LOCAL_ORDER", "/localorder/"),
		NEW_MANUAL_REQUISITION (19, "NEW_MANUAL_REQUISITION", "/requisition/"),
		NEW_EMPLOYEE_JOB_ALLOCATION (20, "NEW_EMPLOYEE_JOB_ALLOCATION", "/joballocation/"),
		NEW_JOB_ESTIMATE (21, "NEW_JOB_ESTIMATE", "/estimate/"),
		NEW_ORDER_LEVEL (22, "NEW_ORDER_LEVEL", "/orderlevel/"),
		NEW_REGISTER_ORDER (23, "NEW_REGISTER_ORDER", "/registerorder/"),
		RO_DGPENDING (24, "RO_DGPENDING", "/registerorder/"),
		RO_L1PENDING (25, "RO_L1PENDING", "/registerorder/"),
		NEW_QUOTATION (26, "NEW_QUOTATION", "/quotationandbidding/"),
		QUOTATION_DPCMAJOR_PENDING (27, "QUOTATION_DPCMAJOR_PENDING", "/quotationandbidding/"),
		QUOTATION_DGPENDING (28, "QUOTATION_DGPENDING", "/quotationandbidding/"),
		QUOTATION_TECPENDING (29, "QUOTATION_TECPENDING", "/quotationandbidding/"),
		QUOTATION_ISSUPO (30, "QUOTATION_ISSUPO", "/purchaseorder/"),
		NEW_MANUAL_GRN (31, "NEW_MANUAL_GRN", "/grn/"),
		NEW_VOUCHER (32, "NEW_VOUCHER", "/voucher/"),
		VOUCHER_APPROVAL (33, "VOUCHER_APPROVAL", "/voucher/"),
		VOUCHER_ISSUE_CHEQUES (34, "VOUCHER_ISSUE_CHEQUES", "/voucher/"),
		NEW_SUPPLIER (35, "NEW_SUPPLIER", "/supplier/"),
		NEW_CHECKROLL (36, "NEW_CHECKROLL", "/checkroll/"),
		NEW_ITEM_MASTER (37, "NEW_ITEM_MASTER", "/itemmaster/"),
		NEW_CDN (38, "NEW_CDN", "/cdn/"),
		NEW_ITEM_RECEIVED (39, "NEW_ITEM_RECEIVED", "/itemreceived/"),
		ITEM_RECEIVED_APPROVED (40, "ITEM_RECEIVED_VERFIED", "/itemreceived/"),
		NEW_CREDIT_NOTE (41, "NEW_CREDIT_NOTE", "/creditnote/"),
		PANDING_OT_APPROVAL (42, "PANDING_OT_APPROVAL", "/joballocation/"),
		PANDING_ADVANCEPAYMENT_APPROVAL (43, "PANDING_ADVANCEPAYMENT_APPROVAL", "/joballocation/"),
		ADVANCEPAYMENT_APPROVED (44, "ADVANCEPAYMENT_APPROVED", "/joballocation/"),
		PENDING_NHRS_VERIFICATION (45, "PANDING_NHRS_VERIFICATION", "/joballocation/"),
		PENDING_OT_VERIFICATION (46, "PANDING_OT_VERIFICATION", "/joballocation/"),
		RO_TECPENDING (47, "RO_TECPENDING", "/registerorder/"),
		QUOTATION_DPCMINOR_PENDING (48, "QUOTATION_DPCMINOR_PENDING", "/quotationandbidding/"),
		QUOTATION_DEL_PENDING (49, "QUOTATION_DEL_PENDING", "/quotationandbidding/"),
		QUOTATION_CEL_PENDING (50, "QUOTATION_CEL_PENDING", "/quotationandbidding/"),
		QUOTATION_SEL_PENDING (51, "QUOTATION_SEL_PENDING", "/quotationandbidding/"),
		MR_NEW_ITEM (52, "MR_NEW_ITEM", "/itemmasters/"),
		MR_UPDATED_NEW_ITEM (53, "MR_UPDATED_NEW_ITEM", "/itemmasters/"),
		CANCEL_REQUISITION (54, "CANCEL_REQUISITION", "/requisition/"),
		TEC_ASSIGNED (55, "TEC_ASSIGNED", "/registerorder/"),
		ESTIMATE_DGAPPROVE (56, "ESTIMATE_DGAPPROVE", "/jobestimate/"),
		ESTIMATE_DMAPPROVE (57, "ESTIMATE_DMAPPROVE", "/jobestimate/"),
		ESTIMATE_RECOMMENDED (58, "ESTIMATE_RECOMMENDED", "/jobestimate/"),
		ESTIMATE_CREATED (59, "ESTIMATE_CREATED", "/jobestimate/"),
		ESTIMATE_SUBMITTED (60, "ESTIMATE_SUBMITTED", "/jobestimate/"),
		ESTIMATE_DWAPPROVE (61, "ESTIMATE_DWAPPROVE", "/jobestimate/");
	    private int id;
	    private String name;
	    private String url;
	    
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		NOTIFICATION_TYPE(int id, String name, String url){
			this.id = id;
			this.name = name;
			this.url = url;
		}
		
		public int getId() {
			return id;
		}
		
		public String getUrl() {
			return url;
		}
		
	};
	
	public static enum JASPER_REPORT {
		DEFAULT (0, "DEFAUTL", "default.jrxml"),
		LOCAL_ORDER (1, "LOCAL_ORDER", "local_order.jrxml"),
		DISTRIBUTION_OF_QUOTATIONS (2, "DISTRIBUTION_OF_QUOTATIONS", "distribution_of_quotation.jrxml"),
		QUOTATION (3, "QUOTATION", "quotation/quotation.jrxml"),
		PURCHASE_ORDER (4, "PURCHASE_ORDER", "purchaseorder/purchaseorder.jrxml"),
		ITEM_RECEIVED (5, "ITEM_RECEIVED", "itemreceived/issueitems.jrxml"),
		PAYMENTS (6, "PAYMENTS", "payments/payment_for_supply.jrxml"),
		OPENING_SUMMARY (7, "OPENING_SUMMARY", "bid/opening_summary.jrxml"),
		SUMMARY_SHEET (8, "SUMMARY_SHEET", "regisetrorder/summary_sheet.jrxml"),
		PROC_COMMITEE_MINITS_MAJOR (9, "PROC_COMMITEE_MINITS_MAJOR", "minutes/major/summary_sheet.jrxml"),
		PROC_COMMITEE_MINITS_MINOR (10, "PROC_COMMITEE_MINITS_MINOR", "minutes/minor/summary_sheet.jrxml"),
		EMPTY_QUOTATION (11, "EMPTY_QUOTATION", "emptyquotation/quotation.jrxml"),
		POS (12, "POS", "pos/invoice.jrxml"),;
	    private int id;
	    private String name;
	    private String path;
	    
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		JASPER_REPORT(int id, String name, String path){
			this.id = id;
			this.name = name;
			this.path = path;
		}
		
		public int getId() {
			return id;
		}
		
		public String getPath() {
			return path;
		}
		
	};
	
	
	public static enum ProcurementStatus{
		;
		public interface Level{
			public int get();
		}
		public static enum Initiation implements Level{
			Default(0, new int[] {0}, 0),
			Rejected(1,new int[] {0}, 0),
		    Initiated(2,new int[] {3}, 1),
		    Approved(3, new int[] {12, 22}, 1);
			
		    private int id;
		    private int nextLevel[];
		    private int rejectedLevel;
		    
			Initiation(int id, int nextLevel[], int rejectedLevel){
				this.id = id;
				this.nextLevel = nextLevel;
				this.rejectedLevel = rejectedLevel;
			}
			
			public int get() {
				return id;
			}
			
			public int[] getNextLevel() {
				return nextLevel;
			}
			
			public static final Initiation getByValue(int value){
			    return Arrays.stream(Initiation.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(Default);
			}
		};
		
		public static enum L1Approval implements Level{
			Default(10, new int[] {0}, 0),
		    L1Rejected(11, new int[] {2}, 1),
		    L1Pending(12, new int[] {13}, 11),
		    L1Approved(13, new int[] {32}, 11);
			
		    private int id;
		    private int nextLevel[];
		    private int rejectedLevel;
		    
		    L1Approval(int id, int nextLevel[], int rejectedLevel){
				this.id = id;
				this.nextLevel = nextLevel;
				this.rejectedLevel = rejectedLevel;
			}
		    
		    public int get() {
				return id;
			}
			
			public int[] getNextLevel() {
				return nextLevel;
			}
			
			public static final L1Approval getByValue(int value){
			    return Arrays.stream(L1Approval.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(Default);
			}
		};
		
		
		public static enum L2Approval implements Level{
			Default(20, new int[] {0}, 0),
		    L2Rejected(21, new int[] {12}, 12),
		    AppointTec(22, new int[] {23}, 21),
		    PrepareBidDocument(23, new int[] {24}, 21),
		    PrepareQuotation(24, new int[] {25}, 21),
		    Scrutinizing(25, new int[] {26}, 21),
		    SelectSuppliers(26, new int[] {27}, 21),
		    L2Pending(27, new int[] {28}, 21),
		    L2Approved(28, new int[] {42}, 21);
			
		    private int id;
		    private int nextLevel[];
		    private int rejectedLevel;
		    
		    L2Approval(int id, int nextLevel[], int rejectedLevel){
				this.id = id;
				this.nextLevel = nextLevel;
				this.rejectedLevel = rejectedLevel;
			}		
			public int get() {
				return id;
			}
			public int[] getNextLevel() {
				return nextLevel;
			}
			public static final L2Approval getByValue(int value){
			    return Arrays.stream(L2Approval.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(Default);
			}
		};
		

		public static enum DGLevelApproval implements Level{
			Default(30, new int[] {0}, 0),
			DGLevelRejected(31, new int[] {12}, 12),
			PrepareQuotation(32, new int[] {33}, 31),
			Scrutinizing(33, new int[] {34}, 31),
			SelectSuppliers(34, new int[] {35}, 31),
			DGLevelPending(35, new int[] {36}, 31),
			DGLevelApproved(36, new int[] {42}, 31);
			
		    private int id;
		    private int nextLevel[];
		    private int rejectedLevel;
		    
		    DGLevelApproval(int id, int nextLevel[], int rejectedLevel){
				this.id = id;
				this.nextLevel = nextLevel;
				this.rejectedLevel = rejectedLevel;
			}	
			public int get() {
				return id;
			}
			public int[] getNextLevel() {
				return nextLevel;
			}
			public static final DGLevelApproval getByValue(int value){
			    return Arrays.stream(DGLevelApproval.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(Default);
			}
		}
		
		public static enum PostProcurement implements Level{
			Default(40, new int[] {0}, new int[] {0}),
			Rejected(41, new int[] {12, 26, 35},  new int[] {0}),
		    CallingBidsQuotations(42, new int[] {43, 46},  new int[] {41}),
		    BidOpeningAttendance(43, new int[] {44}, new int[] {42, 99999}),
		    BidOpeningMinutes(44, new int[] {45}, new int[] {43, 99999}),
		    BidOpeningFinancialInfo(45, new int[] {46}, new int[] {44, 99999}),
		    TecRecommendation(46, new int[] {47}, new int[] {45, 99999}),
		    PrepareSummary(47, new int[] {48}, new int[] {46, 99999}),
		    SupplierSelection(48, new int[] {50, 49}, new int[] {46, 99999}),
		    DGLevelPending(49, new int[] {51}, new int[] {46, 99999}),
		    L2Pending(50, new int[] {51}, new int[] {47, 99999}),
		    Approved(51, new int[] {62}, new int[] {42, 99999});
		    
		    private int id;
		    private int nextLevel[];
		    private int rejectedLevel[];
		    
		    PostProcurement(int id, int nextLevel[], int rejectedLevel[]){
				this.id = id;
				this.nextLevel = nextLevel;
				this.rejectedLevel = rejectedLevel;
			}
			public int get() {
				return id;
			}
			public int[] getNextLevel() {
				return nextLevel;
			}
			public static final PostProcurement getByValue(int value){
			    return Arrays.stream(PostProcurement.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(Default);
			}
		};
		
		public static enum POAndPayments implements Level{
			Default(70, new int[] {0}, new int[] {0}),
			Rejected(71, new int[] {47},  new int[] {0}),
		    IssuePO(72, new int[] {73}, new int[] {42, 99999}),
		    GRN(73, new int[] {74}, new int[] {42,99999}),
		    QualityChecking(74, new int[] {75}, new int[] {99999}),
		    PaymentRecommendation(75, new int[] {76}, new int[] {72}),
		    PrepareVoucher(76, new int[] {77}, new int[] {70}),
		    ApproveVoucher(77, new int[] {78}, new int[] {71}),
		    IssueChecks(78, new int[] {79}, new int[] {71}),
			Completed(79, new int[] {79}, new int[] {0});
		    
		    private int id;
		    private int nextLevel[];
		    private int rejectedLevel[];
		    
		    POAndPayments(int id, int nextLevel[], int rejectedLevel[]){
				this.id = id;
				this.nextLevel = nextLevel;
				this.rejectedLevel = rejectedLevel;
			}
			public int get() {
				return id;
			}
			public int[] getNextLevel() {
				return nextLevel;
			}
			public static final POAndPayments getByValue(int value){
			    return Arrays.stream(POAndPayments.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(Default);
			}
		};
		
		public static enum L1RegisterOrder implements Level{
			Default(10, new int[] {0}, 0),
			L1RegisterOrderCancel(11, new int[] {2}, 1),
			SelectSuppliers(12, new int[] {13}, 21),
			Specification(13, new int[] {14}, 21),
			PrepareQuotation(14, new int[] {15}, 21),
		    L1Pending(15, new int[] {16}, 11),
		    L1Approved(16, new int[] {42}, 11);
			
		    private int id;
		    private int nextLevel[];
		    private int rejectedLevel;
		    
		    L1RegisterOrder(int id, int nextLevel[], int rejectedLevel){
				this.id = id;
				this.nextLevel = nextLevel;
				this.rejectedLevel = rejectedLevel;
			}
		    
		    public int get() {
				return id;
			}
			
			public int[] getNextLevel() {
				return nextLevel;
			}
			
			public static final L1RegisterOrder getByValue(int value){
			    return Arrays.stream(L1RegisterOrder.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(Default);
			}
		};
		
		public static enum L2RegisterOrder implements Level{
			Default(20, new int[] {0}, 0),
		    L2Rejected(21, new int[] {12}, 12),
		    AppointTec(22, new int[] {23}, 21),
		    SelectSuppliers(23, new int[] {24}, 21),
		    TimeSchedule(24, new int[] {25}, 21),
		    Specification(25, new int[] {26}, 21),
		    PrepareQuotation(26, new int[] {27}, 21),
		    PrepareBidDocument(27, new int[] {30}, 21),
		    TECProcurementApprovalPending(28, new int[] {29}, 21),
		    TECProcurementApproved(29, new int[] {30}, 21),
		    DGApprovalPending(30, new int[] {53}, 21),
		    DGRejected(31, new int[] {21}, 22);
			
		    private int id;
		    private int nextLevel[];
		    private int rejectedLevel;
		    
		    L2RegisterOrder(int id, int nextLevel[], int rejectedLevel){
				this.id = id;
				this.nextLevel = nextLevel;
				this.rejectedLevel = rejectedLevel;
			}		
			public int get() {
				return id;
			}
			public int[] getNextLevel() {
				return nextLevel;
			}
			public static final L2RegisterOrder getByValue(int value){
			    return Arrays.stream(L2RegisterOrder.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(Default);
			}
		};
		
		public static enum L1Quotation implements Level{
			Default(40, new int[] {0}, new int[] {0}),
			Rejected(41, new int[] {12, 26, 35},  new int[] {0}),
		    CallingQuotations(42, new int[] {43},  new int[] {41}),
		    QuotationOpeningAttendance(43, new int[] {44},  new int[] {41}),
		    QuotationOpeningMinutes(44, new int[] {45},  new int[] {41}),
		    QuotationOpeningFinancialInfo(45, new int[] {46},  new int[] {41}),
		    UserRecommendation(46, new int[] {47}, new int[] {45, 99999}),
		    PrepareSummary(47, new int[] {48}, new int[] {46, 99999}),
		    SupplierSelection(48, new int[] {49}, new int[] {46, 99999}),
		    PendingApproval(49, new int[] {50}, new int[] {46, 99999}),
		    Approved(50, new int[] {72}, new int[] {42, 99999});
		    
		    private int id;
		    private int nextLevel[];
		    private int rejectedLevel[];
		    
		    L1Quotation(int id, int nextLevel[], int rejectedLevel[]){
				this.id = id;
				this.nextLevel = nextLevel;
				this.rejectedLevel = rejectedLevel;
			}
			public int get() {
				return id;
			}
			public int[] getNextLevel() {
				return nextLevel;
			}
			public static final L1Quotation getByValue(int value){
			    return Arrays.stream(L1Quotation.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(Default);
			}
		};
		
		public static enum L2Quotation implements Level{
			Default(51, new int[] {0}, new int[] {0}),
			Rejected(52, new int[] {12},  new int[] {0}),
		    CallingBids(53, new int[] {54},  new int[] {41}),
		    BidOpeningAttendance(54, new int[] {55}, new int[] {42, 99999}),
		    BidOpeningMinutes(55, new int[] {56}, new int[] {43, 99999}),
		    BidOpeningFinancialInfo(56, new int[] {57}, new int[] {44, 99999}),
		    TecRecommendation(57, new int[] {58}, new int[] {45, 99999}),
		    PrepareSummary(58, new int[] {59}, new int[] {46, 99999}),
		    SupplierSelection(59, new int[] {60}, new int[] {46, 99999}),
		    PendingApproval(60, new int[] {61}, new int[] {46, 99999}),
		    Approved(61, new int[] {72}, new int[] {42, 99999});
		    
		    private int id;
		    private int nextLevel[];
		    private int rejectedLevel[];
		    
		    L2Quotation(int id, int nextLevel[], int rejectedLevel[]){
				this.id = id;
				this.nextLevel = nextLevel;
				this.rejectedLevel = rejectedLevel;
			}
			public int get() {
				return id;
			}
			public int[] getNextLevel() {
				return nextLevel;
			}
			public static final L2Quotation getByValue(int value){
			    return Arrays.stream(L2Quotation.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(Default);
			}
		};
//	    L1Approval,
//	    L2Approval,
//	    PostProcurement
	}
	public static enum EstimateStatus{
			Default(0, new int[] {0}, 0),
			Creation(1,new int[] {2}, 0),
		    Verify(2,new int[] {3}, 1),
		    DmApproval(3, new int[] {4, 5}, 2),
		    DwApproval(4, new int[] {6}, 3),
		    DgApproval(5, new int[] {6}, 3);
			
		    private int id;
		    private int nextLevel[];
		    private int rejectedLevel;
		    
		    EstimateStatus(int id, int nextLevel[], int rejectedLevel){
				this.id = id;
				this.nextLevel = nextLevel;
				this.rejectedLevel = rejectedLevel;
			}
			
			public int get() {
				return id;
			}
			
			public int[] getNextLevel() {
				return nextLevel;
			}
			
			public static final EstimateStatus getByValue(int value){
			    return Arrays.stream(EstimateStatus.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(Default);
			}

			public int getRejectedLevel() {
				return rejectedLevel;
			}
	}
	
	//Default - 0
	//Tender - 1
	//Private Sector - 2
	public static enum EstimateType{
		Default(0),
		Tender(1),
		PrivateSector(2);
		
	    private int id;
	    
	    EstimateType(int id){
			this.id = id;
		}
		
		public int get() {
			return id;
		}

		public static final EstimateType getByValue(int value){
		    return Arrays.stream(EstimateType.values()).filter(enumRole -> enumRole.id == value).findFirst().orElse(Default);
		}
	}
	public static final boolean TEST_RUN_WITH_ACTUALS = true;
}
